package es.upm.miw.shop_domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Article {
    private String id;
    private Long barcode;
    private String description;
    private LocalDate registrationDate;
    private BigDecimal price;
    private String provider;

    public Article() {
        this.id = UUID.randomUUID().toString();
        this.registrationDate = LocalDate.now();
    }

    public Article(Long barcode, String description, BigDecimal price, String provider) {
        this();
        this.barcode = barcode;
        this.description = description;
        this.price = price;
        this.provider = provider;
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

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (barcode.equals(((Article) obj).barcode));
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                ", registrationDate=" + registrationDate +
                ", price=" + price +
                ", provider='" + provider + '\'' +
                '}';
    }
}
