package com.event.util;

public enum RegistrationStatus {
    REGISTERED("registered"), ATTENDED("attended");

    private String smallcase;

    private RegistrationStatus(String smallcase){
        this.smallcase=smallcase;
    }

    public String getSmallCase(){
        return this.smallcase;
    }
}
