package org.example.testjwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.testjwt.model.JwtPayload;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtValidation {

    private static final Log LOG = LogFactory.getLog(JwtValidation.class);
    public boolean validateJwtToken(String token) {

        try{

            DecodedJWT decodedJWT = JWT.decode(token);
            JwtPayload jwtPayload = new JwtPayload();

            jwtPayload.setDetails(decodedJWT.getClaims().entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey , e-> e.getValue().asString())));

            LOG.debug("PAYLOAD: " + jwtPayload);

            return validadeClaimsName(jwtPayload)
                    && validateClaimNameIsNumeric(jwtPayload)
                    && validateClaimRoleNames(jwtPayload)
                    && validadeMaxClaimNameChars(jwtPayload)
                    && validadeSeedValue(jwtPayload);
        } catch (Exception exception) {
            return false;
        }
    }

    private boolean validadeClaimsName(JwtPayload jwtPayload) {
        Collection<String> keys = Set.of("Role", "Seed", "Name");
        return keys.containsAll(jwtPayload.getDetails().keySet());
    }

    private boolean validateClaimNameIsNumeric(JwtPayload jwtPayload) {
        return !jwtPayload.getDetails().get("Name").toString().chars().anyMatch(Character::isDigit);
    }
    private boolean validateClaimRoleNames(JwtPayload jwtPayload) {
        Collection<String> keys = Set.of("Admin", "Member", "External");
        return keys.contains(jwtPayload.getDetails().get("Role"));
    }

    private boolean validadeSeedValue(JwtPayload jwtPayload) {
        return isPrimeNumber(Integer.parseInt(jwtPayload.getDetails().get("Seed").toString()));
    }

    private boolean validadeMaxClaimNameChars(JwtPayload jwtPayload) {
        return jwtPayload.getDetails().get("Name").length() <= 256;
    }

    private boolean isPrimeNumber(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
