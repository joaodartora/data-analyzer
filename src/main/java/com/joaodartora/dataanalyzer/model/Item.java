package com.joaodartora.dataanalyzer.model;

import java.math.BigDecimal;

public class Item {

    private Integer id;
    private Integer quantity;
    private BigDecimal price;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private Item item;

        private Builder() {
            item = new Item();
        }

        public Builder id(Integer id) {
            item.setId(id);
            return this;
        }

        public Builder quantity(Integer quantity) {
            item.setQuantity(quantity);
            return this;
        }

        public Builder price(BigDecimal price) {
            item.setPrice(price);
            return this;
        }

        public Item build() {
            return item;
        }
    }
}
