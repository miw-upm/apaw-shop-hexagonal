package es.upm.miw.shop_application;


import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_rest_web.resources.ArticleResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class ArticleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(this.contextPath + ArticleResource.ARTICLES)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Article.class)
                .value(Assertions::assertNotNull)
                .value(articleData -> assertTrue(articleData.size() > 0));
    }

}
