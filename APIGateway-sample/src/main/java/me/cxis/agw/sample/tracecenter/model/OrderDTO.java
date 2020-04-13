package me.cxis.agw.sample.tracecenter.model;

import java.io.Serializable;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 3167521498342782528L;

    private Long id;

    private String buyerName;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
            "id=" + id +
            ", buyerName='" + buyerName + '\'' +
            ", price=" + price +
            '}';
    }
}
