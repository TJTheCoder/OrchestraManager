package com.mycompany.theorchestrathingitself;

import javax.sound.sampled.Clip;

public class Note {
    private Clip sound;
    private int pitch;
    private double percentLength;
    
    public Note(Clip sound, int pitch, double percentLength) {
        this.sound = sound;
        this.pitch = pitch;
        this.percentLength = percentLength;
    }
    
    public Clip getSound() {
        return sound;
    }
    
    public int getPitch() {
        return pitch;
    }
    
    public double getPercentLength() {
        return percentLength;
    }
}
