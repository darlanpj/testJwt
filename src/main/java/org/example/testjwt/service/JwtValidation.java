package org.example.testjwt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.testjwt.domain.JwtPayload;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collection;
import java.util.Set;

@Component
public class JwtValidation {

    private ObjectMapper mapper = new ObjectMapper();
    private static final Log LOG = LogFactory.getLog(JwtValidation.class);

    public boolean validateJwtToken(String token) {

        try{
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String[] chunks = token.split("\\.");

            String payload = new String(decoder.decode(chunks[1]));
            LOG.info("PAYLOAD: " + payload);

            JwtPayload jwtPayload = mapper.readValue(payload, JwtPayload.class);

            LOG.info("PAYLOAD MAPPERS: " + jwtPayload.toString());
            return validadeClaimsName(jwtPayload)
                    && validateClaimNameIsNotNumeric(jwtPayload)
                    && validateClaimRoleNames(jwtPayload)
                    && validadeMaxClaimNameChars(jwtPayload)
                    && validadeSeedValue(jwtPayload);
        } catch (Exception exception) {
            return false;
        }
    }

    private boolean validadeClaimsName(JwtPayload jwtPayload) {
        Collection<String> keys = Set.of("Role", "Seed", "Name");
        LOG.info(jwtPayload.getDetails().keySet().containsAll(keys));
        return keys.containsAll(jwtPayload.getDetails().keySet());
    }

    private boolean validateClaimNameIsNotNumeric(JwtPayload jwtPayload) {
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
