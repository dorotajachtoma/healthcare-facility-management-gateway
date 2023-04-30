package com.djachtoma.host;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(value = "healthcare.facility.host")
public class HostProperties {

    private String patientHost;
    private String hospitalHost;
    private String doctorHost;
    private String rxHost;
    private String appointmentHost;
}
