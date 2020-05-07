package es.upm.miw.shop_persistence_mongodb.adapters;

import es.upm.miw.shop_domain.exceptions.ConflictException;
import es.upm.miw.shop_domain.exceptions.NotFoundException;
import es.upm.miw.shop_domain.models.Article;
import es.upm.miw.shop_domain.ports.ArticlePersistence;
import es.upm.miw.shop_persistence_mongodb.entities.ArticleEntity;
import es.upm.miw.shop_persistence_mongodb.repositories.ArticleRepository;

import java.util.stream.Stream;

public class ArticlePersistenceMongodb implements ArticlePersistence {

    private ArticleRepository articleRepository;

    public ArticlePersistenceMongodb(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article findByBarcode(Long barcode) {
        return this.articleRepository.findByBarcode(barcode)
                .orElseThrow(() -> new NotFoundException("Article barcode: " + barcode))
                .toArticle();
    }

    @Override
    public Stream<Article> readAll() {
        return this.articleRepository.findAll().stream()
                .map(ArticleEntity::toArticle);
    }

    @Override
    public Article readById(String id) {
        return this.articleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article id: " + id))
                .toArticle();
    }

    @Override
    public Article create(Article article) {
        this.articleRepository.findByBarcode(article.getBarcode())
                .ifPresent(articleEntity -> {
                    throw new ConflictException("Barcode exist: " + articleEntity.getBarcode());
                });
        return this.articleRepository.save(new ArticleEntity(article))
                .toArticle();
    }

    @Override
    public Article update(Article article) {
        ArticleEntity articleEntity = this.articleRepository.findById(article.getId())
                .orElseThrow(() -> new NotFoundException("Article id: " + article.getId()));
        articleEntity.update(article);
        return this.articleRepository.save(articleEntity)
                .toArticle();
    }

    @Override
    public void deleteById(String id) {
        this.articleRepository.deleteById(id);
    }
}
