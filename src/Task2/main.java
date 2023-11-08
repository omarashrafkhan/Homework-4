package Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws FileNotFoundException {
        BST dictionary = new BST();

        File newFile = new File("src\\Task2\\Dictionary.txt");

        Scanner myReader = new Scanner(newFile);

        while(myReader.hasNextLine()){


            String line = myReader.nextLine();
            if(line.length() <= 2){
//                myReader.nextLine();
            }

            else{


                String[] wordMeaning;


                wordMeaning = line.split(" ",2);

                dictionary.insert(wordMeaning[0],wordMeaning[1]);



            }


        }



        int layerToPrint = 1;
//        this is basically how far you want to print the tree, since the entire tree printing causes
//        StackOverflow exception




        dictionary.traverseLNR(dictionary.root,layerToPrint);



    }

}
