package com.ecommerce.PaymentServices.htmlclasses;

public class ItemWon {
    private Long ItemId;
    private String ItemName;
    private Double TotalCost;
    private String ShippingInfo;

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(Double totalCost) {
        TotalCost = totalCost;
    }

    public String getShippingInfo() {
        return ShippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        ShippingInfo = shippingInfo;
    }

    public ItemWon(Long itemId, String itemName, Double totalCost, String shippingInfo) {
        ItemId = itemId;
        ItemName = itemName;
        TotalCost = totalCost;
        ShippingInfo = shippingInfo;
    }

    public ItemWon() {
        ItemId = 101L;
        ItemName = "Office Chair";
        TotalCost = 40.0;
        ShippingInfo = "10";
    }
}
