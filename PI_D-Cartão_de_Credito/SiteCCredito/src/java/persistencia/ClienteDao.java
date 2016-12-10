/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes_auxiliares.Cliente;
import conexaoBD.MeuPreparedStatement;
import conexaoBD.MeuResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class ClienteDao {
    
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/conta";
    private static final String USER = "root";
    private static final String PASSWOERD = "4412";

    private MeuPreparedStatement pr;
    private MeuResultSet rs;
    
    public boolean cadastrado (String cpf) throws Exception{
		
	boolean vf = false;
	try {
            
            pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);
			
	    String query = "select * from Cliente where cpf=?";
	    pr.prepareStatement(query);
	    pr.setString(1, cpf);
	    MeuResultSet rs = (MeuResultSet)pr.executeQuery();
	    vf = rs.first();
            
            pr.commit();
            pr.close();
	} catch (SQLException e) {
	    throw new Exception("Erro ao verificar o banco");
	}
		
	return vf;
    }

    public List<Cliente> getClientes() throws ClassNotFoundException, SQLException{

        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);
        
        List<Cliente> clientes = null;
        String queryClientes = null;
        
        queryClientes = "select * from Cliente";

        try {
            
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            clientes = new ArrayList<>();
            Cliente c;
                
            while (rs.next()){
                c = new Cliente();
                    
                c.setIdCliente(rs.getLong("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setNascimento(rs.getString("nascimento"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setSenha(rs.getString("senha"));
                    
                clientes.add(c);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return clientes;
    }
    
    public List<Cliente> consultaCpf (String cpf) throws SQLException, ClassNotFoundException{
        
        List<Cliente> cliente = null;
        Cliente c = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String query = "select * from Cliente where cpf=?";
        try {
            
            pr.prepareStatement(query);
            pr.setString(1,cpf);
            rs = (MeuResultSet) pr.executeQuery();
            
            cliente = new ArrayList<>();
                
            if(rs.next()){
                c = new Cliente();
                    
                c.setIdCliente(rs.getLong("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setNascimento(rs.getString("nascimento"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setSenha(rs.getString("senha"));
                
                cliente.add(c);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
        }
        return cliente;
    }
    
    public Cliente consultaCliente (Long id) throws SQLException, ClassNotFoundException{
        
        Cliente c = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryCliente = "select * from Cliente where idCliente=?";
        try {
            pr.prepareStatement(queryCliente);
            pr.setLong(1,id);
            rs = (MeuResultSet) pr.executeQuery();
            
            if(rs.next()){
                c = new Cliente();
                    
                c.setIdCliente(rs.getLong("idCliente"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                c.setNascimento(rs.getString("nascimento"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setSenha(rs.getString("senha"));
                    
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return c;
    }
    
    public void inserirCliente (Cliente c)throws SQLException, ClassNotFoundException{

       pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);


        try {

            String inseri = "insert into Cliente(nome,cpf,rg,nascimento,endereco,cidade,email,telefone,senha)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            pr.prepareStatement(inseri);

            pr.setString(1,c.getNome());
            pr.setString(2,c.getCpf());
            pr.setString(3,c.getRg());
            pr.setString(4,c.getNascimento());
            pr.setString(5,c.getEndereco());
            pr.setString(6,c.getCidade());
            pr.setString(7,c.getEmail());
            pr.setString(8,c.getTelefone());
            pr.setString(9,c.getSenha());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void excluirCliente (Cliente c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String inseri = "delete from Cliente where idCliente=?";
            pr.prepareStatement(inseri);

            pr.setLong(1,c.getIdCliente());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void editarCliente (Cliente c) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String editar = "update Cliente set nome=?, cpf=?, rg=?, nascimento=?,"
                    + " endereco=?, cidade=?, email=?, telefone=?"
                    + " where idCliente=?";
            pr.prepareStatement(editar);

            pr.setString(1,c.getNome());
            pr.setString(2,c.getCpf());
            pr.setString(3,c.getRg());
            pr.setString(4,c.getNascimento());
            pr.setString(5,c.getEndereco());
            pr.setString(6,c.getCidade());
            pr.setString(7,c.getEmail());
            pr.setString(8,c.getTelefone());
            pr.setString(9,c.getSenha());
            pr.setLong(10,c.getIdCliente());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
}
