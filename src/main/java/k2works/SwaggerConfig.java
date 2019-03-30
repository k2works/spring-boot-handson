package k2works;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("echo-service").select().paths(paths()).build()
                .apiInfo(makeApiInfo());
    }

    private Predicate<String> paths() {
        return Predicates.or(Predicates.containsPattern("/v1/echo"), Predicates.containsPattern("/v1/status"));
    }

    private ApiInfo makeApiInfo() {
        return new ApiInfo("studying SpringBoot service", // title
                "", // description
                "v1", // version
                "", // terms of service url
                new Contact("DreamArts", "https://www.dreamarts.co.jp", ""), //
                "", // license
                "", // license url
                Collections.emptyList());
    }
}

