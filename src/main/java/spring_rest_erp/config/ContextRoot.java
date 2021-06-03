package spring_rest_erp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class,ContextSqlSession.class,MvcConfig.class})
@ComponentScan(basePackages = {
		"spring_rest_erp.service",
		"spring_rest_erp.controller"
		})
public class ContextRoot {

}
