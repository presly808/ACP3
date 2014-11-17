package data_structures;

import java.util.Objects;

/**
 * Created by admin on 15.11.2014.
 */
public interface BTree<T> {

    boolean add(T el);
    boolean contains(Object o);
    void delete(T el);

}
