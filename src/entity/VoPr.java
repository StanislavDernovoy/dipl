package entity;

import java.util.Date;

public class VoPr {
    private String productName;
    private String producerName;
    private double price;
    private Date createdAt;
    private Date updatedAt;
    private int volumeId;
    private int id;
    private int productVolume;
    private int sold;
    private int ordered;
    private Date createdAtV;
    private Date updatedAtV;
    public VoPr(String productName, String producerName, double price, Date createdAt, Date updatedAt, int volumeId, int id,
                int productVolume, int sold, int ordered, Date createdAtV, Date updatedAtV) {
        this.productName = productName;
        this.producerName = producerName;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.volumeId = volumeId;
        this.id = id;
        this.productVolume = productVolume;
        this.sold = sold;
        this.ordered = ordered;
        this.createdAtV = createdAtV;
        this.updatedAtV = updatedAtV;
    }

    public VoPr(String productName, String producerName, double price, Date createdAt, Date updatedAt,
                int productVolume, int sold, int ordered, Date createdAtV, Date updatedAtV) {
        this.productName = productName;
        this.producerName = producerName;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productVolume = productVolume;
        this.sold = sold;
        this.ordered = ordered;
        this.createdAtV = createdAtV;
        this.updatedAtV = updatedAtV;
    }

    public String getProductName() {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductVolume() {
        return productVolume;
    }

    public void setProductVolume(int productVolume) {
        this.productVolume = productVolume;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public Date getCreatedAtV() {
        return createdAtV;
    }

    public void setCreatedAtV(Date createdAtV) {
        this.createdAtV = createdAtV;
    }

    public Date getUpdatedAtV() {
        return updatedAtV;
    }

    public void setUpdatedAtV(Date updatedAtV) {
        this.updatedAtV = updatedAtV;
    }

    @Override
    public String toString() {
        return "VoPr{" +
                "productName='" + productName + '\'' +
                ", producerName='" + producerName + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", volumeId=" + volumeId +
                ", id=" + id +
                ", productVolume=" + productVolume +
                ", sold=" + sold +
                ", ordered=" + ordered +
                ", createdAtV=" + createdAtV +
                ", updatedAtV=" + updatedAtV +
                '}';
    }
}
