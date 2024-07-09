package org.example.testjwt.domain;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtPayload {

    private Map<String, String> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, String value) {
        details.put(key, value);
    }
}
