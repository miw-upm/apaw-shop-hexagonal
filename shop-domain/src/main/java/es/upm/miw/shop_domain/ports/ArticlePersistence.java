package es.upm.miw.shop_domain.ports;

import es.upm.miw.shop_domain.models.Article;

public interface ArticlePersistence extends GenericPersistence<Article, String> {
    Article findByBarcode(Long barcode);
}
