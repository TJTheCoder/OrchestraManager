/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.theorchestrathingitself;

/**
 *
 * @author atxbr
 */
public class KeyNode {
    
    int index;      /*
                    the pitches that are being modified
                    (corresponds to the pitch variable) in the
                    Note objects
                    */
    int modifier;   //how a specific pitch is changed
    KeyNode left;   //lesser child for the KeyNode (based off index);]
    KeyNode right;  //greater child for the KeyNode (based off index)

    public KeyNode(int index, int modifier, KeyNode left, KeyNode right) {
        this.index = index;
        this.modifier = modifier;
        this.left = left;
        this.right = right;
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
