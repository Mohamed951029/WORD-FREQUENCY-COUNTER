/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

/**
 * Name : Sara Aljohani
 * email : sarajazaa@outlook.com
 * account number
 * section number : 43047 
 * section : HJ
 * assignment title : Word Frequency Counter
 * Date : 7/3/2019.
 * @author Sara
 */
public class Word {
    private String word;
    private int frequency;
    private Word next;
        // Constructor 3
    public Word(String w,  int freq, Word n) {
        word = w;
        frequency = freq;
        next = n;
    }
        // Constructor 1
    public Word(String w,  int freq) {
        this(w, freq, null);
    }
    // Constructor 2
    public Word(String w) {
        this(w, 1, null);
    }
    
    //Methods
    public void getWord(String w){
        word = w;
    }
    public String getWord(){
        return word;
    }
    
    public void setFrequency(int f){
        frequency = f;
    }
    
    public int getFrequency(){
        return frequency;
    }
    
    
    public void setNext(Word n){
        next = n;
    }

    public Word getNext(){
        return next;
    }
    
}

