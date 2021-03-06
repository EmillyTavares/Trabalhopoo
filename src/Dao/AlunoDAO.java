
package Dao;

import com.sun.webkit.ContextMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
public class AlunoDAO {
    Connection con = null;
   
    public AlunoDAO(){
        con = Conexao.abrirConexao();
     JOptionPane.showMessageDialog(null, "Conectado com sucesso");
    }    
    public void salvar(Aluno aluno){
        try {
            String sql = "INSERT INTO CADASTRO(NUMERO, NOME, SEXO,CPF) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, aluno.getNumero());
       ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getSexo());
             ps.setInt(4, aluno.getCpf());
            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "'" + aluno.getNome() + "Cadastrado com sucesso ");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            }
           
        } catch (Exception e) {
        }
    }
    
    public void pesquisarAll(){        
        try {
            String sql = "SELECT * FROM Cadastro";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                List<Aluno> lista = new ArrayList<>();
                Aluno aluno = new Aluno();
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setCpf(rs.getInt("cpf"));
                lista.add(aluno);              
               
                for(Aluno l : lista){
                    System.out.println("Numero:" + l.getNumero() + "\n" + "Nome:" + l.getNome()  + "\n" + "Sexo:" + l.getSexo() + "Cpf"+l.getCpf());
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("deu erro");
        }   
    }
    
    public void pesquisar(int numero){  
        Aluno aluno = new Aluno();
        try {           
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT * FROM ALUNO WHERE NUMERO = ?");
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){                
                
                aluno.setNumero(rs.getInt("numero"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("SEXO"));
                aluno.setCpf(rs.getInt("cpf"));
                System.out.println("Número: " + aluno.getNumero());
                System.out.println("Nome:  " + aluno.getNome());
                System.out.println("Sexo: " + aluno.getSexo());
                System.out.println("Cpf: " + aluno.getCpf());
                               
             }   
            
        } catch (Exception e) {
        }
        
        
    }

   // public void delete(int numero){
       // try {
         //   String sql = "DELETE FROM ALUNO WHERE NUMERO = ?";
           // PreparedStatement ps = con.prepareStatement(sql);
            //ps.setInt(1, numero);
            //if(ps.executeUpdate() != 0){
               // System.out.println("Dados foram deletados com sucesso");
            //}
       // }// catch (Exception e) {
       // }
   // }  
    
    
    //public void atualizar(int numero){
       // try {
            //String sql = "UPDATE ALUNO SET NOME = ?, SEXO = ? WHERE NUMERO = ?";
           // PreparedStatement ps = con.prepareStatement(sql);
           // ps.setString(1, "JOÃO");
            //ps.setString(2, "F");
           // ps.setInt(3, numero);
            //if(ps.executeUpdate() !=0){
             //   System.out.println("Dados alterados com sucesso");
            }
        //} catch (Exception e) {
      //  }//
    //}
//}
