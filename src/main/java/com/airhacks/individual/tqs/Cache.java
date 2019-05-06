package com.airhacks.individual.tqs;

import java.util.HashMap;

public class Cache<K, V> {

    public static final int DEFAULT_MAX_SIZE = 15;

    private HashMap<K, Element<Hash<K, V>>> mapa = new HashMap<>();
    private Element<Hash<K, V>> start;
    private Element<Hash<K, V>> end;
    private int cacheSize;

    public Cache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public Cache() {
        this(DEFAULT_MAX_SIZE);
    }
    
    public void put(K key, V value) {
        Element<Hash<K, V>> elem = mapa.get(key);
        if (elem != null) {
            elem.getValue().setValue(value);
            remove(elem);
            add(elem);
        } else {
            if (mapa.size() >= cacheSize) {
                remove(mapa.remove(start.getValue().getKey()));
            }
            mapa.put(key, add(key, value));
        }
    }
    
    public void remove(K key) {
        Element<Hash<K, V>> elem = mapa.remove(key);
        remove(elem);
    }
    
    public int size() {
        return mapa.size();
    }

    public V get(K key) {
        Element<Hash<K, V>> elem = mapa.get(key);
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
        Element<Hash<K, V>> node = mapa.get(key);
        if (node != null) {
            return node.getValue().getValue();
        }
        return null;
    }

}
