package com.base.demo.jdk;

import java.io.Serializable;
import java.util.*;

/**
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 *
 * @author  Doug Lea
 * @author  Josh Bloch
 * @author  Arthur van Hoff
 * @author  Neal Gafter
 * @see     Object#hashCode()
 * @see     Collection
 * @see     Map
 * @see     TreeMap
 * @see     Hashtable
 * @since   1.2
 */
public class MyHashMap<K,V> extends AbstractMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {

    /**
     * 默认初始容量-必须是2的幂。默认是16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     *如果隐式指定了更高的值，则使用的最大容量
     *由任何一个带参数的构造函数。
     *必须是2的幂<=1<<30。 2的30次方
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 构造函数中未指定时使用的加载因子。默认是0.75
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     *  当桶(bucket)上的结点数大于这个值时会转成红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;


    /**
     * 当桶(bucket)上的结点数小于这个值时树转链表
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 桶中结构转化为红黑树对应的table的最小大小
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * 哈希表的加载因子。
     *
     * @serial
     */
    final float loadFactor;



    /**
     * 也就是存储值的Node节点
     * 数组，又叫作桶（bucket）
     *分配时，长度总是2的幂。
     */
    transient MyHashMap.Node<K,V>[] table;

    /**
      作为entrySet()的缓存.
     * 遍历我们的key与Value的时候使用
     */
    transient Set<Map.Entry<K,V>> entrySet;
    /**
     * 元素的数量
     */
    transient int size;

    /**
     * 修改次数，用于在迭代的时候执行快速失败策略
     */
    transient int modCount;

    /**
     * 当桶的使用数量达到多少时进行扩容，threshold = capacity * loadFactor
     */
    int threshold;


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }



    /**
     *基本散列bin节点，用于大多数条目。（见下文）
     *TreeNode子类，并在LinkedHashMap中查找其条目子类。）
     */
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
       Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    /* ---------------- Public operations -------------- */

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial
     * capacity and load factor.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        }
        if (initialCapacity > MAXIMUM_CAPACITY) {
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        }
        this.loadFactor = loadFactor;
        // 计算扩容门槛
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     * 返回给定目标容量的两个大小的幂。
     */
    static final int tableSizeFor(int cap) {
        // 扩容门槛为传入的初始容量往上取最近的2的n次方
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the specified initial
     * capacity and the default load factor (0.75).
     *
     * @param  initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }


    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    /**
     * Constructs a new <tt>HashMap</tt> with the same mappings as the
     * specified <tt>Map</tt>.  The <tt>HashMap</tt> is created with
     * default load factor (0.75) and an initial capacity sufficient to
     * hold the mappings in the specified <tt>Map</tt>.
     *
     * @param   m the map whose mappings are to be placed in this map
     * @throws  NullPointerException if the specified map is null
     */
    public MyHashMap(Map<? extends K, ? extends V> m) {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m, false);
    }

    /**
     * Implements Map.putAll and Map constructor
     *
     * @param m the map
     * @param evict false when initially constructing this map, else
     * true (relayed to method afterNodeInsertion).
     */
    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
        int s = m.size();
        if (s > 0) {
            // pre-size
            if (table == null) {
                float ft = ((float)s / loadFactor) + 1.0F;
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                        (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold) {
                    threshold = tableSizeFor(t);
                }
            }
            else if (s > threshold) {
                //大小超过门槛值 扩容
//                resize();
            }
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                //遍历Map放入Map中
                K key = e.getKey();
                V value = e.getValue();
                putVal(hash(key), key, value, false, evict);
            }
        }


    }


    /**
     * Implements Map.put and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        //c语言的命名方式
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //// 如果桶的数量为0，则初始化
        if ((tab = table) == null || (n = tab.length) == 0) {
            //如果存放元素为空 resize()?
            n = (tab = resize()).length;
        }
        // (n - 1) & hash 计算元素在哪个桶中
        if ((p = tab[i = (n - 1) & hash]) == null)
            // 初始化放入桶中第一个位置
            tab[i] = newNode(hash, key, value, null);
        else {
            // 如果桶中已经有元素存在了
            Node<K,V> e; K k;
            // 如果桶中第一个元素的key与待插入元素的key相同，保存到e中用于后续修改value值
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode) {
                //如果节点是树类型 插入树节点
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }   else {
                //遍历链表 插入尾部
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // -1 for 1st 桶中的数量大于8个时 树化
                        if (binCount >= TREEIFY_THRESHOLD - 1)
//                            treeifyBin(tab, hash);
                        {
                            break;
                        }
                    }
                    //如果该值和key已经存在 不操作 退出
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }

                // 如果找到了对应key的元素  记录下旧值 判断是否需要替换旧值 并返回旧值
                if (e != null) {
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null) {
                        e.value = value;
                    }
                    // 在节点被访问后做点什么事，在LinkedHashMap中用到
//                    afterNodeAccess(e);
                    // 返回旧值
                    return oldValue;
                }


            }

        }
        //操作次数加一 这个次数记录有什么意义呢
        ++modCount;
        //如果当前容量 大于 16*0.75 = 12 扩容
        if (++size > threshold) {
            resize();
        }

        // 在节点插入后做点什么事，在LinkedHashMap中用到
        afterNodeInsertion(evict);

        return null;
    }

    // Callbacks to allow LinkedHashMap post-actions
    void afterNodeInsertion(boolean evict) { }


    // Create a regular (non-tree) node
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }

    private Node<K,V>[] resize() {
        return null;
    }
//    /**
//     * Tree version of putVal.
//     */
//    final TreeNode<K,V> putTreeVal(HashMap<K,V> map, Node<K,V>[] tab,
//                                           int h, K k, V v) {
//        Class<?> kc = null;
//        boolean searched = false;
//        TreeNode<K,V> root = (parent != null) ? root() : this;
//        for (TreeNode<K,V> p = root;;) {
//            int dir, ph; K pk;
//            if ((ph = p.hash) > h)
//                dir = -1;
//            else if (ph < h)
//                dir = 1;
//            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                return p;
//            else if ((kc == null &&
//                    (kc = comparableClassFor(k)) == null) ||
//                    (dir = compareComparables(kc, k, pk)) == 0) {
//                if (!searched) {
//                    TreeNode<K,V> q, ch;
//                    searched = true;
//                    if (((ch = p.left) != null &&
//                            (q = ch.find(h, k, kc)) != null) ||
//                            ((ch = p.right) != null &&
//                                    (q = ch.find(h, k, kc)) != null))
//                        return q;
//                }
//                dir = tieBreakOrder(k, pk);
//            }
//
//            TreeNode<K,V> xp = p;
//            if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                Node<K,V> xpn = xp.next;
//                TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);
//                if (dir <= 0)
//                    xp.left = x;
//                else
//                    xp.right = x;
//                xp.next = x;
//                x.parent = x.prev = xp;
//                if (xpn != null)
//                    ((TreeNode<K,V>)xpn).prev = x;
//                moveRootToFront(tab, balanceInsertion(root, x));
//                return null;
//            }
//        }
//    }
    /**
     * Entry for Tree bins. Extends LinkedEntry (which in turn
     * extends Node) so can be used as extension of either regular or
     * linked node.
     */
    static final class TreeNode<K,V> extends Entry<K,V> {
        TreeNode<K, V> parent;  // red-black tree links
        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode<K, V> prev;    // needed to unlink next upon deletion
        boolean red;

        TreeNode(int hash, K key, V val, Node<K, V> next) {
            super(hash, key, val, next);
        }

        /**
         * Returns root of tree containing this node.
         */
        final TreeNode<K, V> root() {
            for (TreeNode<K, V> r = this, p; ; ) {
                if ((p = r.parent) == null) {
                    return r;
                }
                r = p;
            }
        }
    }
        /**
         * Node subclass for normal LinkedHashMap entries.
         */
        static class Entry<K,V> extends MyHashMap.Node<K,V> {
            Entry<K,V> before, after;
            Entry(int hash, K key, V value,  MyHashMap.Node<K,V> next) {
                super(hash, key, value, next);
            }
        }

    /**
     * hash取模法
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    @Override
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }


}
