package org.persistencia;

/**Esta classe Cartelas � DAO  da cartela do jogador, s�o feitas verifica��es diretamente no banco de dados, 
 * fazendo conex�o direta com o banco de dados, usando comandos de SQL, em quest�o
 * tais como se a cartela est� cadastrada ou n�o dando suas respectivas exce��es, envia os n�meros sorteados para as cartelas, dando exce��o caso nao conseguir
 * e tamb�m a poss�vel remo��o da cartela, dando exce��o se nao existir.
 * @author Anderson Rodrigues Lima.
 * @since 2016.
 * @version 1.0.
 */

import java.sql.*;

import org.bdo.Cartela;
import org.conexao.*;

public class Cartelas {
	
	protected MeuPreparedStatement bd;
	protected ResultSet rs = null;

	public Cartelas() throws ClassNotFoundException, SQLException{
		
		String drv = "com.mysql.jdbc.Driver",
			   scon = "jdbc:mysql://localhost/projeto",
			   usr = "root",
			   snh = "4412";
		bd = new MeuPreparedStatement(drv, scon, usr, snh);
	}

	public boolean cadastrado (int id) throws Exception{
		
		boolean vf = false;
		try {
			
			String sql = "Select * from Cartela where numero=?";
			bd.prepareStatement(sql);
			bd.setInt(1, id);
			MeuResultSet rs = (MeuResultSet)bd.executeQuery();
			vf = rs.first();
			
		} catch (SQLException e) {
			throw new Exception("Erro ao verificar o banco");
		}
		
		return vf;
	}
	
	public Cartela consulta(int numero) throws Exception{
		
		if (!(cadastrado(numero)))
			throw new Exception("Codigo n�o est� cadastrado");

		Cartela car = null;

		try {
			String sql = "Select * from cartela where numero=?";
			bd.prepareStatement(sql);
			bd.setInt(1, numero);

			MeuResultSet rs =(MeuResultSet)bd.executeQuery();
			if (rs.next())
			    car = new Cartela(rs.getInt("numero"),rs.getString("estado"));
		} catch (SQLException e) {
			throw new Exception("Erro ao consultar o banco");
		}
		
		return car;
	}
	
	public void inserir(int numero, String estado) throws Exception{
		
		if (cadastrado(numero))
			throw new Exception("Numero j� cadastrado");
			

		String sql = "Insert into cartela(numero,estado)Values(?,?)";

		try {

			bd.prepareStatement(sql);
			bd.setInt(1, numero);
			bd.setString(2, estado);
			bd.executeUpdate();
			bd.commit();
			
		} catch (SQLException e) {
			throw new Exception("Erro ao inserir no banco");
		}

	}
	
	public void remover (int numero)throws Exception{
		
		if (!(cadastrado(numero)))
			throw new Exception("Codigo n�o cadastrado");
		
		try {
			String sql = "Delete from Cartela where numero=?";
			bd.prepareStatement(sql);
			bd.setInt(1, numero);
			bd.executeUpdate();
			bd.commit();
		}catch (SQLException e){
			throw new Exception("Erro ao excluir");
		}
	}

}
