package com.joaodartora.dataanalyzer.model;

import java.util.List;

public class Sales implements BaseModel {

    private Integer saleId;
    private List<Item> item;
    private String salesmanName;

    public Sales() {
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private Sales sales;

        private Builder() {
            sales = new Sales();
        }

        public Builder saleId(Integer saleId) {
            sales.setSaleId(saleId);
            return this;
        }

        public Builder item(List<Item> item) {
            sales.setItem(item);
            return this;
        }

        public Builder salesmanName(String salesmanName) {
            sales.setSalesmanName(salesmanName);
            return this;
        }

        public Sales build() {
            return sales;
        }
    }
}
