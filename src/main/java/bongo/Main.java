package bongo;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public GroupedOpenApi singleApi() {
		return GroupedOpenApi.builder()
				.group("hms")
				.pathsToMatch("/api/**")
				.build();
	}

	@Bean
	public OpenAPI hrApi() {
		return new OpenAPI()
			.info(new Info()
				.title("HR Management System API")
				.description("View and manage employees of company")
				.version("v0.1")
			)
			.externalDocs(new ExternalDocumentation()
				.description("HR Management System Documentation")
				.url("http://localhost:8080/docs")
			);
	}
}
