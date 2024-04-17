/*
Verificación de equilibrio de paréntesis
Diseña un programa que tome una cadena de texto que puede contener
varios tipos de paréntesis, incluyendo (), {}, [], y <> y determine si los
paréntesis están equilibrados en la cadena. Es decir, cada paréntesis de
apertura tiene su par correspondiente de cierre y están correctamente
anidados. Utiliza una pila para realizar la verificación. Por ejemplo, la
cadena "{[(a+b)*c]-(d+e)}" debería ser considerada como  equilibrada,
mientras que "[{()}]" también lo es, pero "[(])" no lo es.
 */
package eda.tp3_2;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class PilaCaracteres {
   
    private Character[] pila;
    protected int length;
    private int cursor;

    public PilaCaracteres(int length) {
        this.pila = new Character[length];
        this.length = length;
        this.cursor = -1;
    }
    
    public PilaCaracteres(int length, Character objeto[]){
        this.pila = objeto;
        this.length = objeto.length;
        this.cursor = -1;
    }
    
   
    public void push(Character objeto){
        if(!PilaLlena()){
            cursor++;
            pila[cursor] = objeto;
        }else{System.out.println("La pila esta llena y no se puede agregar mas elementos");}
    }
    public Character pop(){
        if(!pilaVacia()){
            Character retorno = verElemento();
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
    
    public Character verElemento(){
        if(!pilaVacia()){
            System.out.println(pila[cursor]);
            return pila[cursor];
        }
        
        System.out.println("La pila esta vacia y no se puede quitar mas elementos");
        return null;
    }
    
    public PilaCaracteres invierteEficiente(){
        PilaCaracteres pilaAux = new PilaCaracteres(this.length);
        for (int i = 0; i < this.length; i++) {
            pilaAux.push(pop());
        }
        return pilaAux;
    }
    
    public void invierteSimple(){
        PilaCaracteres pilaAux1 = new PilaCaracteres(this.length);
        PilaCaracteres pilaAux2 = new PilaCaracteres(this.length);
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

