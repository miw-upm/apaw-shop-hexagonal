package es.upm.miw.shop_domain.services.services_impl;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_domain.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    private ArticlePersistence articlePersistence;

    @Autowired
    public ArticleServiceImpl(ArticlePersistence articlePersistence) {
        this.articlePersistence = articlePersistence;
    }

    @Override
    public Stream<Article> readAll() {
        return this.articlePersistence.readAll();
    }

    @Override
    public Article readById(String id) {
        return new Article(840001L, "art mock", BigDecimal.ONE, "prov mock");
        //return this.articlePersistence.readById(id);
    }
}