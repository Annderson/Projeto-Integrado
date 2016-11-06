package org.persistencia;

/**A classe Valores e uma DAO, que faz a conexão direta com o banco de dados, 
 * com comandos de proprios do SQL, para acessar cada valor da cartela em questão.
 * @author Anderson Rodrigues Lima.
 * @since 2016.
 * @version 1.0.
 */

import java.sql.SQLException;

import org.bdo.Valor;
import org.conexao.MeuPreparedStatement;
import org.conexao.MeuResultSet;

public class Valores {
	
	protected MeuPreparedStatement bd;
	protected MeuResultSet rs;
	
	public Valores() throws Exception{
		try{
			String drv = "com.mysql.jdbc.Driver",
				   scon = "jdbc:mysql://localhost/projeto",
				   usr = "root",
				   snh = "4412";
			bd = new MeuPreparedStatement(drv, scon, usr, snh);
			
		}catch (SQLException e){
			throw new Exception("Erro ao conectar ao banco");
		}
	}
	
	private boolean cadastrado (int idCartela) throws Exception{
		boolean vf = false;
		try {
			
			String sql = "Select * from Valores where idCartela=?";
			bd.prepareStatement(sql);
			bd.setInt(1, idCartela);
			rs  = (MeuResultSet)bd.executeQuery();
			
			vf = rs.first();
			
		} catch (SQLException e) {
			throw new Exception("Erro de verificação");
		}
		
		return vf;
	}
	
	public Valor consulta (int linha, int coluna, int idCartela) throws Exception{
		
		if (!(cadastrado(idCartela)))
			throw new Exception("Codigo não está cadastrado no sistema");
		
		Valor vl = null;
		
		try {
			
			String sql = "Select *from Valores where linha=? and coluna=? and idCartela=?";

			bd.prepareStatement(sql);
			bd.setInt(1, linha);
			bd.setInt(2, coluna);
			bd.setInt(3, idCartela);
			MeuResultSet rst = (MeuResultSet)bd.executeQuery();
			
			if (rst.next()){
			    vl = new Valor(rst.getInt("id"), rst.getInt("linha"), rst.getInt("coluna"),
			    		 rst.getInt("valor"), rst.getInt("idCartela"));
			}

			
		} catch (SQLException e) {
			throw new Exception("Erro de leitura do banco");
		}
		return vl;

	}
	
    public void inserir(int id, int linha, int coluna, int valor, int idCartela) throws Exception{
		
		if (cadastrado(id))
			throw new Exception("Numero já cadastrado");
			

		String sql = "Insert into valores(id,linha,coluna,valor,idCartela)Values(?,?,?,?,?)";

		try {

			bd.prepareStatement(sql);
			bd.setInt(1, id);
			bd.setInt(2, linha);
			bd.setInt(3, coluna);
			bd.setInt(4, valor);
			bd.setInt(5, idCartela);
			bd.executeUpdate();
			bd.commit();
			
		} catch (SQLException e) {
			throw new Exception("Erro ao inserir no banco");
		}

	}
    
public void remover(int idCartela)throws Exception{
		
		if (cadastrado(idCartela))
			throw new Exception("Numero já cadastrado");
			

		String sql = "Delete from valores where idCartela=?";

		try {

			bd.prepareStatement(sql);
			bd.setInt(1, idCartela);
			bd.setInt(5, idCartela);
			bd.executeUpdate();
			bd.commit();
			
		} catch (SQLException e) {
			throw new Exception("Erro ao inserir no banco");
		}

	}
}
