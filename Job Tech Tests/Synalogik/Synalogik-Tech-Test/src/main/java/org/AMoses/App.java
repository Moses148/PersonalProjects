package org.AMoses;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class App 
{
    public static int main() throws Exception
    {
        // Asks the user the input the name of the file they
        // wish to assess along with the necessary variables needed for it
        String UserInput;
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Input the file name you wish to assess (without the file extension):");

        // Takes the user's input, attempts to open a text file matching the name given and
        // loops until the user enters a valid file name
        while(true)
        {
            UserInput = (Input.readLine() + ".txt");
            File TempDir = new File(UserInput);
            if (TempDir.exists())
            {
                System.out.println(UserInput + " found");
                break;
            }
            else
            {
                System.out.println("\nFile entered does not exist, try again");
            }
        }

        long StartTime = System.nanoTime();

        //Creates a object called Document, an object that stores in the information for a particular file
        // as well as methods for obtaining said information and outputting it
        Document RequestedFile = new Document(UserInput);
        RequestedFile.Read();
        RequestedFile.Output();

        long EndTime = System.nanoTime();
        System.out.println("\nExecution time: " + (EndTime - StartTime) / 1e9 + " seconds\n\n");

        return RequestedFile.WordCount();
    }
}
