package com.mycompany.theorchestrathingitself;

import java.util.ArrayList;

public class Measure {
    private KeyTree key;
    private ArrayList<Note> notes;

    public Measure(KeyTree key, ArrayList<Note> notes) {
        this.key = key;
        this.notes = notes;
    }

    // getters and setters for key and notes

    public KeyTree getKey() {
        return key;
    }

    public void setKey(KeyTree key) {
        this.key = key;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
    
}
