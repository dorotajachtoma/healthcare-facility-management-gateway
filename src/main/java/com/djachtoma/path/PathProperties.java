package com.djachtoma.path;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(value = "healthcare.facility.path" )
public class PathProperties {

    private String patientPath;
    private String hospitalPath;
    private String doctorPath;
    private String rxPath;
    private String appointmentPath;
}
