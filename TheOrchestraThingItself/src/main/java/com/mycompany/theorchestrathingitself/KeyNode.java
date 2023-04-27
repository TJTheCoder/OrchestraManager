package com.mycompany.theorchestrathingitself;

public class KeyNode {
    private int index;
    private int modifier;
    private KeyNode left;
    private KeyNode right;
    
    public KeyNode(int index, int modifier, KeyNode left, KeyNode right) {
        this.index = index;
        this.modifier = modifier;
        this.left = left;
        this.right = right;
    }

    public KeyNode(int index, int modifier) {
        this.index = index;
        this.modifier = modifier;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getModifier() {
        return modifier;
    }
    
    public void setModifier(int modifier) {
        this.modifier = modifier;
    }
    
    public KeyNode getLeft() {
        return left;
    }
    
    public void setLeft(KeyNode left) {
        this.left = left;
    }
    
    public KeyNode getRight() {
        return right;
    }
    
    public void setRight(KeyNode right) {
        this.right = right;
    }
}
