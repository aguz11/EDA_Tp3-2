package eda.tp3_2;

/**
 *
 * @author Adam, Martin, Agustin
 */
public class EDATp32 {

    public static void main(String[] args) {
        /*******************************************************/
        // Unidos no mezclados
        /******************************************************/
        int[]datosPila1 = {11, 22, 34, 55};
        int[]datosPila2 = {0, 8, 14, 22, 30, 65};
        
        Pila<Integer> pila1 = new Pila<>(datosPila1.length);
        Pila<Integer> pila2 = new Pila<>(datosPila2.length);
        
        for(int num:datosPila1){
            pila1.push((Integer)num);
        }
        
        for(int num:datosPila2){
            pila2.push((Integer)num);
        }
        
        System.out.println("--------------------");
        System.out.println("Datos Pila1");
        System.out.println("--------------------");
        System.out.println(pila1);
        
        System.out.println("--------------------");
        System.out.println("Datos Pila2");
        System.out.println("--------------------");

        System.out.println(pila2);
        
        
        
        Pila<Integer> pilaUnida = UnirPilasOrdenadas.combinarPilas(pila1, pila2);
        
        System.out.println("--------------------");
        System.out.println("Datos pilas unidas");
        System.out.println("--------------------");
        
        System.out.println(pilaUnida);
    
        // No deberiamos ver datos con los print a continuacion
        System.out.print(pila1);
        System.out.print(pila2);
        System.out.println("");
     
        /*******************************************************/
        // PilaParentesis
        /******************************************************/
        String ejemploEquilibrado0 = "{[(a+b)*c]-(d+e)}";
        String ejemploEquilibrado1 = "{[(a+b)*c]-(d+e)";
        String ejemploEquilibrado2 = "[{()}]";
        String ejemploNoEquilibrado = "[(])";
        
        System.out.println("---------------------------------");
        System.out.println("Seccion de parentesis");
        System.out.println("---------------------------------\n");
        
        System.out.println("\"ejemploEquilibrado0\"\t" +
                "\"" + ejemploEquilibrado0 + "\"\t" +
                new PilaParentesis(ejemploEquilibrado0));
        
        System.out.println("");
        
        System.out.println("\"ejemploEquilibrado1\"\t" +
                "\"" + ejemploEquilibrado1 + "\"\t" +
                new PilaParentesis(ejemploEquilibrado1));
        
        System.out.println("");
        
        System.out.println("\"ejemploEquilibrado2\"\t\t" +
                "\"" + ejemploEquilibrado2 + "\"\t" +
                new PilaParentesis(ejemploEquilibrado2));
        
        System.out.println("");
        
        System.out.println("\"ejemploNoEquilibrado\"\t\t" +
                "\"" + ejemploNoEquilibrado + "\"\t\t" +
                new PilaParentesis(ejemploNoEquilibrado));
        
        
        
    }//FIN de main()

}//FIN de class EDATp32
