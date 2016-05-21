public class bubbleSort {

    public static void main(String[] args) {

            int []arreglo = {1,43,52,512,56,89,10};
            int aux;
            boolean cambios = false;
            System.out.print("Arreglo desordenado:");
            for (int i=1; i<arreglo.length; i++) {
                System.out.print(arreglo[i]+" ");
            }
            while (true) {
                cambios = false;
                for (int i = 1; i <arreglo.length; i++){
                    if (arreglo[i] < arreglo[i-1]) {
                        aux = arreglo[i];
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
