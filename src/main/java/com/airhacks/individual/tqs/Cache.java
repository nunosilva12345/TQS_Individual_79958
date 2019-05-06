package com.airhacks.individual.tqs;

import java.util.HashMap;

public class Cache<K, V> {

    public final static int DEFAULT_MAX_SIZE = 15;

    private HashMap<K, Element<Hash<K, V>>> map = new HashMap<>();
    private Element<Hash<K, V>> start, end;
    private int CacheSize;

    public Cache(int CacheSize) {
        this.CacheSize = CacheSize;
    }

    public Cache() {
        this(DEFAULT_MAX_SIZE);
    }
    
    public void put(K key, V value) {
        Element<Hash<K, V>> elem = map.get(key);
        if (elem != null) {
            elem.getValue().setValue(value);
            remove(elem);
            add(elem);
        } else {
            if (map.size() >= CacheSize) {
                remove(map.remove(start.getValue().getKey()));
            }
            map.put(key, add(key, value));
        }
    }
    
    public void remove(K key) {
        Element<Hash<K, V>> elem = map.remove(key);
        remove(elem);
    }
    
    public int size() {
        return map.size();
    }

    public V get(K key) {
        Element<Hash<K, V>> elem = map.get(key);
        if (elem != null) {
            remove(elem);
            add(elem);
            return elem.getValue().getValue();
        } else {
            return null;
        }
    }

    

    private void add(Element<Hash<K, V>> node) {
        if (end != null) {
            end.setNext(node.setPrevious(end));
        }
        if (start == null) {
            start = node;
        }
        end = node;
    }

    private Element<Hash<K, V>> add(K key, V value) {
        Element<Hash<K, V>> node = new Element<>(new Hash<>(key, value));
        add(node);
        return node;
    }

    private void remove(Element<Hash<K, V>> elem) {
        Element<Hash<K, V>> anterior = elem.getPrevious();
        Element<Hash<K, V>> next = elem.getNext();
        if (anterior != null) {
            anterior.setNext(next);
        } else {
            start = next;
        }
        if (next != null) {
            next.setPrevious(anterior);
        } else {
            end = anterior;
        }
        elem.setPrevious(null).setNext(null);
    }

    
    protected V raw(K key) {
        Element<Hash<K, V>> node = map.get(key);
        if (node != null) {
            return node.getValue().getValue();
        }
        return null;
    }

}
