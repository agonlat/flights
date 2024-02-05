package com.example.fluganzeigetafel.Orders.Data;
/**
 * The CSVRow class represents a row in a CSV file, containing a designation and its corresponding value.
 */
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
    /**
     * Constructs a new CSVRow with the given designation and value.
     *
     * @param des The designation of the CSV row.
     * @param val The value of the CSV row.
     */
    public CSVRow(String des, String val) {
        this.designation = des;
        this.value = val;

    }
}
