package unifacef.costumerapi.configurations.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurations {
    private static final String BASE_PACKAGE = "unifacef.costumerapi.gateways.inputs.http";

    public Docket apis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .groupName("costumer-api")
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo());

    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("Unifacef - Costumer Api")
                .description("API para cadastro de clientes")
                .version("1")
                .build();
    }

}
