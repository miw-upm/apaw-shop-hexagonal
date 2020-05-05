package es.upm.miw.shop_persistence_mongodb.adapters;

import es.upm.miw.shop_domain.ports.ArticlePersistence;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
