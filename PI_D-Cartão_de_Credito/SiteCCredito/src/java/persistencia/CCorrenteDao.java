/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes_auxiliares.CCorrente;
import classes_auxiliares.Fatura;
import conexaoBD.MeuPreparedStatement;
import conexaoBD.MeuResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class CCorrenteDao {
    
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/conta";
    private static final String USER = "root";
    private static final String PASSWOERD = "4412";

    private MeuPreparedStatement pr;
    private MeuResultSet rs;

    public List<CCorrente> getContas() throws ClassNotFoundException, SQLException{

        List<CCorrente> contas = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryClientes = "select * from CCorrente";
        try {
            
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            contas = new ArrayList<>();
            CCorrente c;
                
            while (rs.next()){
                c = new CCorrente();
                    
                c.setIdConta(rs.getLong("idConta"));
                c.setNumero_conta(rs.getString("numero_conta"));
                c.setCpfCliente(rs.getString("cpfCliente"));
                c.setCodigo(rs.getString("codigo"));
                c.setTotal(rs.getDouble("total"));
                    
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
    public CCorrente consultaConta (int id) throws SQLException, ClassNotFoundException{
        
        CCorrente conta = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryClientes = "select * from CCorrente where idConta=?";
        try {
            
            pr.setLong(1, id);
            
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            conta = new CCorrente();
            
            if(rs.next()){
                 
                conta.setIdConta(rs.getLong("idConta"));
                conta.setNumero_conta(rs.getString("numero_conta"));
                conta.setCpfCliente(rs.getString("cpfCliente"));
                conta.setCodigo(rs.getString("codigo"));
                conta.setTotal(rs.getDouble("total"));
                    
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return conta;
    }
    
    public List<String> contas (String n) throws SQLException, ClassNotFoundException{
        
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String ft = "select numero_conta from CCorrente where cpfCliente=?";
        
        List<String> faturas = new ArrayList<>();

        try {
            pr.prepareStatement(ft);
            pr.setString(1,n);
            rs = (MeuResultSet) pr.executeQuery();
            
            Fatura fatura = null;
            fatura = new Fatura();
            
            while(rs.next()){
                String numero;
                
                numero = rs.getString("numero_conta");
                
                faturas.add(numero);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return faturas;
    }

    public void inserirConta (CCorrente c)throws SQLException, ClassNotFoundException{

       pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);


        try {

            String inseri = "insert into CCorrente(numero_conta,cpfCliente,codigo,total)values(?,?,?,?)";
            pr.prepareStatement(inseri);

            pr.setString(1, c.getNumero_conta());
            pr.setString(2, c.getCpfCliente());
            pr.setString(3, c.getCodigo());
            pr.setDouble(4, c.getTotal());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void excluirCliente (CCorrente c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String delete = "delete from CCorrente where idConta=?";
            pr.prepareStatement(delete);

            pr.setLong(1,c.getIdConta());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void editarCliente (CCorrente c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String inseri = "update CCorrente set numero_conta=?, cpfCliente=?, codigo=?, total=?"
                    + " where idConta=?";
            pr.prepareStatement(inseri);

            pr.setString(1, c.getNumero_conta());
            pr.setString(2, c.getCpfCliente());
            pr.setString(3, c.getCodigo());
            pr.setDouble(4, c.getTotal());
            pr.setLong(5, c.getIdConta());


            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
}
