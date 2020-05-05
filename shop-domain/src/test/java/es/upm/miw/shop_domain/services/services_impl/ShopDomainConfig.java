package es.upm.miw.shop_domain.services.services_impl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        ArticleServiceImpl.class
})
@EnableAutoConfiguration
public class ShopDomainConfig {
}
