package data_structures;

import java.util.Iterator;

/**
 * Created by admin on 15.11.2014.
 */
public class BinarySearchTree<E extends Comparable<E>> implements BTree<E>, Iterable<E> {

    private Node root;

    public BinarySearchTree(){

    }

    public BinarySearchTree(E...arr){
        for(E el : arr){
            add(el);
        }
    }

    @Override
    public boolean add(E el) {
        if (root == null) {
            addIfTreeEmpty(el);
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

    private void addIfTreeEmpty(E el){
        root = new Node(el, null, null, null);
    }

    private void add(E el, Node curr) {

        if(root == null){
            addIfTreeEmpty(el);
            return;
        }

        if(curr == null){
            return;
        }

        if(el.compareTo(curr.val) < 0){
            if(curr.lChild == null){
                curr.lChild = new Node(el, null, null, curr);
            } else {
                add(el, curr.lChild);
            }
        } else {
            if(curr.rChild == null){
                curr.rChild = new Node(el, null, null, curr);
            } else {
                add(el, curr.rChild);
            }
        }
    }

    public void leftRotate(Node pivot){

        if(pivot.parent == null){
            return;
        }

        pivot.parent.rChild = pivot.lChild;
        pivot.lChild = pivot.parent;
        pivot.parent = pivot.parent.parent;

    }

    public void rightRotate(Node pivot){
        if(pivot.parent == null){
            return;
        }
        pivot.parent.lChild = pivot.rChild;
        pivot.rChild = pivot.parent;
        pivot.parent = pivot.parent.parent;
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

        } else if(forDelete.lChild == null){

        } else if(forDelete.rChild == null) {

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

    public void traverse(){
        traverse(root);
    }

    @Override
    public String toString() {
        return traverse(root);
    }

    private String traverse(Node node){
        String res = "";
        if(node.lChild != null){
             res += traverse(node.lChild);
        }
        res += node.val.toString() + ", ";
        if(node.rChild != null){
            res += traverse(node.rChild);
        }

        return res;
    }


    @Override
    public Iterator<E> iterator() {
        return new BinarySearchTreeIterator();
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

    private class BinarySearchTreeIterator implements Iterator <E>{

        Node next;

        private BinarySearchTreeIterator() {
            next = goToEnd(root);
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            E ret = next.val;

            if(next.parent == null){
                next = null;
                return ret;
            }

            if(next.rChild != null){
                next = goToEnd(next.rChild);
            }else if(next == next.parent.lChild){
                next = next.parent;
            } else if(next == next.parent.rChild){
                Node par = next.parent;
                Node child = next;
                while(par.lChild != child && par.parent != null){
                    child = par;
                    par = par.parent;
                }
                next = par;
            }

            return ret;
        }

        private Node goToEnd(Node iter){

            if(iter.lChild != null){
                return goToEnd(iter.lChild);
            }

            if(iter.rChild != null){
                return goToEnd(iter.rChild);
            }

            return iter;
        }

        @Override
        public void remove() {

        }
    }
}
