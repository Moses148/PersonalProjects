package org.AMoses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//The document class contains the information for a particular text file, one given when the object is constructed
public class Document
{
    private int Count = 0; //Stores number of words
    private final File TextFile; //File object of the document
    private int Characters = 0; //Number of total characters
    private final ArrayList<Integer> Lengths = new ArrayList<Integer>(); //stores the amount of words for each word length
    private ArrayList<Integer> MostOccurring = new ArrayList<Integer>(); //stores which word lengths are the most occurring

    //Constructs the object and creates the File object with the given path
    public Document(String args)
    {
        TextFile = new File(args);
    }

    //Method that reads the text file and assesses it
    public void Read() throws FileNotFoundException
    {
        //String used to remove punctuation from the length of a word
        String Punctuation = ".,:;?!";
        Scanner fileScanner = new Scanner(TextFile);
        while( fileScanner.hasNextLine())
        {
            //Takes the next line in the file and splits them into an array for each
            // word with whitespaces and new lines separating the words
            String Line =  fileScanner.nextLine();
            String[] Words = Line.split("\\s+");

            //Loops through the array of words
            for (String Word : Words)
            {
                //Saves the length of a word for it to be manipulated such as removing punctuation and  blank spaces
                if (!Word.equals(""))
                {
                    int Len = Word.length();
                    Len -= (Punctuation.contains(String.valueOf(Word.charAt(Word.length()-1)))) ? 1 : 0;

                    //If any characters remain, it increments the necessary data in the ArrayList
                    if (Len != 0)
                    {
                        Count++;
                        Characters += Len;

                        //If the arraylist is shorter then the length of the new word then it means that the
                        //program hasn't encountered a word this long, it increases the size of the ArrayList to match the
                        //new word
                        if (Len > Lengths.size()) {
                            for (int i = Lengths.size(); i < Len; i++) {
                                Lengths.add(0);
                            }
                        }
                        Lengths.set(Len - 1, Lengths.get(Len - 1) + 1);
                    }
                }
            }
        }
    }

    //Outputs the data from the document including the number of words, number of words for each length,
    //average word length and the most occurring word lengths
    public void Output()
    {
        System.out.println("Word Count: " + Count);
        System.out.println("Characters: " + Characters);
        System.out.println("Average Word Length: " + (float)Characters / (float)Count);

        //Loops through each word length and outputs it
        for (int i = 0; i < Lengths.size(); i++)
        {
            if (Lengths.get(i) != 0)
            {
                System.out.println("Number of words of length " + (i + 1) + " is " + Lengths.get(i));

                //Checks to see if the current word length is considered to be the most occurring
                if (Lengths.get(i).equals(Collections.max(Lengths)))
                {
                    MostOccurring.add(i);
                }
            }
        }

        System.out.print("The most frequently occurring word length is " + Collections.max(Lengths) + ", for word lengths of " + (MostOccurring.get(0) + 1));
        for (int i = 1; i < MostOccurring.size(); i++)
        {
            System.out.print(" & " + (MostOccurring.get(i) + 1));
        }
    }

    public int WordCount()
    {
        return Count;
    }
}