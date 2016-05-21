package sorts;
public class insertionSort{
    public static void main(String[] args) {
        int aux;
        int contador1;
        int contador2;
        int []arreglo = {77,41,432,12,8,4,55,87,16,1};

        System.out.print("Arreglo desordenado:");
        for (int i=1; i<arreglo.length; i++) {
            System.out.print(arreglo[i]+" ");
        }

        for (contador1 = 1; contador1 < arreglo.length; contador1++){
            aux = arreglo[contador1];
            for (contador2 = contador1-1; contador2>=0 && arreglo[contador2]>aux; contador2--) {
                arreglo[contador2+1] = arreglo[contador2];
                arreglo[contador2] = aux;
            }
        }

        System.out.print("Arreglo ordenado:");
        for (int i=1; i<arreglo.length; i++) {
            System.out.print(arreglo[i]+" ");
        }
    }
}
