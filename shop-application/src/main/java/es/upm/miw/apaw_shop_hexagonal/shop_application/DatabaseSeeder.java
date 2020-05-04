package es.upm.miw.apaw_shop_hexagonal.shop_application;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_persistence_mongodb.entities.ArticleEntity;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseSeeder {

    private ArticleRepository articleRepository;

    @Autowired
    public DatabaseSeeder(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.seedDatabase();
    }

    private void seedDatabase() {
        List<ArticleEntity> articles = Arrays.asList(
                new ArticleEntity(new Article(840002L, "art mock2", BigDecimal.ONE, "prov mock2")),
                new ArticleEntity(new Article(840003L, "art mock3", BigDecimal.ONE, "prov mock3")),
                new ArticleEntity(new Article(840004L, "art mock4", BigDecimal.ONE, "prov mock4"))
        );
        this.articleRepository.saveAll(articles);
        System.out.println("===--->>> seedDatabase: readAll:" + this.articleRepository.findAll());
    }
}
