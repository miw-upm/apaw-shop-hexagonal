package es.upm.miw.shop_persistence_mongodb.adapters;


import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = {ArticleRepository.class})
@EnableAutoConfiguration
public class ShopPersistenceMongodbConfig {

    @Bean
    public ArticlePersistence articlePersistence(ArticleRepository articleRepository) {
        return new ArticlePersistenceMongodb(articleRepository);
    }

    @Bean
    public ShopSeederService shopSeederService(ArticleRepository articleRepository) {
        return new ShopSeederService(articleRepository);
    }
}
