package sorts;

public class bubbleSort {

    public static void main(String[] args) {

            int []arreglo = {1,43,52,512,56,89,10};
            int aux;
            boolean cambios = false; //bandera para verificar si hubo cambios  en el arreglo
            System.out.print("Arreglo desordenado:");
            for (int i=1; i<arreglo.length; i++) {
                System.out.print(arreglo[i]+" ");
            }
            while (true) { //ciclo infinito para confirmar que se trabaje todo el arreglo
                cambios = false; //se inicializa cambios en falso 
                for (int i = 1; i <arreglo.length; i++){ //for para recorrer todo el arreglo
                    if (arreglo[i] < arreglo[i-1]) { //condicion para saber si un elemento esta mal ordenado
                        // [ 5 , 1 , 7 , 6 , 8 ]
                        // [ 0 , 1 , 2 , 4 , 5 ]
                        aux = arreglo[i];  //aux toma el valor del elemento que se va a intercambiar 
                        arreglo[i] = arreglo[i-1]; 
                        arreglo[i-1] = aux;
                        cambios = true;
                    }
                }
                if (cambios == false) {
                    break;
                }
            }
            System.out.print("\nArreglo ordenado: ");
            for (int i=1; i<arreglo.length; i++) {
                System.out.print(arreglo[i]+" ");
            }
    }
}
