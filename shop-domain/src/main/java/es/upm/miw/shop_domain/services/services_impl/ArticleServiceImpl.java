package es.upm.miw.shop_domain.services.services_impl;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.services.ArticleService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

/*    private ArticlePersistence articlePersistence;

    public ArticleServiceImpl(ArticlePersistence articlePersistence) {
        this.articlePersistence = articlePersistence;
    }
*/

    public ArticleServiceImpl() {
        System.out.println("===--->>> ArticleServiceImpl: ");
    }

    @Override
    public Stream<Article> readAll() {
        //return this.articlePersistence.readAll();
        return Stream.of(
                new Article(840002L, "art mock2", BigDecimal.ONE, "prov mock2"),
                new Article(840003L, "art mock3", BigDecimal.ONE, "prov mock3"),
                new Article(840004L, "art mock4", BigDecimal.ONE, "prov mock4")
        );
    }

    @Override
    public Article readById(String id) {
        return new Article(840001L, "art mock", BigDecimal.ONE, "prov mock");
        //return this.articlePersistence.readById(id);
    }
}