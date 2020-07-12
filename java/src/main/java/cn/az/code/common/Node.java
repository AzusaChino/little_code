package cn.az.code.common;

/**
 * @author az
 * @date 2020/4/20
 */
public class Node<K, V> {

    public K key;
    public V val;
    public Node<K, V> prev;
    public Node<K, V> next;
    public Node<K, V> child;

    public Node(K k, V v) {
        this.key = k;
        this.val = v;
    }
}
