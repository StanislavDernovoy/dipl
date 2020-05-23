package entity;

import java.util.Date;
import java.util.Objects;

public class Products {

    private String productName;
    private String producerName;
    private double price;
    private Date createdAt;
    private Date updatedAt;
    private int volumeId;
    public Products( String productName, String producerName, double price, Date createdAt, Date updatedAt,int volumeId) {

        this.productName = productName;
        this.producerName = producerName;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.volumeId= volumeId;
    }

    public Products(String productName, String producerName, double price,int volumeId) {
        this.productName = productName;
        this.producerName = producerName;
        this.price = price;
        this.volumeId= volumeId;
    }

    public  String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productName='" + productName + '\'' +
                ", producerName='" + producerName + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", volumeId=" + volumeId +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return Double.compare(products.getPrice(), getPrice()) == 0 &&
                getVolumeId() == products.getVolumeId() &&
                Objects.equals(getProductName(), products.getProductName()) &&
                Objects.equals(getProducerName(), products.getProducerName()) &&
                Objects.equals(getCreatedAt(), products.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), products.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getProducerName(), getPrice(), getCreatedAt(), getUpdatedAt(), getVolumeId());
    }
}
