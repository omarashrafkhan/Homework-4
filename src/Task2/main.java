package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        BST dictionary = new BST();

        File newFile = new File("src/Task2/Dictionary.txt");

        try (Scanner myReader = new Scanner(newFile)) {
            String[] splittingWords = {"n\\.", "-n\\.", "v\\.", "-v\\.", "adj\\.", "-adj\\.", "prefix", "abbr\\.",
                    "naut\\.", "symb\\.", "colloq\\.", "comb\\.", "predic\\.","int\\.","prep\\.","contr\\.",
                    "poss\\.","pron\\.","suffix","var\\.","attrib\\.","Adv\\."
            };

            // Create the regular expression by joining splittingWords with the | (OR) operator
            String regex = String.join("|", splittingWords);

            System.out.println("The regex according to which I'm splitting the word and meaning: " + regex);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().trim();

                if (!line.isEmpty()) {
                    String[] wordMeaning = line.split(regex, 2);
                    if (wordMeaning.length == 2) {
                        dictionary.insert(wordMeaning[0].trim(), wordMeaning[1].trim());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(dictionary.size);

        int layerToPrint = 5;

        dictionary.traverseLNR(dictionary.root, layerToPrint);
    }
}
