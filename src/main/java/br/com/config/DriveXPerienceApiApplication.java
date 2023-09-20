package br.com.config;

import jakarta.ws.rs.ApplicationPath;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/api")
@OpenAPIDefinition(
        tags = {
                @Tag(name = "widget", description = "Widget operations."),
                @Tag(name = "gasket", description = "Operations related to gaskets")
        },
        info = @Info(
                title = "DriveXPerience Quarkus API",
                version = "1.0.1",
                contact = @Contact(
                        name = "DriveXPerience API Support",
                        url = "http://exampleurl.com/contact",
                        email = "techsupport@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"),
                description = "I'm migrating my API from Node.js to Java, utilizing Quarkus, in order to learn Java development. While it won't be an exact replica, this project will serve as a valuable learning experience."
        )
)
public class DriveXPerienceApiApplication  {
}
