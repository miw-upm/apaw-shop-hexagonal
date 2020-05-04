package es.upm.miw.shop_persistence_mongodb.adapters;

import es.upm.miw.shop_domain.ports.ArticlePersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class ArticlePersistenceIT {

    @Autowired
    private ArticlePersistence articlePersistence;

    @Test
    void testReadAll() {
        assertTrue(this.articlePersistence.readAll().count() > 0);
    }

}
