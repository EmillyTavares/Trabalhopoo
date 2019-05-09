/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import Dao.AlunoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Aluno;

public class FXMLClienteController implements Initializable {
   
 @FXML
    private TextField textCpf;

    @FXML
    private RadioButton rbF;

    @FXML
    private RadioButton rbM;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textNumero;
    @FXML
    void salvar(ActionEvent event) {
          AlunoDAO dao = new AlunoDAO();
          Aluno a = new Aluno();
        a.setCpf(Integer.parseInt(textCpf.getText()));
         a.setNumero(Integer.parseInt(textNumero.getText()));
          a.setNome(textNome.getText());
          if(rbM.isSelected()){
            a.setSexo("M");
          }else if(rbF.isSelected()){
              a.setSexo("F");
          }
        dao.salvar(a);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
