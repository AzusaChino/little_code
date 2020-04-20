package cn.az.code.common;

import lombok.Data;

/**
 * @author az
 * @date 2020/4/20
 */
@Data
public class Node<K, V> {

    public K key;
    public V val;
    public Node<K, V> prev;
    public Node<K, V> next;

    public Node(K k, V v) {
        this.key = k;
        this.val = v;
    }
}
