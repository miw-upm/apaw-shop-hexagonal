package es.upm.miw.shop_application;

import es.upm.miw.shop_domain.services.ArticleService;
import es.upm.miw.shop_persistence_mongodb.adapters.ArticlePersistenceImpl;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import es.upm.miw.shop_rest_web.resources.ArticleResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(
        scanBasePackageClasses = {
                DatabaseSeeder.class,
                ArticleResource.class,
                ArticleService.class,
                ArticlePersistenceImpl.class,
                ArticleRepository.class
        },
        exclude = {ErrorMvcAutoConfiguration.class}
)
@EnableMongoRepositories(basePackageClasses = ArticleRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);// mvn clean install, mvn spring-boot:run -pl application
    }

}
