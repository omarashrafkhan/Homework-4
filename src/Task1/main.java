package Task1;

public class main {



    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        bst.insert(3);
        bst.insert(11);
        bst.insert(2);
        bst.insert(18);

//        System.out.println("In order traversal");
//        bst.traverseLNR(bst.root);
//
//        bst.delete(11);
//
//        System.out.println("Pre order traversal");
//        bst.traverseNLR(bst.root);
//
//        System.out.println("Post order traversal");
//        bst.traverseLRN(bst.root);

        bst.printRange(bst.root,3,18);



    }


}
