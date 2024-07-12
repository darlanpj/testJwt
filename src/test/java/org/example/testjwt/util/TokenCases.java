package org.example.testjwt.util;

public class TokenCases {

    //Jwt validation ok
    public static final String TOKEN_CASE_1 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

    //Invalid token"
    public static final String TOKEN_CASE_2 = "eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";

    //Claim Name has Numeric
    public static final String TOKEN_CASE_3 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs";

    //More claims not permitted
    public static final String TOKEN_CASE_4 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY";

    //Seed not prime number
    public static final String TOKEN_CASE_5 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNjY4OCIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.9mbvr8JJSR5yoBszmW0c_ZaBtuyYdt5VTVcXXZscQCE";

    //Invalid role name
    public static final String TOKEN_CASE_6 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiVG9uaW5obyBBcmF1am8ifQ.dcRCV801ODEwMmLOJPtkNiJ-QYZKBp8Ob3fRyqkLLRM";

    //claim name exceeds 256 characters
    public static final String TOKEN_CASE_7 = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRGFybGFuIiwiU2VlZCI6Ijc4NDEiLCJOYW1lIjoiTG9yZW0gaXBzdW0gZG9sb3Igc2l0IGFtZXQsIGNvbnNlY3RldHVyIGFkaXBpc2NpbmcgZWxpdCwgc2VkIGRvIGVpdXNtb2QgdGVtcG9yIGluY2lkaWR1bnQgdXQgbGFib3JlIGV0IGRvbG9yZSBtYWduYSBhbGlxdWEuIFV0IGVuaW0gYWQgbWluaW0gdmVuaWFtLCBxdWlzIG5vc3RydWQgZXhlcmNpdGF0aW9uIHVsbGFtY28gbGFib3JpcyBuaXNpIHV0IGFsaXF1aXAgZXggZWEgY29tbW9kbyBjb25zZXF1YXQuIER1aXMgYXV0ZSBpcnVyZSBkb2xvciBpbiByZXByZWhlbmRlcml0IGluIHZvbHVwdGF0ZSB2ZWxpdCBlc3NlIGNpbGx1bSBkb2xvcmUgZXUgZnVnaWF0IG51bGxhIHBhcmlhdHVyLiJ9.UyAplTu1f_hnHKwIr-Z5pBk8YVtSMh5RRJN3LCCJI80";

}
