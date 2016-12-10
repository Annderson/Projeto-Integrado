/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes_auxiliares.Fatura;
import conexaoBD.MeuPreparedStatement;
import conexaoBD.MeuResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class FaturaDao {
    
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/conta";
    private static final String USER = "root";
    private static final String PASSWOERD = "4412";

    private MeuPreparedStatement pr;
    private MeuResultSet rs;

    public List<Fatura> getFaturas(String n) throws ClassNotFoundException, SQLException{

        List<Fatura> faturas = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String query = "select * from Fatura where numero_cartao=?";
        
        try {
            pr.prepareStatement(query);
            pr.setString(1, n);
            rs = (MeuResultSet) pr.executeQuery();
            faturas = new ArrayList<>();
            Fatura f;
                
            while (rs.next()){
                f = new Fatura();
                    
                f.setIdFatura(rs.getLong("idFatura"));
                f.setNumero_cartao(rs.getString("numero_cartao"));
                f.setLocal(rs.getString("local"));
                f.setValor(rs.getDouble("valor"));
                f.setData_acao(rs.getString("data_acao"));
                f.setHorario(rs.getString("horario"));
                    
                faturas.add(f);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return faturas;
    }
    public Fatura consultaFatura (Long id) throws SQLException, ClassNotFoundException{
        
        Fatura fatura = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String query = "select * from Fatura where idFatura=?";
        try {
            pr.prepareStatement(query);
            pr.setLong(1, id);
            rs = (MeuResultSet) pr.executeQuery();
            fatura = new Fatura();
            
            if(rs.next()){
                 
                fatura.setIdFatura(rs.getLong("idFatura"));
                fatura.setNumero_cartao(rs.getString("numero_cartao"));
                fatura.setLocal(rs.getString("local"));
                fatura.setValor(rs.getDouble("valor"));
                fatura.setData_acao(rs.getString("data_acao"));
                fatura.setHorario(rs.getString("horario"));
                    
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return fatura;
    }

    public void inserirCliente (Fatura f)throws SQLException, ClassNotFoundException{

       pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);


        try {  

            String inseri = "insert into Fatura(numero_cartao,local,valor,data_acao,horario)values(?,?,?,?,?)";
            pr.prepareStatement(inseri);

            pr.setString(1, f.getNumero_cartao());
            pr.setString(2, f.getLocal());
            pr.setDouble(3, f.getValor());
            pr.setString(4, f.getData_acao());
            pr.setString(5, f.getHorario());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void excluirCliente (Fatura f) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String delete = "delete from Cartao where idFatura=?";
            pr.prepareStatement(delete);

            pr.setLong(1,f.getIdFatura());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void editarCliente (Fatura f) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String editar = "update Fatura set numero_cartao=?, local=?, valor=?, data_acao=?, horario=?"
                    + " where idFatura=?";
            pr.prepareStatement(editar);

            pr.setString(1, f.getNumero_cartao());
            pr.setString(2, f.getLocal());
            pr.setDouble(3, f.getValor());
            pr.setString(4, f.getData_acao());
            pr.setString(5, f.getHorario());


            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
}
