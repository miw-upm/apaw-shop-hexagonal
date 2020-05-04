package es.upm.miw.apaw_shop_hexagonal.shop_application;

import es.upm.miw.shop_persistence_mongodb.entities.ArticleEntity;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    private ArticleRepository articleRepository;

    @Autowired
    public DatabaseSeeder(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.seedDatabase();
    }

    private void seedDatabase() {
        this.articleRepository.save(new ArticleEntity());
        System.out.println("===--->>> " + this.articleRepository.findAll());
    }
}
