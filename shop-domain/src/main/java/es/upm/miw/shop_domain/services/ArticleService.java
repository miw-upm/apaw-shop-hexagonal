package es.upm.miw.shop_domain.services;

import es.upm.miw.shop_domain.models.Article;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public interface ArticleService {
    Stream<Article> readAll();

    Article readById(final String id);
}