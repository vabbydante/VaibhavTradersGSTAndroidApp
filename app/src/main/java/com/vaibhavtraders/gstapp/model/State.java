package com.vaibhavtraders.gstapp.model;

public class State {
    private Long stateID;
    private String stateName;

    public Long getStateID() {
        return stateID;
    }

    public void setStateID(Long stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateID=" + stateID +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
