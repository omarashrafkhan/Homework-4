package Task1;

public class BST<T extends Comparable<T>> {


    Node<T> root;



    public void insert(T obj) {
        if (root == null) root = new Node<>(obj);
        else {
            Node<T> curr = root;
            Node<T> prev = root;

            while (curr != null) {
                if (obj.compareTo(curr.data) < 0) {
                    prev = curr;
                    curr = curr.left;
                } else if (obj.compareTo(curr.data) > 0) {
                    prev = curr;
                    curr = curr.right;
                } else return;
            }
            if (obj.compareTo(prev.data) < 0) prev.left = new Node<T>(obj);
            else prev.right = new Node<T>(obj);

        }
    }

    public Node<T>[] find(T key) {
        Node<T> parent = null;
        Node<T> current = root;

        while (current != null) {
            int comparison = key.compareTo(current.data);

            if (comparison == 0) {
                Node<T>[] result = new Node[2];
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
        Node<T>[] result = new Node[2];
        result[0] = null;
        result[1] = null;
        return result;
    }

    protected void delNoChild(Node<T> parent, Node<T> temp) {
        if (parent == temp) {
            // If the root node is to be deleted, and it has no children
            root = null;
        } else if (parent.left == temp) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    protected void delOneChild(Node<T> parent, Node<T> temp) {
        Node<T> child = (temp.left != null) ? temp.left : temp.right;

        if (parent == temp) {
            // If the root node is to be deleted, and it has one child
            root = child;
        } else if (parent.left == temp) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public void delete(T key) {
        Node<T> temp = root;
        Node<T> parent = root;


        Node[] ref = find(key);

        parent = ref[0];
        temp = ref[1];


        if (temp != null && key.compareTo(temp.data) == 0) {
            if (temp.left == null && temp.right == null) { // no child case
                delNoChild(parent, temp);

            } // one child case
            else if (temp.left == null || temp.right == null) {
                delOneChild(parent, temp);
            } else {
                //have two children
                Node<T> successor = findSuccessor(temp);
                temp.data = successor.data;
                delOneChild(parent, successor);

            }
        } else {
            System.out.println("key not found");
        }
    }


    private Node<T> findSuccessor(Node<T> node) {
        Node<T> successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }

    public void traverseLNR(Node<T> n) {
//        if (n == null) return;
        if (n.left != null) traverseLNR(n.left);
        System.out.println(n.data);
        if (n.right != null) traverseLNR(n.right);
    }

    public void traverseNLR(Node<T> n) {
        if (n != null) {
            System.out.println(n.data);
            traverseNLR(n.left);
            traverseNLR(n.right);
        }
    }

    public void traverseLRN(Node<T> n) {
        if (n != null) {
            traverseLRN(n.left);
            traverseLRN(n.right);
            System.out.println(n.data);
        }
    }

    public void printRange(Node r, int k1,int k2){
        if (r == null)
            return;

        printRange(r.left,k1,k2);
        if ((int) r.data<=k2 && (int) r.data>=k1){
            System.out.print(r.data + " ");
        }
        printRange(r.right,k1,k2);

    }




}
