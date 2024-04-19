/*
Unidos no mezclados
Se tienen 2 pilas con elementos ordenados de mayor a menor, se desea
pasar todos los elementos a una tercera pila en la que los elementos sigan
manteniendo el orden de mayor a menor.
*/
package eda.tp3_2;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class UnirPilasOrdenadas {
   
    public static Pila combinarPilas(Pila<Integer> pila1, Pila<Integer> pila2){
        
        Pila<Integer> pilaAux = new Pila<>((pila1.length + pila2.length));

        // Mientras ambas pilas tengan elementos
        while (!pila1.pilaVacia() && !pila2.pilaVacia()) {
            if (pila1.verElemento() > pila2.verElemento()) {
                pilaAux.push(pila1.pop());
            } else {
                pilaAux.push(pila2.pop());
            }
        }

        // Despues cuando una de las pilas esta vacia
        while (!pila1.pilaVacia()) {
            pilaAux.push(pila1.pop());
        }

        while (!pila2.pilaVacia()) {
            pilaAux.push(pila2.pop());
        }

        pilaAux.invierteEficiente();

        return pilaAux;
    }
    
    
}
