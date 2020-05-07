package es.upm.miw.shop_application;

import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_domain.services.ArticleService;
import es.upm.miw.shop_domain.services.services_impl.ArticleServiceImpl;
import es.upm.miw.shop_persistence_mongodb.adapters.ArticlePersistenceMongodb;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import es.upm.miw.shop_rest_web.resources.ArticleResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        ArticleResource.class
})
public class ApplicationConfiguration {

    @Bean
    public ArticleService articleService(ArticlePersistence articlePersistence) {
        return new ArticleServiceImpl(articlePersistence);
    }

    @Bean
    public ArticlePersistence articlePersistence(ArticleRepository articleRepository) {
        return new ArticlePersistenceMongodb(articleRepository);
    }

}
