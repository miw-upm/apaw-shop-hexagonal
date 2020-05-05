package es.upm.miw.shop_persistence_mongodb.adapters;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_persistence_mongodb.entities.ArticleEntity;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class ShopSeederService {

    private ArticleRepository articleRepository;


    @Autowired
    public ShopSeederService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        this.seedDatabase();
    }

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Shop Initial Load -----------");
        ArticleEntity[] articles = {
                new ArticleEntity(new Article(84001L, "art 001", new BigDecimal("1.23"), "prov 1")),
                new ArticleEntity(new Article(84002L, "art 002", new BigDecimal("0.27"), "prov 2")),
                new ArticleEntity(new Article(84003L, "art 003", new BigDecimal("12.13"), "prov 3")),
                new ArticleEntity(new Article(84004L, "art 004", new BigDecimal("4.00"), "prov 4")),
                new ArticleEntity(new Article(84005L, "art 005", new BigDecimal("0.45"), "prov 5")),
        };
        this.articleRepository.saveAll(Arrays.asList(articles));
    }

    public void deleteAll() {
        this.articleRepository.deleteAll();
    }

}
