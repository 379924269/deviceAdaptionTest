package com.dnp.attend.util.commons.swaggerConfig;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.dnp.attend.controller"})
// 必须存在 扫描的API Controller package name 也可以直接扫描class (basePackageClasses)
public class ApplicationSwaggerConfig {

    // @Bean
    // public Docket configSpringfoxDocketForAll() {
    // return new Docket(DocumentationType.SWAGGER_2)
    // .produces(Sets.newHashSet(MediaType.TEXT_HTML_VALUE,
    // MediaType.APPLICATION_JSON_UTF8_VALUE))
    // .consumes(Sets.newHashSet(MediaType.TEXT_HTML_VALUE,
    // MediaType.APPLICATION_JSON_UTF8_VALUE))
    // .protocols(Sets.newHashSet("http"/*, "https"*/))
    // .forCodeGeneration(true)
    // .select().paths(regex(".*"))
    // .build()
    // .apiInfo(apiInfo());
    // }
    //
    // private ApiInfo apiInfo() {
    // @SuppressWarnings("deprecation")
    // ApiInfo apiInfo = new ApiInfo(
    // "适配（deviceAdaption） API文档",
    // "使用Swagger UI构建SpringMVC REST风格的可视化文档。  注意：“大多接口的访问都要登陆（“用户API”的登陆接口登陆），如果没有权限请联系管理员”。",
    // "1.0.0",
    // "http://127.0.0.1:80/mybatis-spring/v2/api-docs",
    // "",
    // "",
    // ""
    // );
    // return apiInfo;
    // }
//	@Bean
//	public Docket customDocket() {
//		//
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
//	}
//
//	private ApiInfo apiInfo() {
//		// Contact contact = new Contact("华仔", "", "379924269@qq.com");
//		Contact contact = new Contact("", "", "");
//		return new ApiInfo("适配（deviceAdaption） API文档",// 大标题 title
//				"使用Swagger UI构建SpringMVC REST风格的可视化文档。  注意：“大多接口的访问都要登陆（“用户API”的登陆接口登陆），如果没有权限请联系管理员",// 小标题
//				"3.0",// 版本
//				"http://127.0.0.1:80/attend/v2/api-docs",// termsOfServiceUrl
//				contact,// 作者
//				"",// 链接显示文字
//				""// 网站链接
//		);
//	}
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
//                .apis(RequestHandlerSelectors.basePackage("com.dnp.modular.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("deviceAdaption")
                .description("适配项目 Api文档")
                .termsOfServiceUrl("https://github.com/379924269/deviceAdaptionTest")
                .contact("华仔")
                .version("2.0")
                .build();
    }
}
