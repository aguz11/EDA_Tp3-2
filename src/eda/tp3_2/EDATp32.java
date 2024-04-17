package eda.tp3_2;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class EDATp32 {

    public static void main(String[] args) {
        /*******************************************************/
        // PilaNumeros re imaginada
        /******************************************************/
        
        PilaNumeros numbers = new PilaNumeros(10);
        
        for(int i=0; i<numbers.size(); i++){
            numbers.pila.push(i);
        }
        System.out.println(numbers.pila);
        
        numbers.pila.push(1);
        
        for(int i=0; i<numbers.size(); i++){
            numbers.pila.pop();
        }
        
        System.out.println("Se vacieron los numeros...");
        System.out.println("");
        numbers.pila.pop();
        
        /*******************************************************/
        // PilaCaracteres re imaginada
        /******************************************************/
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("Seccion de letras");
        System.out.println("---------------------------------\n");
        Pila<Character> pilaCaracteres = new Pila<>(5);
        pilaCaracteres.push('a');
        pilaCaracteres.push('i');
        pilaCaracteres.push('w');
        pilaCaracteres.push(')');
        pilaCaracteres.push(':');
        
        System.out.println(pilaCaracteres);
        System.out.println("");
        
        System.out.print(pilaCaracteres.pop());
        System.out.println(pilaCaracteres.pop());
        
        System.out.println(pilaCaracteres.verElemento());
        System.out.println(pilaCaracteres.verElemento());
        
        System.out.print(pilaCaracteres.pop());
        System.out.println(pilaCaracteres.pop());
        
        System.out.println(pilaCaracteres.pop());
        System.out.println(pilaCaracteres.pop());
            
            
        
        
    }//FIN de main()

}//FIN de class EDATp32
