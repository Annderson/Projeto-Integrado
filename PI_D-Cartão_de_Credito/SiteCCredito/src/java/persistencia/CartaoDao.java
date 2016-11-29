/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes_auxiliares.CCorrente;
import classes_auxiliares.Cartao;
import conexaoBD.MeuPreparedStatement;
import conexaoBD.MeuResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class CartaoDao {
    
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/conta";
    private static final String USER = "root";
    private static final String PASSWOERD = "4412";

    private MeuPreparedStatement pr;
    private MeuResultSet rs;

    public List<Cartao> getCartoes() throws ClassNotFoundException, SQLException{

        List<Cartao> contas = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryClientes = "select * from Cartao";
        
        try {
            
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            contas = new ArrayList<>();
            Cartao c;
                
            while (rs.next()){
                c = new Cartao();
                    
                c.setIdCartao(rs.getLong("idCartao"));
                c.setNumero_cartao(rs.getString("numero_cartao"));
                c.setNumero_conta(rs.getString("numero_conta"));
                c.setAnuidade(rs.getDouble("anuidade"));
                c.setEstado(rs.getString("estado"));
                    
                contas.add(c);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return contas;
    }
    public List<String> cartoes (String id) throws SQLException, ClassNotFoundException{
        
        List<String> cartao = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String sql = "select numero_cartao from Cartao where numero_conta=?";
        try {
            pr.prepareStatement(sql);
            pr.setString(1, id);
            rs = (MeuResultSet) pr.executeQuery();
            
            Cartao ct;
            String st;
            while(rs.next()){
                ct = new Cartao();
                
                ct.setNumero_cartao(rs.getString("numero_cartao"));
                if ("a".equals(rs.getString("estado")))
                    ct.setEstado("ativo");
                else
                    ct.setEstado("bloqueado");

                cartao.add("numero_cartao");
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return cartao;
    }

    public void inserirCliente (Cartao c)throws SQLException, ClassNotFoundException{

       pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);


        try {

            String inseri = "insert into Cartao(numero_cartao,numero_conta,anuidade,estado)values(?,?,?,?)";
            pr.prepareStatement(inseri);

            pr.setString(1, c.getNumero_cartao());
            pr.setString(2, c.getNumero_conta());
            pr.setDouble(3, c.getAnuidade());
            pr.setString(4, c.getEstado());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void excluirCliente (Cartao c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String delete = "delete from Cartao where idCartao=?";
            pr.prepareStatement(delete);

            pr.setLong(1,c.getIdCartao());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void editarCliente (Cartao c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String editar = "update Cartao set numero_cartao=?, numero_conta=?, anuidade=?, estado=?"
                    + " where idCartao=?";
            pr.prepareStatement(editar);

            pr.setString(1, c.getNumero_cartao());
            pr.setString(2, c.getNumero_conta());
            pr.setDouble(3, c.getAnuidade());
            pr.setString(4, c.getEstado());
            pr.setLong(5, c.getIdCartao());


            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
}
