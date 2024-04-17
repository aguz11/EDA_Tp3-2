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

import java.util.Objects;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class PilaParentesis extends Pila{
    private Boolean esEquilibrada;
    private static char[][] parentesis = {{'(',')'},{'{','}'},{'[',']'},{'<','>'}};
    private enum P{
        OPEN,
        CLOSE
    }

    public PilaParentesis(String cadena) {
        super(getParentesis(cadena));
        
        if(cadena == null || "".equals(cadena) || this.length < 1){
            esEquilibrada = null;
        }
        if(length % 2 == 1){
            esEquilibrada = false;
            return;
        }
//        System.out.println("-----prueba de flujo pares-----");
        for(int i=0; i<super.length; i++){
            Character car = (Character)pila[i];
            if(esParenApertura(car)){
                push(car);
//                System.out.println("cursor="+ cursor);
            }
            if(esParenCierre(car)){
                if(pilaVacia()){
                    esEquilibrada = false;
                    return;
                }
                if(!Objects.equals(
                                    getParenApertura(car), 
                                      (char)pop()
                                  )
                  ){
                    esEquilibrada = false;
                    return;
                }
            }
        }
// El cursor de la superclase empieza en -1 para acceder el primer elemento en el indice 0
        if(cursor > -1){
//            System.out.println("cursor="+cursor);
            esEquilibrada = false;
            return;
        }
        esEquilibrada = true;
        return;
    }
    
    public static Character[] getParentesis(String cadena) {
        if (cadena == null || cadena.equals("")) {
            return null;
        }
        int i = 0;
        String strParen = "";
        for (char car : cadena.toCharArray()) {
 
            for(i=0; i<parentesis.length; i++){
                if (car == parentesis[i][P.OPEN.ordinal()]) {
                    strParen += car + "";
                }
                if (car == parentesis[i][P.CLOSE.ordinal()]) {
                    strParen += car + "";
                }
            }
            
        }
//        System.out.println("strParen=\""+ strParen + "\"; strParen.length=" + strParen.length());
        char[] charParen = strParen.toCharArray();
        Character[] carEnvolturaParen = new Character[charParen.length];
        int j = 0;
        for (char car : charParen) {
            carEnvolturaParen[j] = car;
            j++;
        }
        return carEnvolturaParen;
    }

     
    public Boolean esEquilibrada() {
        return esEquilibrada;
    }
    
    public boolean esParenApertura(Character car){
        for (char[] paren : parentesis) {
            if (car == paren[P.OPEN.ordinal()]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean esParenCierre(Character car){
        for (char[] paren : parentesis) {
            if (car == paren[P.CLOSE.ordinal()]) {
                return true;
            }
        }
        return false;
    }
    
    public Character getParenCierre(Character parenApertura){
        int i = 0;
        for(char[] paren: parentesis){
            if(parenApertura == paren[P.OPEN.ordinal()]){
                return parentesis[i][P.CLOSE.ordinal()];
            }
            i++;
        }
        return null;
    }
    
    public static Character getParenApertura(Character parenCierre){
        int i = 0;
//        System.out.print(parenCierre);
        for(char[] paren: parentesis){
            if(parenCierre == paren[P.CLOSE.ordinal()]){
                return parentesis[i][P.OPEN.ordinal()];
            }
            i++;
        }
//        System.out.println("CAE EN NULO");
        return null;
    }

    @Override
    public String toString() {
        if(esEquilibrada == null){
            return "es nulo";
//            return super.toString() + "es nulo";
        }
        if(!esEquilibrada){
            return "no es equilibrada.";
        }
        return "es equilibrada.";
    }
    
    
    
}
