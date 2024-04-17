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
public class PilaNumeros {
    private Integer[] pila;
    protected int length;
    private int cursor;

    public PilaNumeros(int length) {
        this.pila = new Integer[length];
        this.length = length;
        this.cursor = -1;
    }
    
    public PilaNumeros(int length, Integer objeto[]){
        this.pila = objeto;
        this.length = objeto.length;
        this.cursor = -1;
    }
    
   
    public void push(Integer objeto){
        if(!PilaLlena()){
            cursor++;
            pila[cursor] = objeto;
        }else{System.out.println("La pila esta llena y no se puede agregar mas elementos");}
    }
    public Integer pop(){
        if(!pilaVacia()){
            Integer retorno = verElemento();
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
    
    public boolean PilaLlena(){
        return cursor == length -1;
    }
    
    public Integer verElemento(){
        if(!pilaVacia()){
            System.out.println(pila[cursor]);
            return pila[cursor];
        }
        
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public PilaNumeros invierteEficiente(){
        PilaNumeros pilaAux = new PilaNumeros(this.length);
        for (int i = 0; i < this.length; i++) {
            pilaAux.push(pop());
        }
        return pilaAux;
    }
    
    public void invierteSimple(){
        PilaNumeros pilaAux1 = new PilaNumeros(this.length);
        PilaNumeros pilaAux2 = new PilaNumeros(this.length);
        for(int i = 0; i < this.length; i++){
            pilaAux1.push(pop());
        }
        for(int i=0; i< this.length; i++){
            pilaAux2.push(pilaAux1.pop());
        }
        for(int i=0; i< this.length; i++){
            push(pilaAux2.pop());
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
