package com.vaibhavtraders.gstapp.dto;

import com.vaibhavtraders.gstapp.enums.ProductType;

public class ProductDTO {
    private Long productID;
    private String name;
    private String productDescription;
    private String hsnHacCode;
    private String unitOfMeasurement;
    private Integer stock;
    private ProductType productType;
    private Double gstPercentage;
    private Double cessPercentage;
    private Double cessAmount;
    private Double sellPrice;
    private Double sellPriceIncludingTax;
    private Double purchasePrice;
    private Double purchasePriceIncludingTax;
    private String productImage;
    private boolean expandable;

    public ProductDTO(Long productID, String name, String productDescription, String hsnHacCode, String unitOfMeasurement, Integer stock, ProductType productType, Double gstPercentage, Double cessPercentage, Double cessAmount, Double sellPrice, Double sellPriceIncludingTax, Double purchasePrice, Double purchasePriceIncludingTax, String productImage, boolean expandable) {
        this.productID = productID;
        this.name = name;
        this.productDescription = productDescription;
        this.hsnHacCode = hsnHacCode;
        this.unitOfMeasurement = unitOfMeasurement;
        this.stock = stock;
        this.productType = productType;
        this.gstPercentage = gstPercentage;
        this.cessPercentage = cessPercentage;
        this.cessAmount = cessAmount;
        this.sellPrice = sellPrice;
        this.sellPriceIncludingTax = sellPriceIncludingTax;
        this.purchasePrice = purchasePrice;
        this.purchasePriceIncludingTax = purchasePriceIncludingTax;
        this.productImage = productImage;
        this.expandable = false;
    }


    public Long getProductID() {
        return productID;
    }
    public void setProductID(Long productID) {
        this.productID = productID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getHsnHacCode() {
        return hsnHacCode;
    }
    public void setHsnHacCode(String hsnHacCode) {
        this.hsnHacCode = hsnHacCode;
    }
    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public Double getGstPercentage() {
        return gstPercentage;
    }
    public void setGstPercentage(Double gstPercentage) {
        this.gstPercentage = gstPercentage;
    }
    public Double getCessPercentage() {
        return cessPercentage;
    }
    public void setCessPercentage(Double cessPercentage) {
        this.cessPercentage = cessPercentage;
    }
    public Double getCessAmount() {
        return cessAmount;
    }
    public void setCessAmount(Double cessAmount) {
        this.cessAmount = cessAmount;
    }
    public Double getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
    public Double getSellPriceIncludingTax() {
        return sellPriceIncludingTax;
    }
    public void setSellPriceIncludingTax(Double sellPriceIncludingTax) {
        this.sellPriceIncludingTax = sellPriceIncludingTax;
    }
    public Double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public Double getPurchasePriceIncludingTax() {
        return purchasePriceIncludingTax;
    }
    public void setPurchasePriceIncludingTax(Double purchasePriceIncludingTax) {
        this.purchasePriceIncludingTax = purchasePriceIncludingTax;
    }
    public String getProductImage() {
        return productImage;
    }
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    @Override
    public String toString() {
        return "ProductDTO [productID=" + productID + ", name=" + name + ", productDescription=" + productDescription
                + ", hsnHacCode=" + hsnHacCode + ", unitOfMeasurement=" + unitOfMeasurement + ", stock=" + stock
                + ", productType=" + productType + ", gstPercentage=" + gstPercentage + ", cessPercentage="
                + cessPercentage + ", cessAmount=" + cessAmount + ", sellPrice=" + sellPrice
                + ", sellPriceIncludingTax=" + sellPriceIncludingTax + ", purchasePrice=" + purchasePrice
                + ", purchasePriceIncludingTax=" + purchasePriceIncludingTax + ", productImage=" + productImage + "]";
    }
}
