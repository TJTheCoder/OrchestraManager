package com.mycompany.theorchestrathingitself;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The model class, that holds all notes.
 */
public class NoteSequence {

    public static final String PROP_NOTE_ADDED = "noteAdded";
    public static final String PROP_NOTE_REMOVED = "noteRemoved";

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return Collections.unmodifiableList(notes);
    }

    /**
     * is called by the UI or a button listener when a note should be added to
     * this music sheet / notesequence
     *
     * @param note
     */
    public void addNote(Note note) {
        this.notes.add(note);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, PROP_NOTE_ADDED, null, note));
    }

    public void removeNote(Note note) {
        this.notes.remove(note);
        propertyChangeSupport.firePropertyChange(new PropertyChangeEvent(this, PROP_NOTE_REMOVED, note, null));
    }

    void addNoteSequenceChangedListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // not really needed atm
    void removeNoteSequenceChangedListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    /**
     * a single note.
     */
    public static class Note {

        private float line; // where does the note sit
        private float timestampSinceBeginning; // not used, but you have to know WHEN a note is played
        // ... more properties, e.g. name, or modifiers or whatever

        public Note(float line) { // this is certainly to easy, since notes can sit in between lines,
            // i did not try to think deeply into it, to define a better model
            this.line = line;
        }

        public float getLine() {
            return line;
        }

        public float getTimestampSinceBeginning() {
            return timestampSinceBeginning;
        }
    }
}
