package com.djachtoma.route;

import com.djachtoma.host.HostProperties;
import com.djachtoma.http.HttpProtocol;
import com.djachtoma.path.PathProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.djachtoma.route.RouteID.*;

@Configuration
@RequiredArgsConstructor
public class RouteConfiguration {

    private final HostProperties hostProperties;
    private final PathProperties pathProperties;

    @Bean
    public RouteLocator patientRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(PATIENT_ROUTE.name(), route -> route.host(hostProperties.getPatientHost())
                        .and()
                        .path(pathProperties.getPatientPath())
                        .uri(HttpProtocol.HTTP_NO_SECURE_LAYER.getProtocol() + hostProperties.getPatientHost()))
                .build();
    }

    @Bean
    public RouteLocator hospitalRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(HOSPITAL_ROUTE.name(), route -> route.host(hostProperties.getHospitalHost())
                        .and()
                        .path(pathProperties.getHospitalPath())
                        .uri(HttpProtocol.HTTP_NO_SECURE_LAYER.getProtocol() + hostProperties.getHospitalHost()))
                .build();
    }

    @Bean
    public RouteLocator doctorRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(DOCTOR_ROUTE.name(), route -> route.host(hostProperties.getDoctorHost())
                        .and()
                        .path(pathProperties.getDoctorPath())
                        .uri(HttpProtocol.HTTP_NO_SECURE_LAYER.getProtocol() + hostProperties.getDoctorHost()))
                .build();
    }

    @Bean
    public RouteLocator rxRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(RX_ROUTE.name(), route -> route.host(hostProperties.getRxHost())
                        .and()
                        .path(pathProperties.getRxPath())
                        .uri(HttpProtocol.HTTP_NO_SECURE_LAYER.getProtocol() + hostProperties.getRxHost()))
                .build();
    }

    @Bean
    public RouteLocator appointmentRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(APPOINTMENT_ROUTE.name(), route -> route.host(hostProperties.getAppointmentHost())
                        .and()
                        .path(pathProperties.getAppointmentPath())
                        .uri(HttpProtocol.HTTP_NO_SECURE_LAYER.getProtocol() + hostProperties.getAppointmentHost()))
                .build();
    }
}
