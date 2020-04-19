package com.jsonparser;

import com.jsonparser.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class JsonParserApi {

	public static void main(String[] args) {
		SpringApplication.run(JsonParserApi.class, args);
	}

}
