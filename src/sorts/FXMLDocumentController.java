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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Arreola
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML TextArea txtDisplay; 
    @FXML Label labelTDato;
    ArrayList<String[]> datos=new ArrayList<String[]>();
    
    @FXML   public void openFile(){
        txtDisplay.setText("");
        filtrarDato();
        Stage stage1 = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Abir archivo");
        String ruta = "C:\\Users\\Arreola\\Google Drive\\Drive\\Politécnica\\C6\\Estructuras de Datos Avanzadas\\Programas\\Sorts";
        fc.setInitialDirectory(new File(ruta));
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT Files","*.txt");
        fc.getExtensionFilters().add(extensionFilter);
        fc.setInitialFileName("");
        File file = fc.showOpenDialog(stage1);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String cadena;
            while ((cadena = br.readLine()) != null) {
                txtDisplay.setText(txtDisplay.getText()+cadena+"\n");
                
                datos.add(cadena.trim().split("\n"));
            }
            for (int i=0; i < datos.size(); i++){
                    //System.out.println(i);
                    System.out.println("Arreglo en la posicion["+i+"]: "+Arrays.toString(datos.get(i)));
            }            

        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
    @FXML public void filtrarDato(){
        labelTDato.setText("Entra");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
