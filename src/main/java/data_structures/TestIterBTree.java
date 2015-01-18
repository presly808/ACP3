package data_structures;

/**
 * Created by admin on 21.11.2014.
 */
public class TestIterBTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(20, 10, 5, 2, 6, 40, 30, 50, 45, 60);
        System.out.println(tree);

        /*for (Integer i : tree){
            System.out.println(i);
        }*/
    }
}
