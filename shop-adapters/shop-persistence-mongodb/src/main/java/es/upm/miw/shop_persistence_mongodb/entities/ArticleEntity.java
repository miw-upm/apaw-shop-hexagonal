package es.upm.miw.shop_persistence_mongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class ArticleEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private Long barcode;
    private String description;
    private LocalDate registrationDate;
    private BigDecimal price;
    private String provider;

    public ArticleEntity() {
    }

    public String getId() {
        return id;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public int hashCode() {
        return barcode.hashCode();
    }

    //@Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (barcode.equals(((ArticleEntity) obj).barcode));
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id='" + id + '\'' +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                ", price=" + price +
                ", provider='" + provider + '\'' +
                '}';
    }
}
