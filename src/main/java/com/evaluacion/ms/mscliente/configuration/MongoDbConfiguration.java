package com.evaluacion.ms.mscliente.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = { "com.evaluacion.ms.mscliente.repository" },
    repositoryImplementationPostfix = "ExtensionImpl"
)
public class MongoDbConfiguration {

}
