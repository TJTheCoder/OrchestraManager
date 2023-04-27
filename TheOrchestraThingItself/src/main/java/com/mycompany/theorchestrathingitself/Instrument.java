package com.mycompany.theorchestrathingitself;

public class Instrument {
    private Measure[] measures;
    private int signature;
    
    public Instrument(Measure[] measures, int signature) {
        this.measures = measures;
        this.signature = signature;
    }
    
    public Measure[] getMeasures() {
        return measures;
    }
    
    public int getSignature() {
        return signature;
    }
    
    public void setMeasures(Measure[] measures) {
        this.measures = measures;
    }
    
    public void setSignature(int signature) {
        this.signature = signature;
    }
}
