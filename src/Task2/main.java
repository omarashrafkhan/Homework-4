package Task2;

public class main {


    public static void main(String[] args) {
        BST dictionary = new BST();

        dictionary.insert("Hello","something");
        dictionary.insert("Bye","goodbye");
        dictionary.insert("Aloha","something again");


        dictionary.delete("Aloha");


        dictionary.traverseLNR(dictionary.root);
    }

}
