package Task2;

class wordNode {

    String word;
    String meaning;

    wordNode left;
    wordNode right;




    public wordNode(String word, String meaning){
        this.word = word;
        this.meaning = meaning;
    }


}



public class BST {

    wordNode root;


    public void insert(String word, String meaning){
        if (root == null) root = new wordNode(word,meaning);
        else {
            wordNode curr = root;
            wordNode prev = root;

            while (curr != null) {
                if (word.compareTo(curr.word) < 0) {
                    prev = curr;
                    curr = curr.left;
                } else if (word.compareTo(curr.word) > 0) {
                    prev = curr;
                    curr = curr.right;
                } else return;
            }
            if (word.compareTo(prev.word) < 0) prev.left = new wordNode(word,meaning);
            else prev.right = new wordNode(word,meaning);

        }




    }


    public void traverseLNR(wordNode n) {
//        if (n == null) return;
        if (n.left != null) traverseLNR(n.left);
        System.out.println(n.word);
        if (n.right != null) traverseLNR(n.right);
    }


    public wordNode[] find(String word) {
        wordNode parent = null;
        wordNode current = root;

        while (current != null) {
            int comparison = word.compareTo(current.word);

            if (comparison == 0) {
                wordNode[] result = new wordNode[2];
                result[0] = parent; // Parent node
                result[1] = current; // Current node
                return result;
            } else if (comparison < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }


        //means not found
        wordNode[] result = new wordNode[2];
        result[0] = null;
        result[1] = null;
        return result;
    }



    protected void delNoChild(wordNode parent, wordNode temp) {
        if (parent == temp) {
            // If the root node is to be deleted, and it has no children
            root = null;
        } else if (parent.left == temp) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    protected void delOneChild(wordNode parent, wordNode temp) {
        wordNode child = (temp.left != null) ? temp.left : temp.right;

        if (parent == temp) {
            // If the root node is to be deleted, and it has one child
            root = child;
        } else if (parent.left == temp) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public void delete(String word) {
        wordNode temp = root;
        wordNode parent = root;


        wordNode[] ref = find(word);

        parent = ref[0];
        temp = ref[1];


        if (temp != null && word.compareTo(temp.word) == 0) {
            if (temp.left == null && temp.right == null) { // no child case
                delNoChild(parent, temp);

            } // one child case
            else if (temp.left == null || temp.right == null) {
                delOneChild(parent, temp);
            } else {
                //have two children
                wordNode successor = findSuccessor(temp);
                temp.word = successor.word;
                delOneChild(parent, successor);

            }
        } else {
            System.out.println("key not found");
        }
    }

    private wordNode findSuccessor(wordNode node) {
        wordNode successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }










}
