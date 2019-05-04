package com.airhacks.individual.tqs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cache<K, V> {

    public static int DEFAULT_MAX_SIZE = 15;

    private HashMap<K, Element<Hash<K, V>>> map = new HashMap<>();
    private Element<Hash<K, V>> start, end;
    private int CacheSize;

    public Cache(int CacheSize) {
        this.CacheSize = CacheSize;
    }

    public Cache() {
        this(DEFAULT_MAX_SIZE);
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

    public List<K> keys() {
        return new ArrayList<>(map.keySet());
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
        if (elem != null) {
            remove(elem);
        }
    }

    public int size() {
        return map.size();
    }

    protected V raw(K key) {
        Element<Hash<K, V>> node = map.get(key);
        if (node != null) {
            return node.getValue().getValue();
        }
        return null;
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

    private static class Element<V> {

        private V valor;
        private Element<V> x = null;
        private Element<V> y = null;

        public Element(V valor) {
            this.valor = valor;
        }

        public Element<V> getPrevious() {
            return x;
        }

        public Element<V> setPrevious(Element<V> x) {
            this.x = x;
            return this;
        }

        public Element<V> getNext() {
            return y;
        }

        public Element<V> setNext(Element<V> y) {
            this.y = y;
            return this;
        }

        public V getValue() {
            return valor;
        }

        public Element<V> setValue(V valor) {
            this.valor = valor;
            return this;
        }
    }
}
