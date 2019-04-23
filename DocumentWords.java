/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.io.FileWriter;
import java.io.IOException;

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
public class DocumentWords   {
    
    private static Word head;
    // Constructor
    public DocumentWords() {
        head = null;
    }
    //  Method to check if list is empty
    public Word getHead(){
        return head;
    }
    public boolean isEmpty() {
        return head == null;
    }
    // Match method
    public static boolean isMatch(String str1,String str2){
        if(str1.length() != str2.length())
            return false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i))
                return false;
        }
        return true;
    }

    //  Method to print all words 

    public static String printAllWordes() {
        /*this method eill return an array of strings contain all words ith frequencies*/
        String str="";
        /*the variable i is used to print the word's index*/
        int i = 1;
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*transverse to reach the end of the Linked List*/
        while(helpPtr != null){
            /*every loop append the new word with its frequency to the str*/
            str=str + ( i +" - " + helpPtr.getWord()+ " : "+helpPtr.getFrequency()+"\n");
            helpPtr = helpPtr.getNext() ;
            i++;
        }
        return str;
    }
    
 
        //  Method to search a word

    public static Boolean search(String w) {
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*the returned boolean value*/
        Boolean flag = false;
        /*transverse to reach the end of the Linked List*/
        while(helpPtr != null){
            /*if the word content is matching the the searched for word the reurn true else return zero*/
            if(isMatch(helpPtr.getWord(),w)){
                return true;
            }
            helpPtr = helpPtr.getNext() ;
        }
        return flag;
        
    }
    
        
        // method to insert new word  

    public void addWord(String w) {    
        /*Make a new word node with freq = 1 and next = null*/
        Word newWord = new Word(w);
        if(isEmpty()){
            /*add word in front*/
            head = newWord;
        }
        else{
            /*helpPtr to transverse through the Linked List*/
            Word helpPtr = head;
            /*transverse to reach the end of the Linked List*/
            while(helpPtr.getNext() != null){
                helpPtr = helpPtr.getNext();
            }
            /*now the helpPtr points to the last word then we will make its next to the newWord*/
            helpPtr.setNext(newWord);
        }
    }
        // method to increment word frequency
    public void incFrequency(String w){
        /*if the word is really exist*/
            if(search(w)){
                /*helpPtr to transverse through the Linked List*/
                Word helpPtr = head;
                /*transverse to reach the end of the Linked List*/
                while(helpPtr != null){
                    /*if the node word is matching the passed word*/
                    if(isMatch(helpPtr.getWord(),w))
                        /*the word frequency increaments by 1*/
                        helpPtr.setFrequency(helpPtr.getFrequency()+1);
                    helpPtr = helpPtr.getNext() ;
                }
            }
            else{
                /*if the word isn't exist then add it to end */
                addWord(w) ;
            }
    }
            // method to increment word frequency
    public static int totalWords(){
        /* a valiable to count number of words*/
        int wordscounter = 0; 
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*transverse to reach the end of the Linked List*/
        while(helpPtr != null){
             /*increment the counter value by 1 */
            wordscounter= wordscounter + helpPtr.getFrequency();    
            helpPtr = helpPtr.getNext() ;
        }
        return wordscounter ; /*return the total number of words */
    }
    //the method to return the word occurences in the txt file
    public static int wordFrequency(String w){
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*transverse to reach the end of the Linked List*/
        while(helpPtr != null){
            /*the word frequency increaments by 1*/
            if(isMatch(helpPtr.getWord(),w))
                /*return the frequency */
                return helpPtr.getFrequency();
            helpPtr = helpPtr.getNext() ;
        }
            
        return 0; /*return the total number of words */
    }
        //This method will return the most frequent word in the document.
    public static String MostFrequent(){
        /*using a string temp contain the first word and freq rquals the freq of it*/
        String temp = head.getWord();
        int mostFreq = head.getFrequency();
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*transverse to reach the end of the Linked List*/
        while(helpPtr != null){
            /*if frequency of the current node word is greater then the mostfre
            variable then get it as the most freq*/
            if(helpPtr.getFrequency() > mostFreq){
                temp = helpPtr.getWord();
                mostFreq = helpPtr.getFrequency();
            }
            helpPtr = helpPtr.getNext() ;
        }
            
        return temp; /*return the total number of words */
    }
    // a method to remove a word
    public void removeWord(String w) {
        /*check if the list is not empty*/
        if(!isEmpty()){
            //if the list contains only one word
            if(isMatch(head.getWord(),w)){
                head = head.getNext();
            }
            //if the list contains more than one word
            else{
                /*helpPtr to transverse through the Linked List*/
                Word helpPtr = head;
                /*transverse to reach the end of the Linked List*/
                while(helpPtr.getNext() != null){
                    /*if there are a word matching the desired word to remove*/
                    if(isMatch(helpPtr.getWord(),w)){
                        /*removing the word*/
                        helpPtr.getNext().setNext(helpPtr.getNext().getNext()) ; 
                        break;
                    }
                helpPtr = helpPtr.getNext();
                } 
            }
        }            
    }
       //  Method to print all words 
    public static String reversePrint(Word h) {
        /*The termination condition*/
        if (h == null) 
            return "";
        
        int i = 0;
        /*helpPtr to transverse through the Linked List*/
        Word helpPtr = head;
        /*transverse to reach the end of the Linked List 
        to show the word number and store this value in i*/
        while(helpPtr != null){
            i++;
            /*if there is a word is matching the passed pointer's word
            I'll break and keep this i value as the number of desied word*/
            if(isMatch(helpPtr.getWord(),h.getWord()))
                break;
            helpPtr = helpPtr.getNext() ;
        }
  
        // our recursive way to return the list string 
        return (reversePrint(h.getNext())+ i+" - "+h.getWord()+" : "+h.getFrequency()+"\n" );

    }



}
    

