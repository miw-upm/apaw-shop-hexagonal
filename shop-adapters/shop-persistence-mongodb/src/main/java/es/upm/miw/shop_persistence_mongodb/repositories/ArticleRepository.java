package es.upm.miw.shop_persistence_mongodb.repositories;

import es.upm.miw.shop_persistence_mongodb.entities.ArticleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ArticleRepository extends MongoRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findByBarcode(Long barcode);
}
