package com.vaibhavtraders.gstapp.model;

public class DeliveryMode {
    private Long deliveryModeID;
    private String modeName;

    public Long getDeliveryModeID() {
        return deliveryModeID;
    }

    public void setDeliveryModeID(Long deliveryModeID) {
        this.deliveryModeID = deliveryModeID;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    @Override
    public String toString() {
        return "DeliveryMode{" +
                "deliveryModeID=" + deliveryModeID +
                ", modeName='" + modeName + '\'' +
                '}';
    }
}
