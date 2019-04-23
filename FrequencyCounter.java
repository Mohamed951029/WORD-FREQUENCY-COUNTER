/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
public class FrequencyCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*make new object of  Word linked list with myWords name  */
        DocumentWords myWords = new DocumentWords();
        /* read document.txt file  using scanner */
        Scanner inFile = new Scanner(new File("document.txt"));

        /* read document.txt file  using scanner */
        Scanner commandFile = new Scanner(new File("commands.txt"));
        /* Creat output.txt file to write our output inside it (the parameter false to over write the file and not to append  */
        FileWriter writer = new FileWriter("Output.txt", false);
       // String word = "";
        /* Loop through the text file line by line  */
        while (inFile.hasNext()) {
            /* reading word from file  */
            String myword = inFile.next();
            /*regular expressions exceptions */
            //word =myword.replaceAll("[—!@#%^&*()_+|\\-=~`{}\\[\\]:;<>,.?/]","");
            //String word =myword.replaceAll("[*]","");
            /* increase the frequency of the word or add it to myWords LinkedList if it's not founded   
            if(word.matches(""))
                continue;*/
            myWords.incFrequency(myword); 
        }
        inFile.close(); /*Close the input file */
        /* Looping line by line through the input file */
        while (commandFile.hasNext()) { 
            String line = commandFile.nextLine();    /* reading line from file  */
            /*check if the line contains the string "TOTALWORDS" using str.matches( -- ) method*/
            if(line.matches("TOTALWORDS")){
                writer.write("*******************************************\n");
                writer.write("-----------TOTALWORDS Command-------------\n");
                writer.write("*******************************************\n\n");
                writer.write("Total number of words in the document = "+myWords.totalWords()+"\n\n\n");
            }
            /*check if the line contains the string "REMOVEWORD" using str.matches( -- ) method*/   
            else if(line.contains("REMOVEWORD")){
                writer.write("*******************************************\n");
                writer.write("-----------REMOVEWORD Command-------------\n");
                writer.write("*******************************************\n\n");
                /*I'll creat flag to reach the second word in the line which I'll treat with*/
                int flag = 0;
                for(String w:line.split("\\s",0)){
                    if(flag == 0)
                    {
                        flag = 1;
                        continue;                        
                    }
                    /* if flag == 0 then it's the first word in the line , and if flag  == 1 then it's the desired word */
                    else if(flag == 1)
                        if(myWords.search(w)){
                            myWords.removeWord(w);
                            myWords.printAllWordes();
                            writer.write("Total number of words in the document after removing \""+w+"\" = "+myWords.totalWords()+"\n\n");
                        }
                        else{
                            writer.write("The word \""+w+"  was not found in the document."+"\n");
                            writer.write(" The Total number of words in the document remains the same="+myWords.totalWords()+"\n");
                        }                           
                    }
                }
            /*check if the line contains the string "WORDFREQUENCY" using str.matches( -- ) method*/  
            else if(line.contains("WORDFREQUENCY")){
                writer.write("*******************************************\n");
                writer.write("-----------WORDFREQUENCY Command-------------\n");
                writer.write("*******************************************\n\n");
                /*I'll creat flag to reach the second word in the line which I'll treat with*/
                int flag = 0;
                
                for(String w:line.split("\\s",0)){
                    /* if flag == 0 then it's the first word in the line , and if flag  == 1 then it's the desired word */
                    if(flag == 0)
                    {
                        flag = 1;
                        continue;                        
                    }
                    else if(flag == 1){
                        writer.write("The frequency of the word  \""+w+"\" in the document = "+myWords.wordFrequency(w)+"\n\n");                      
                    }

                }

            }
            /*check if the line contains the string "MOSTFREQUENT" using str.matches( -- ) method*/  
            else if(line.matches("MOSTFREQUENT")){
                writer.write("*******************************************\n");
                writer.write("-----------MOSTFREQUENT Command-------------\n");
                writer.write("*******************************************\n\n");
                /*here I'll use the MostFrequent() and wordFrequency(myWords.MostFrequent()) methods*/
                writer.write("The most frequent word in the document is \""+myWords.MostFrequent()+"\" with a frequency of "+myWords.wordFrequency(myWords.MostFrequent())+"\n\n");      
            }
            /*check if the line contains the string "MOSTFREQUENT" using str.matches( -- ) method*/ 
            else if(line.matches("REVERSEPRINTLIST")){
                writer.write("*******************************************\n");
                writer.write("-----------REVERSEPRINTLIST Command-------------\n");
                writer.write("*******************************************\n\n");
                /*here the reversePrint(myWords.head) will return the string which I'll write to Outputfile*/
                writer.write(myWords.reversePrint(myWords.getHead()));
            }      
            /*check if the line contains the string "MOSTFREQUENT" using str.matches( -- ) method*/ 
            else if(line.matches("PRINTLIST")){
                writer.write("*******************************************\n");
                writer.write("-----------PRINTLIST Command-------------\n");
                writer.write("*******************************************\n\n");
                /*here the printAllWordes() will return the string which I'll write to Outputfile*/
                writer.write(myWords.printAllWordes());
            }      
            }  
        /*finally we must close the Output.txt file using close()*/
           writer.close(); 
        }
        
        
    }


