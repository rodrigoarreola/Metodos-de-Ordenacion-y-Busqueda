/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Arreola
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML TextArea txtDisplay,txtOrdenado; 
    @FXML Label labelTDato, labelOutput;
    @FXML TextField tfDato;
    @FXML Pane paneBusqueda;
    ArrayList<String> datos = new ArrayList<>();
    ArrayList<Integer> enteros=new ArrayList<Integer>();
    ArrayList<Float> flotantes=new ArrayList<Float>();
    ArrayList<Character> caracteres=new ArrayList<Character>();
    String tipoDato, comparar;
    
    //Variables busqueda binaria
    int numero=0; //numero a buscar
    float numeroF=0;
    char letraC;
    int indiceActual=0; //el indice en donde se encuentre el numero
    int indiceInicial=0; //el indice inicial del arreglo
    int indiceMedio=0; //indica la mitad del arreglo
    int indiceFinal=0; //indica el indice final del arreglo
    int contador=0; //indica la cantidad de veces que se han comparado los numeros del arreglo
    
   
    
    
    @FXML   public void openFile(){
        txtDisplay.setText("");
        Stage stage1 = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Abir archivo");
        //String ruta = "C:\\Users\\Kevin\\Documents\\GitHub\\Metodos-de-Ordenacion-y-Busqueda";
        String ruta = "C:\\Users\\Arreola\\Google Drive\\Drive\\Politécnica\\C6\\Estructuras de Datos Avanzadas\\Programas\\Metodos-de-Ordenacion-y-Busqueda";
        fc.setInitialDirectory(new File(ruta));
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT Files","*.txt");
        fc.getExtensionFilters().add(extensionFilter);
        fc.setInitialFileName("");
        File file = fc.showOpenDialog(stage1);
        int auxiliar=0;
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            auxiliar++;
            String cadena;
            while ((cadena = br.readLine()) != null) {
                txtDisplay.setText(txtDisplay.getText()+cadena+"\n");
                datos.add(cadena.trim());
            }
            for (int i=0; i < datos.size(); i++){
                    //System.out.println(i);
                    System.out.println("Arreglo en la posicion["+i+"]: " + datos.get(i));
            } 
            

        } catch (IOException e) {
                e.printStackTrace();
        }
        filtrarDato();
        
    }
    
    @FXML
    public void clean(){
    txtOrdenado.setText("");
    }
    
    
    @FXML public void filtrarDato(){
        comparar = datos.get(0);
        System.out.println("Tipo de Dato: "+comparar);
        
        if(comparar.equals("i")){
            System.out.println("Entero");
            for(int i=2;i<datos.size();i++){
                //System.out.println(""+datos.get(i));
                enteros.add(Integer.parseInt(datos.get(i)));
            }
            for(int i = 0; i<enteros.size();i++){
                System.out.println("ArrayList en la posicion["+i+"]: "+enteros.get(i));
            }         
        }
        if(comparar.equals("f")){
            System.out.println("Flotante");
            for(int i=2;i<datos.size();i++){
                //System.out.println(""+datos.get(i));
                flotantes.add(Float.parseFloat(datos.get(i)));
            }
            for(int i = 0; i<enteros.size();i++){
                System.out.println("ArrayList en la posicion["+i+"]: "+flotantes.get(i));
            }  
        }
        if(comparar.equals("C")){
            System.out.println("Caracter");
            for(int i=2;i<datos.size();i++){
                String string = datos.get(i);
                caracteres.add(string.charAt(0));
            }
            for(int i = 0; i<enteros.size();i++){
                System.out.println("ArrayList en la posicion["+i+"]: "+flotantes.get(i));
            } 
        }
    }
    
    @FXML public void filtroBubbleSort(){
        if(comparar.equals("i"))
            bubbleSort();
        
        if(comparar.equals("f"))
            buubleSortFloat();
        
        if(comparar.equals("C"))
            bubbleSortChar();   
    }
    
    public void bubbleSortChar(){
        txtOrdenado.setText("");
        char aux;
        boolean cambios = false; //bandera para verificar si hubo cambios  en el arreglo
           
        System.out.println("Tamaño del Array: "+caracteres.size());
        while (true) { //ciclo infinito para confirmar que se trabaje todo el arreglo
            cambios = false; //se inicializa cambios en falso 
            for (int i = 1; i <caracteres.size(); i++){ //for para recorrer todo el arreglo
                if (caracteres.get(i) < caracteres.get(i-1)) { //condicion para saber si un elemento esta mal ordenado
                    aux = caracteres.get(i);  //aux toma el valor del elemento que se va a intercambiar 
                    caracteres.set(i,caracteres.get(i-1));
                    caracteres.set(i-1,aux);
                    cambios = true;
                }
            }
            if (cambios == false) {
                break;
            }
        }
        System.out.print("\nArreglo de caracteres ordenado ");
        for (int i=0; i<caracteres.size(); i++) {
            txtOrdenado.appendText("\n"+caracteres.get(i));
        }
    }
    
    public void buubleSortFloat(){
        txtOrdenado.setText("");
        float aux;
        boolean cambios = false; //bandera para verificar si hubo cambios  en el arreglo
           
        System.out.println("Tamaño del Array: "+flotantes.size());
        while (true) { //ciclo infinito para confirmar que se trabaje todo el arreglo
            cambios = false; //se inicializa cambios en falso 
            for (int i = 1; i <flotantes.size(); i++){ //for para recorrer todo el arreglo
                if (flotantes.get(i) < flotantes.get(i-1)) { //condicion para saber si un elemento esta mal ordenado
                    aux = flotantes.get(i);  //aux toma el valor del elemento que se va a intercambiar 
                    flotantes.set(i,flotantes.get(i-1));
                    flotantes.set(i-1,aux);
                    cambios = true;
                }
            }
            if (cambios == false) {
                break;
            }
        }
        System.out.print("\nArreglo de flotantes ordenado ");
        for (int i=0; i<flotantes.size(); i++) {
            txtOrdenado.appendText("\n"+flotantes.get(i));
        }
    }
    
    public void bubbleSort(){
        txtOrdenado.setText("");
        int aux;
        boolean cambios = false; //bandera para verificar si hubo cambios  en el arreglo
           
        System.out.println("Tamaño del Array: "+enteros.size());
        while (true) { //ciclo infinito para confirmar que se trabaje todo el arreglo
            cambios = false; //se inicializa cambios en falso 
            for (int i = 1; i <enteros.size(); i++){ //for para recorrer todo el arreglo
                if (enteros.get(i) < enteros.get(i-1)) { //condicion para saber si un elemento esta mal ordenado
                    aux = enteros.get(i);  //aux toma el valor del elemento que se va a intercambiar 
                    enteros.set(i,enteros.get(i-1));
                    enteros.set(i-1,aux);
                    cambios = true;
                }
            }
            if (cambios == false) {
                break;
            }
        }
        System.out.print("\nArreglo de enteros ordenado: ");
        for (int i=0; i<enteros.size(); i++) {
            txtOrdenado.appendText("\n"+enteros.get(i));
        }
    }
    
    @FXML   public void startSeleccion(){
        txtOrdenado.setText("");
        seleccion(enteros);
        for (int j=0;j<enteros.size();j++){
            txtOrdenado.appendText("\n"+Integer.toString(enteros.get(j)));
        }
    }
    
    @FXML   static void seleccion(ArrayList<Integer> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(j) < a.get(min)) {
                min = j;
            }
        }
            if (i != min) {
                int aux = a.get(i);
                a.set(i,a.get(min));
                a.set(min,aux);
            }
        }
}
    
    @FXML   public void startQuickSort(){
        txtOrdenado.setText("");
        quicksort(enteros,0,enteros.size()-1);
                for (int j=0;j<enteros.size();j++){
            txtOrdenado.appendText("\n"+Integer.toString(enteros.get(j)));
        }
    }
    
    @FXML   public static void quicksort(ArrayList<Integer> A, int izq, int der) {
        int pivote=A.get(izq); // tomamos primer elemento como pivote
        int i=izq; // i realiza la búsqueda de izquierda a derecha
        int j=der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while(i<j){            // mientras no se crucen las búsquedas
            while(A.get(i)<=pivote && i<j) i++; // busca elemento mayor que pivote
            while(A.get(j)>pivote) j--;         // busca elemento menor que pivote
            if (i<j) {                      // si no se han cruzado                      
               aux= A.get(i);                  // los intercambia
               A.set(i,A.get(j));
               A.set(j,aux);
            }
        }
        A.set(izq,A.get(j));
        // se coloca el pivote en su lugar de forma que tendremos
        A.set(j,pivote);
        // los menores a su izquierda y los mayores a su derecha
        if(izq<j-1)
            quicksort(A,izq,j-1); // ordenamos subarray izquierdo
        if(j+1 <der)
            quicksort(A,j+1,der); // ordenamos subarray derecho
    }
    
    
    @FXML public void filtroInsertionSort(){
        if(comparar.equals("i"))
            insertionSort();
        
        if(comparar.equals("f"))
            insertionSortFloat();
        
        if(comparar.equals("C"))
            bubbleSortChar();   
    }
    
    public void insertionSort(){
        int aux=0;
        for (int contador1 = 1; contador1 < enteros.size(); contador1++){
            aux =enteros.get(contador1);
            for (int contador2 = contador1-1; contador2>=0 && enteros.get(contador2)>aux; contador2--) {
                enteros.set(contador2+1,enteros.get(contador2));
                enteros.set(contador2,aux);
            }
        }
        for (int j=0;j<enteros.size();j++){
            txtOrdenado.appendText("\n"+Integer.toString(enteros.get(j)));
        }
    }
    
    public void insertionSortFloat(){
        float aux=0;
        for (int contador1 = 1; contador1 < enteros.size(); contador1++){
            aux =flotantes.get(contador1);
            for (int contador2 = contador1-1; contador2>=0 && flotantes.get(contador2)>aux; contador2--) {
                flotantes.set(contador2+1,flotantes.get(contador2));
                flotantes.set(contador2,aux);
            }
        }
        for (int j=0;j<flotantes.size();j++){
            txtOrdenado.appendText("\n"+Float.toString(flotantes.get(j)));
        }
    }
    
    public void insertionSortChar(){
        char aux=0;
        for (int contador1 = 1; contador1 < enteros.size(); contador1++){
            aux =caracteres.get(contador1);
            for (int contador2 = contador1-1; contador2>=0 && caracteres.get(contador2)>aux; contador2--) {
                caracteres.set(contador2+1,caracteres.get(contador2));
                caracteres.set(contador2,aux);
            }
        }
        for (int j=0;j<caracteres.size();j++){
            txtOrdenado.appendText("\n"+(caracteres.get(j)));
        }
    }
    
    @FXML    public void startBusqueda(){
        int dato=Integer.parseInt(tfDato.getText());
        busquedaSecuencial(enteros,dato);  
    }
    
    @FXML    public int busquedaSecuencial(ArrayList<Integer> arreglo,int dato){ 
        int posicion = -1;
        for(int i = 0; i < arreglo.size(); i++){
            if(arreglo.get(i) == dato){//comparamos el elemento en el arreglo con el buscado 
                posicion = i;//Si es verdadero guardamos la posicion break;//Para el ciclo } } 
            }
        }
        if(posicion != -1){
            System.out.println("La posicion es"+posicion);
            labelOutput.setText("El numero esta en\n la posicion: " + posicion);
        }else{
            labelOutput.setText("Numero no encontrado");
        }
        return posicion; 
    }
    
    
    @FXML public void filtroBusquedaBinaria(){
        if(comparar.equals("i"))
            numero = Integer.parseInt(tfDato.getText());
        
        if(comparar.equals("f"))
            numeroF = (int)Float.parseFloat(tfDato.getText());
        
        if(comparar.equals("C")){
            String s = tfDato.getText(); 
            letraC = s.charAt(0);
        }
    }
    @FXML public void busquedaBinaria(){
        //numero = Integer.parseInt(tfDato.getText());
        if(comparar.equals("i")){
            numero = Integer.parseInt(tfDato.getText());
            indiceActual = busqueda(numero);
        }
        
        if(comparar.equals("f"))
            numeroF = (int)Float.parseFloat(tfDato.getText());
        
        if(comparar.equals("C")){
            String s = tfDato.getText(); 
            letraC = s.charAt(0);
        }
        
        //indiceActual = busqueda(numero);
        if (indiceActual > -1) {
            System.out.println("El numero esta en el indice: "+indiceActual);
            System.out.println("La posicion del numero es: "+(indiceActual+1));
            labelOutput.setText("El numero esta en el indice: "+indiceActual
                                +"\nNumero de comparaciones: "+contador);
        }else{
            System.out.println("No se encontro la busqueda.");
            labelOutput.setText("No se encontro la busqueda");
        }
        System.out.println("Numero de comparaciones: "+contador);
    }
    
    
    
    public int busqueda(int aux){
            indiceInicial=0;
            indiceFinal = enteros.size()-1;//arreglo.length-1;
            if (aux < enteros.get(indiceInicial) || aux > enteros.get(indiceFinal)) {
                return -1;
            }
            while (indiceInicial <= indiceFinal){
                contador++;
                indiceMedio = (indiceFinal + indiceInicial)/2;
                if (aux == enteros.get(indiceMedio)) {
                    return indiceMedio;
                }else if(aux < enteros.get(indiceMedio)){
                    indiceFinal = indiceMedio-1;
                }else{
                    indiceInicial = indiceMedio+1;
                }
            }
            return -1;
    }
    
    //Comentario de testeo
    public int busquedaF(float aux){
            indiceInicial=0;
            indiceFinal = enteros.size()-1;//arreglo.length-1;
            if (aux < enteros.get(indiceInicial) || aux > enteros.get(indiceFinal)) {
                return -1;
            }
            while (indiceInicial <= indiceFinal){
                contador++;
                indiceMedio = (indiceFinal + indiceInicial)/2;
                if (aux == enteros.get(indiceMedio)) {
                    return indiceMedio;
                }else if(aux < enteros.get(indiceMedio)){
                    indiceFinal = indiceMedio-1;
                }else{
                    indiceInicial = indiceMedio+1;
                }
            }
            return -1;
    }
    
    
    
    @FXML public void insertarDato(){
        paneBusqueda.setVisible(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paneBusqueda.setVisible(false);
    }    
    
}
