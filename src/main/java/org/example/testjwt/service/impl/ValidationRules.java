package org.example.testjwt.service.impl;

import org.example.testjwt.model.JwtPayload;

public interface ValidationRules {

    boolean validadeClaimsName(JwtPayload jwtPayload);

    boolean validateClaimNameIsNumeric(JwtPayload jwtPayload);

    boolean validateClaimRoleNames(JwtPayload jwtPayload);

    boolean validadeSeedValue(JwtPayload jwtPayload);

    boolean validadeMaxClaimNameChars(JwtPayload jwtPayload);

    boolean isPrimeNumber(int n);
}
