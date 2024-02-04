package com.example.fluganzeigetafel.Orders.Data;

public class CSVRow {
    private String designation;
    private String value;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CSVRow(String des, String val) {
        this.designation = des;
        this.value = val;

    }
}
