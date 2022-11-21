package com.ironhack.crm;

public class salesRep {
    int salesRepID;
    String salesRepName;

    public salesRep(int salesRepID, String salesRepName) {
        this.salesRepID = salesRepID;
        this.salesRepName = salesRepName;
    }

    public int getSalesRepID() {
        return salesRepID;
    }

    public void setSalesRepID(int salesRepID) {
        this.salesRepID = salesRepID;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }
}
