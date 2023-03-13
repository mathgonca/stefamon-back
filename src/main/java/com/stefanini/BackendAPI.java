package com.stefanini;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
@OpenAPIDefinition(
        info = @Info(
                title = "Stefamon API",
                version = "v1.0.0",
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html")),
        security = @SecurityRequirement(name = "bearerAuth"),
        components = @Components(
                securitySchemes = @SecurityScheme(
                        securitySchemeName = "bearerAuth",
                        type = SecuritySchemeType.HTTP,
                        scheme = "bearer",
                        bearerFormat = "JWT"
                )
        )
)
public class BackendAPI extends Application {
}
