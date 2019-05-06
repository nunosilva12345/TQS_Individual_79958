
package com.airhacks.individual.tqs;

public class Element<V> {
        
        private V valor;
        private Element<V> x = null;
        private Element<V> y = null;
        
        public Element(V valor) {
            this.valor = valor;
        }
        
        public Element<V> setValue(V valor) {
            this.valor = valor;
            return this;
        }
        
        public V getValue() {
            return valor;
        }
        
        
        public Element<V> getNext() {
            return y;
        }

        public Element<V> setNext(Element<V> y) {
            this.y = y;
            return this;
        }

        public Element<V> getPrevious() {
            return x;
        }

        public Element<V> setPrevious(Element<V> x) {
            this.x = x;
            return this;
        }
        
    }
