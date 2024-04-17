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
    private Character[] parenArray;
    private static char[][] parentesis = {{'(',')'},{'{','}'},{'[',']'},{'<','>'}};
    private enum P{
        OPEN,
        CLOSE
    }

    public PilaParentesis(int length) {
        super(length);
    }

    public PilaParentesis(int length, String cadena) {
        super(getParentesis(cadena));
        this.parenArray = getParentesis(cadena);
        
        if(cadena == null || "".equals(cadena) || this.length < 1){
            esEquilibrada = null;
        }
        for(int i=0; i<super.length; i++){
            Character car = (Character)pila[i];
            if(esParenApertura(car)){
                push(car);
            }
            if(esParenCierre(car)){
                if(pilaVacia()){
                    esEquilibrada = false;
                    return;
                }
                if(!Objects.equals(car, getParenCierre((char)pop()))){
                    esEquilibrada = false;
                    return;
                }
            }
        }
        if(pilaVacia()){
            esEquilibrada = true;
        }
    }
    
    public static Character[] getParentesis(String cadena){
        if(cadena == null || cadena.equals("")){
            return null;
        }
        int i = 0;
        String strParen = "";
        for(char car: cadena.toCharArray()){
            if(car == parentesis[P.OPEN.ordinal()][i]){
                strParen += car;
            }
            if(car == parentesis[P.CLOSE.ordinal()][i]){
                strParen += car;
            }
            i++;
        }
        char[] charParen = strParen.toCharArray();
        Character[] carEnvolturaParen = new Character[charParen.length];
        i=0;
        for(char car:charParen){
            carEnvolturaParen[i] = car;
            i++;
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
                return parentesis[P.CLOSE.ordinal()][i];
            }
            i++;
        }
        return null;
    }
    
//    public static Character getParenApertura(Character parenCierre){
//        int i = 0;
//        for(char[] paren: parentesis){
//            if(parenCierre == paren[P.CLOSE.ordinal()]){
//                return parentesis[P.OPEN.ordinal()][i];
//            }
//            i++;
//        }
//        return null;
//    }
    
    
    

    
//    public int contarParenApertura(String cadena){
//        int cantidadParen=0;
//        char[] charCadena = cadena.toCharArray();
//        for(char car:charCadena){
//            if(esParenApertura(car)){
//                cantidadParen++;
//            }
//        }
//        return cantidadParen;
//    }
//    
//    public int contarParenCierre(String cadena){
//        int cantidadParen=0;
//        char[] charCadena = cadena.toCharArray();
//        for(char car:charCadena){
//            if(esParenCierre(car)){
//                cantidadParen++;
//            }
//        }
//        return cantidadParen;
//    }
    
}
