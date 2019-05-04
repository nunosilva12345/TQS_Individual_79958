/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airhacks.individual.tqs;

/**
 *
 * @author nunos
 */
public class Element<V> {
        
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
