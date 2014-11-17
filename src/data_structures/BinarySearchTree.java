package data_structures;

/**
 * Created by admin on 15.11.2014.
 */
public class BinarySearchTree<E extends Comparable<E>> implements BTree<E> {

    private Node root;


    @Override
    public boolean add(E el) {
        if (root == null) {
            root = new Node(el, null, null, null);
        } else {
            Node curr = root;
            while (curr != null) {
                Comparable forCompare = (Comparable) curr.val;
                if (forCompare.compareTo(el) < 0) {
                    if (curr.rChild == null) {
                        curr.rChild = new Node(el, null, null, curr);
                        break;
                    } else {
                        curr = curr.rChild; // way condition
                    }
                } else {
                    if (curr.lChild == null) {
                        curr.lChild = new Node(el, null, null, curr);
                        break;
                    } else {
                        curr = curr.lChild; // way condition
                    }
                }
            }
        }
        return true;
    }

    private void add(E el, Node curr) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void delete(E el) {
        Node forDelete = search(root, el);

        if (forDelete.lChild == null && forDelete.rChild == null) {
            if (forDelete.parent.lChild == forDelete) {
                forDelete.parent.lChild = null;
            } else {
                forDelete.parent.rChild = null;
            }

        }

        //TODO finish method
    }

    private Node search(Node curr, E el) {
        if (curr == null) {
            return null;
        }

        int compareRes = curr.val.compareTo(el);

        /*if(compareRes < 0){
            return search(curr.rChild, el);
        } else if(compareRes > 0){
            return search(curr.rChild, el);
        } else {
            return curr;
        }*/

        return compareRes > 0 ?
                search(curr.lChild, el) : ((compareRes < 0) ? search(curr.rChild, el) : curr);

    }


    private Node findMax(Node curr) {
        if (curr.rChild == null) {
            return curr;
        }

        return findMax(curr.rChild);
    }

    //Inner class
    private class Node {

        private E val;
        private Node lChild;
        private Node rChild;
        private Node parent;

        private Node() {
        }

        private Node(E val, Node lChild, Node rChild, Node parent) {
            this.val = val;
            this.lChild = lChild;
            this.rChild = rChild;
            this.parent = parent;
        }

        private Node(E val, Node lChild, Node rChild) {
            this.val = val;
            this.lChild = lChild;
            this.rChild = rChild;
        }

    }
}
