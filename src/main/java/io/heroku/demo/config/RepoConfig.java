package io.heroku.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

//tell Spring how to actually populate the repository with the file

/**
 * This class is used to create a new repository populator oject based on 
 * Jackson - a library that can be used to parse JSON into Java objects.
 * This populator will read the students.json file created previously, parse 
 * it into Student objects, and store them in Redis
 * 
 * This class also uses an annontation 'EnableRedishRepositories' that tells
 * Spring that the repo uses a Redis datastore, and to look for a connection
 * @author anhtranx
 *
 */

@Configuration
@EnableRedisRepositories
public class RepoConfig {
	@Bean
	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
		Resource sourceData = new ClassPathResource("students.json");
		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		
		//Set a custom ObjectMapper if Jackson customization is needed
		factory.setResources(new Resource[] { sourceData });
		return factory;
	}

}
