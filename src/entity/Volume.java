package entity;

import java.util.Date;

public class Volume {
    private int id;
    private int productVolume;
    private int sold;
    private int ordered;
    private Date createdAt;
    private Date updatedAt;
    public Volume(int id, int productVolume, int sold, int ordered, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productVolume = productVolume;
        this.sold = sold;
        this.ordered = ordered;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Volume(int id, int productVolume, int sold, int ordered) {
        this.id = id;
        this.productVolume = productVolume;
        this.sold = sold;
        this.ordered = ordered;
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

    @Override
    public String toString() {
        return "Volume{" +
                "id=" + id +
                ", productVolume=" + productVolume +
                ", sold=" + sold +
                ", ordered=" + ordered +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
