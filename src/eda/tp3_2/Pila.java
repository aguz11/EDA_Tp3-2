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
    protected int cursor;

    public Pila(int length) {
        this.pila = (T[]) new Object[length];
        this.length = length;
        this.cursor = -1;
    }
    
  
    public Pila(int length, T[] elemento){
        this.pila = elemento;
        this.length = elemento.length;
        this.cursor = -1;
    }
    
    
    public void push(T elemento){
        if(!pilaLlena()){
            cursor++;
            pila[cursor] = elemento;
//            pila.add(entero);
        }else{System.out.println("La pila esta llena y no se puede agregar mas elementos");}
    }
    public T pop(){
        if(!pilaVacia()){
            T retorno = verElemento();
            pila[cursor] = null;
            cursor--;
            return retorno;
        }
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public boolean pilaVacia(){
        return cursor < 0;
    }
    
    public boolean pilaLlena(){
        return cursor == length -1;
    }
    
    public T verElemento(){
        if(!pilaVacia()){
//            System.out.println(pila[cursor]);
            return pila[cursor];
        }
        
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public Pila invierteEficiente(){
        Pila pilaAux = new Pila(this.length);
        for (int i = 0; i < this.length; i++) {
            pilaAux.push(pop());
        }
        return pilaAux;
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
            int i = 0;
            while(i < length && pila[i] != null){
                retorno += pila[i].toString();
                retorno += ", ";
                i++;
            }
        return "Pila {" + retorno + '}';
        }
        return "";
    }
    

    
}
