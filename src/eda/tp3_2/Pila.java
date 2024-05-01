/*
 3.2 – TAD Pilas
Reunirse en grupos de 3 integrantes
Cada grupo selecciona y resuelve un ejercicio de cada una de las complejidades

Complejidad baja
    b. Verificación de equilibrio de paréntesis <Character>
Complejidad media
    d. Unidos no mezclados <Integer>
 */
package eda.tp3_2;

/**
 *
 * @author Adam, Martin, Agustin
 * @param <T>
 */
public class Pila<T>  {
    protected T[] pila;
    protected int length;
    protected int tope;

    public Pila(int length) {
        this.pila = (T[]) new Object[length];
        this.length = length;
        this.tope = -1;
    }
    // Solo tomamos el largo un arreglo para mantener la estructura de la pila
    public Pila(T[] objeto){
        this(objeto.length);
    }

    public void push(T elemento){
        if(!pilaLlena()){
            tope++;
            pila[tope] = elemento;
//            pila.add(entero);
        }else{System.out.println("La pila esta llena y no se puede agregar mas elementos");}
    }
    public T pop(){
        if(!pilaVacia()){
            T retorno = verElemento();
            pila[tope] = null;
            tope--;
            return retorno;
        }
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public boolean pilaVacia(){
        return tope < 0;
    }
    
    public boolean pilaLlena(){
        return tope == length -1;
    }
    
    public T verElemento(){
        if(!pilaVacia()){
            return pila[tope];
        }
        
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public void invierteEficiente(){
        Pila<T> pilaAux = new Pila<>(this.length);
        for (int i = 0; i < this.length; i++) {
            pilaAux.push(pop());
        }
        this.pila = pilaAux.pila;
        this.tope = pilaAux.tope;
    }
    
    public void invierteSimple(){
        Pila pilaAux1 = new Pila(this.length);
        Pila pilaAux2 = new Pila(this.length);
        for(int i = 0; i < this.length; i++){
            pilaAux1.push(pop());
        }
        for(int i=0; i< this.length; i++){
            pilaAux2.push(pilaAux1.pop());
        }
        for(int i=0; i< this.length; i++){
            push((T) pilaAux2.pop());
        }
    }

    @Override
    public String toString() {
        String retorno = "";
        if(!pilaVacia()){
            int i = tope;
            while(!pilaVacia() && i > -1){
                if(pila[i] != null){
                    retorno += pila[i] + "";
                    retorno += ", ";
                }
                i--;
            }
        return "Pila {" + retorno + '}';
        }
        return "";
    }
    

    
}
