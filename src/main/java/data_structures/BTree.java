package data_structures;

import java.util.Objects;

public interface BTree<T> {

    boolean add(T el);
    boolean contains(Object o);
    void delete(T el);


}
