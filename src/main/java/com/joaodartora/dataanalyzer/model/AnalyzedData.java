package com.joaodartora.dataanalyzer.model;

public class AnalyzedData {

    private Integer amountOfCustomer;
    private Integer amountOfSalesman;
    private Integer mostExpensiveSaleId;
    private String worstSalesmanEver;

    public AnalyzedData() {
    }

    public byte[] getAnalyzedDataAsBytes() {
        return this.toString().getBytes();
    }

    public Integer getAmountOfCustomer() {
        return amountOfCustomer;
    }

    public void setAmountOfCustomer(Integer amountOfCustomer) {
        this.amountOfCustomer = amountOfCustomer;
    }

    public Integer getAmountOfSalesman() {
        return amountOfSalesman;
    }

    public void setAmountOfSalesman(Integer amountOfSalesman) {
        this.amountOfSalesman = amountOfSalesman;
    }

    public Integer getMostExpensiveSaleId() {
        return mostExpensiveSaleId;
    }

    public void setMostExpensiveSaleId(Integer mostExpensiveSaleId) {
        this.mostExpensiveSaleId = mostExpensiveSaleId;
    }

    public String getWorstSalesmanEver() {
        return worstSalesmanEver;
    }

    public void setWorstSalesmanEver(String worstSalesmanEver) {
        this.worstSalesmanEver = worstSalesmanEver;
    }

    public static Builder of() {
        return new Builder();
    }

    public static final class Builder {
        private AnalyzedData analyzedData;

        private Builder() {
            analyzedData = new AnalyzedData();
        }

        public Builder amountOfCustomer(Integer amountOfCustomer) {
            analyzedData.setAmountOfCustomer(amountOfCustomer);
            return this;
        }

        public Builder amountOfSalesman(Integer amountOfSalesman) {
            analyzedData.setAmountOfSalesman(amountOfSalesman);
            return this;
        }

        public Builder mostExpensiveSaleId(Integer mostExpensiveSaleId) {
            analyzedData.setMostExpensiveSaleId(mostExpensiveSaleId);
            return this;
        }

        public Builder worstSalesmanEver(String worstSalesmanEver) {
            analyzedData.setWorstSalesmanEver(worstSalesmanEver);
            return this;
        }

        public AnalyzedData build() {
            return analyzedData;
        }
    }

    @Override
    public String toString() {
        return "AnalyzedData:" +
                "\nAmount of Customers: " + amountOfCustomer +
                "\nAmount of Salesmen: " + amountOfSalesman +
                "\nID of the Most Expensive Sale: " + mostExpensiveSaleId +
                "\nWorst Salesman Ever: " + worstSalesmanEver;
    }
}
