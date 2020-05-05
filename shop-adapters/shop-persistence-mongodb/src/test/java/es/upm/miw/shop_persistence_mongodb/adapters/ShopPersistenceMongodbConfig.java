package es.upm.miw.shop_persistence_mongodb.adapters;


import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackageClasses = {
        ArticlePersistenceImpl.class,
        ArticleRepository.class
})
@EnableMongoRepositories(basePackageClasses = {ArticleRepository.class})
@EnableAutoConfiguration
public class ShopPersistenceMongodbConfig {
}
