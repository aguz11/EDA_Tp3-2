/*
Unidos no mezclados
Se tienen 2 pilas con elementos ordenados de mayor a menor, se desea
pasar todos los elementos a una tercera pila en la que los elementos sigan
manteniendo el orden de mayor a menor.
*/
package eda.tp3_2;

import java.util.Stack;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class PilaNumeros {
    protected Pila<Integer> pila;
    
    public PilaNumeros(int length) {
        this.pila = new Pila<Integer>(length);
    }
    
    public PilaNumeros(int length, Integer numeros[]){
        this.pila = new Pila<Integer>(numeros);
    }
    
    public int size(){
        return pila.length;
    }
    
//    public void push(Integer numero){
//        pila.push(numero);
//    }
//    
//    public Integer pop(){
//        return pila.pop();
//    }
    
}
