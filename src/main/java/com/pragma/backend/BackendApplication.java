package com.pragma.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Health;
import java.time.Duration;

@SpringBootApplication
@EnableConfigurationProperties
@EnableRetry
@EnableAsync
public class BackendApplication {
    private static final Logger logger = LoggerFactory.getLogger(BackendApplication.class);
    private final ApplicationProperties applicationProperties;

    public BackendApplication(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
        validateProperties();
    }

    public static void main(String[] args) {
        try {
            var context = SpringApplication.run(BackendApplication.class, args);
            logger.info("Aplicación iniciada con éxito en el perfil: {}", 
                      String.join(",", context.getEnvironment().getActiveProfiles()));
            logger.info("Configuración de Resilience4j: CircuitBreaker={}, Retry={}",
                      context.containsBean("circuitBreaker"), 
                      context.containsBean("retry"));
        } catch (Exception e) {
            logger.error("Error al iniciar la aplicación", e);
            throw new ApplicationStartupException("Falló el inicio de la aplicación", e);
        }
    }

    private void validateProperties() {
        if (applicationProperties.getDatabase().getUrl() == null || 
            applicationProperties.getDatabase().getUrl().isBlank()) {
            throw new IllegalStateException("La URL de la base de datos no puede estar vacía");
        }
        if (applicationProperties.getCircuitBreaker().getFailureRateThreshold() < 1 || 
            applicationProperties.getCircuitBreaker().getFailureRateThreshold() > 100) {
            throw new IllegalStateException("El umbral de fallos del CircuitBreaker debe estar entre 1 y 100");
        }
    }

    @Bean
    public CircuitBreaker circuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(applicationProperties.getCircuitBreaker().getFailureRateThreshold())
                .waitDurationInOpenState(Duration.ofSeconds(applicationProperties.getCircuitBreaker().getWaitDurationInOpenState()))
                .permittedNumberOfCallsInHalfOpenState(applicationProperties.getCircuitBreaker().getPermittedNumberOfCallsInHalfOpenState())
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(applicationProperties.getCircuitBreaker().getSlidingWindowSize())
                .recordExceptions(Exception.class)
                .build();
        return CircuitBreaker.of("clientServiceCircuitBreaker", config);
    }

    @Bean
    public Retry retry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(applicationProperties.getRetry().getMaxAttempts())
                .waitDuration(Duration.ofMillis(applicationProperties.getRetry().getWaitDuration()))
                .retryExceptions(Exception.class)
                .build();
        return Retry.of("clientServiceRetry", config);
    }

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> {
            try {
                // Simulación de verificación de salud de la base de datos
                if (applicationProperties.getDatabase().getUrl().contains("postgresql")) {
                    return Health.up().withDetail("database", "PostgreSQL disponible").build();
                }
                return Health.down().withDetail("database", "Tipo de base de datos no soportado").build();
            } catch (Exception e) {
                return Health.down(e).build();
            }
        };
    }

    public static class ApplicationStartupException extends RuntimeException {
        public ApplicationStartupException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}