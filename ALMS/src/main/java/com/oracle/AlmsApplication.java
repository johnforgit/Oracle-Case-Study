package com.oracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
		info=@Info(
				title="ALMS_API",
				version="1.0",
				description="API documentation for managing asset liability management system"
		)
)
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableDiscoveryClient(autoRegister=true)
public class AlmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmsApplication.class, args);
	}

}
