package es.upm.miw.shop_domain.services.services_impl;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_domain.services.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@TestConfig
class ArticleServiceImplTest {

    @Autowired
    private ArticleService articleService;

    @MockBean
    private ArticlePersistence articlePersistence;

    @Test
    void testReadAll() {
        given(this.articlePersistence.readAll()).willReturn(Stream.of(new Article()));
        assertTrue(this.articleService.readAll().count() > 0);

    }
}
