package es.upm.miw.shop_domain.services.services_impl;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_domain.services.ArticleService;

import java.util.stream.Stream;

public class ArticleServiceImpl implements ArticleService {

    private ArticlePersistence articlePersistence;

    public ArticleServiceImpl(ArticlePersistence articlePersistence) {
        this.articlePersistence = articlePersistence;
    }

    @Override
    public Stream<Article> readAll() {
        return this.articlePersistence.readAll();
    }

    @Override
    public Article readById(String id) {
        return this.articlePersistence.readById(id);
    }
}