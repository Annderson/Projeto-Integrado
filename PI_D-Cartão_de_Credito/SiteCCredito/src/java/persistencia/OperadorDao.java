/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes_auxiliares.Operador;
import conexaoBD.MeuPreparedStatement;
import conexaoBD.MeuResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anderson
 */
public class OperadorDao {
    
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/conta";
    private static final String USER = "root";
    private static final String PASSWOERD = "4412";

    private MeuPreparedStatement pr;
    private MeuResultSet rs;
    
    public boolean cadastrado (Long ro, String senha) throws Exception{
		
		boolean vf = false;
                pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);
		try {
			
			String sql = "select * from Operador where ro=? and senha=?";
			pr.prepareStatement(sql);
			pr.setLong(1, ro);
                        pr.setString(2, senha);
		        rs = (MeuResultSet)pr.executeQuery();
			vf = rs.first();
			
		} catch (SQLException e) {
			throw new Exception("Erro ao verificar o banco");
		}
		
		return vf;
    }

    public List<Operador> getOperadores() throws ClassNotFoundException, SQLException{

        List<Operador> operadores = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryClientes = "select * from Operador";
        try {
            
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            operadores = new ArrayList<>();
            Operador p;
                
            while (rs.next()){
                p = new Operador();
                    
                p.setRo(rs.getLong("ro"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
                p.setEndereco(rs.getString("endereco"));
                p.setCidade(rs.getString("cidade"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                p.setSenha(rs.getString("senha"));
                    
                operadores.add(p);
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return operadores;
    }
    public Operador consultaCliente (int id) throws SQLException, ClassNotFoundException{
        
        Operador cliente = null;
        pr = new MeuPreparedStatement(DRV, DB_URL, USER, PASSWOERD);

        String queryClientes = "select * from Operador where ro=?";
        try {
            
            pr.setLong(1, id);
            rs = (MeuResultSet) pr.executeQuery(queryClientes);
            Operador p;
                
            if(rs.next()){
                p = new Operador();
                    
                p.setRo(rs.getLong("ro"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setRg(rs.getString("rg"));
                p.setNascimento(rs.getString("nascimento"));
                p.setEndereco(rs.getString("endereco"));
                p.setCidade(rs.getString("cidade"));
                p.setEmail(rs.getString("email"));
                p.setTelefone(rs.getString("telefone"));
                    
            }

            pr.commit();
            pr.close();
        } catch (SQLException e) {
            pr.close();
            e.printStackTrace();
        }
        return cliente;
    }

    public void inserirCliente (Operador p)throws SQLException, ClassNotFoundException{

       pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);


        try {

            String inseri = "insert into Operador(ro,nome,cpf,rg,nascimento,endereco,cidade,email,telefone,senha)"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            pr.prepareStatement(inseri);

            pr.setLong(1,p.getRo());
            pr.setString(2,p.getNome());
            pr.setString(3,p.getCpf());
            pr.setString(4,p.getRg());
            pr.setString(5, p.getNascimento());
            pr.setString(6,p.getEndereco());
            pr.setString(7,p.getCidade());
            pr.setString(8,p.getEmail());
            pr.setString(9,p.getTelefone());
            pr.setString(10,p.getSenha());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void excluirCliente (Operador p) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String inseri = "delete from Operador where ro=?";
            pr.prepareStatement(inseri);

            pr.setLong(1,p.getRo());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
    public void editarCliente (Operador p) throws SQLException, ClassNotFoundException{

        pr = new MeuPreparedStatement(DRV,DB_URL,USER,PASSWOERD);

        try {
            
            String inseri = "update Cliente set nome=?, cpf=?, rg=?, nascimento=?,"
                    + " endereco=?, cidade=?, email=?, telefone=?"
                    + " where ro=?";
            pr.prepareStatement(inseri);
     
            pr.setString(1,p.getNome());
            pr.setString(2,p.getCpf());
            pr.setString(3,p.getRg());
            pr.setString(4, p.getNascimento());
            pr.setString(5,p.getEndereco());
            pr.setString(6,p.getCidade());
            pr.setString(7,p.getEmail());
            pr.setString(8,p.getTelefone());
            pr.setLong(9,p.getRo());

            pr.executeUpdate();
            pr.commit();
            pr.close();

        }catch (SQLException e){
            pr.close();
            e.printStackTrace();
        }

    }
    
}
