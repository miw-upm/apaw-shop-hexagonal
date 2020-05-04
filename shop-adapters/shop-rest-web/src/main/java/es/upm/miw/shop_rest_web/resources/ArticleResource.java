package es.upm.miw.shop_rest_web.resources;

import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ArticleResource.ARTICLES)
public class ArticleResource {
    public static final String ARTICLES = "/articles";

    private ArticleService articleService;

    @Autowired
    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> readAll() {
        return this.articleService.readAll()
                .collect(Collectors.toList());
    }

}
