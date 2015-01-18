package data_structures;

/**
 * Created by admin on 15.11.2014.
 */
public class TestBTree {


    public static void main(String[] args) {
        BTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(25);
        tree.add(15);
        tree.add(35);
        tree.add(20);
        tree.add(32);
        System.out.println();
    }
}
