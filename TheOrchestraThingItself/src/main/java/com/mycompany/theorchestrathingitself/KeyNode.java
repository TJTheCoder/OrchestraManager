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
    
}
