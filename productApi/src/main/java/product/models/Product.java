package product.models;

import java.time.Instant;
import java.util.stream.Collectors;

public class Product {

    private String productId;
    private String productName;
    private Integer price;
//    private Instant expiredDate;
    private Country country;

    public Product() {

    };

//    public Product(String productId, String productName, Integer price, Instant expiredDate, Country country) {
    public Product(String productId, String productName, Integer price, Country country) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
//        this.expiredDate = expiredDate;
        this.country = country;
    }

    public String getProductId() {return this.productId;}
    public Integer getPrice() {return this.price;}
    public String getProductName() {return this.productName;}
//    public Instant getExpiredDate() {return this.expiredDate;}
    public Country getCountry() {return this.country;}

    public void setProductId(String productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setPrice(Integer price) {this.price = price;}
//    public void setExpiredDate(Instant productId) {this.expiredDate = expiredDate;}
    public void setCountry(Country country) {this.country = country;}

    @Override
    public String toString() {
        return "id: " + this.productId + ", name: " + this.productName + ", price: "
                + this.price + ", country: " + this.country.name();
    }
}
