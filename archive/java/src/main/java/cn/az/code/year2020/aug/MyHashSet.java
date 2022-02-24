package cn.az.code.year2020.aug;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author az
 * @since 08/02/20
 */
public class MyHashSet {

    List<Integer>[] container;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;

    /** Initialize your data structure here. */
    public MyHashSet() {
        container = new LinkedList[cap];
    }

    public void add(int key) {
        if(contains(key)) {
            return;
        }
        if(loadFactor*cap == count){
            count = 0;
            //rehash
            cap *= 2;
            List<Integer>[] oldC = container;
            container = new LinkedList[cap];
            for (List<Integer> list : oldC) {
                if (list != null) {
                    for (int entry : list) {
                        this.add(entry);
                    }
                }
            }
        }
        int hash = key % cap;
        if(container[hash] == null) {
            container[hash] = new LinkedList<>();
        }
        container[hash].add(key);
        ++count;
    }

    public void remove(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null){
            Iterator<Integer> itr = list.iterator();
            while(itr.hasNext()) {
                if(itr.next() == key){
                    itr.remove();
                    --count;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if(list != null){
            for (Integer integer : list) {
                if (integer == key) {
                    return true;
                }
            }
        }
        return false;
    }
}
