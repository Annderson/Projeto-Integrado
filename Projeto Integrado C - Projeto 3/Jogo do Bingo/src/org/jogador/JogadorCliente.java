package org.jogador;

/**A classe JogadorCliente faz a fun��o de criar uma conex�o com o servido, 
 *   tem como par�metros o ip e a porta.
 * @author Anderson Rodrigues Lima.
 * @since 2016.
 * @version 1.0.
  */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class JogadorCliente{
	
	protected Socket conexao;
	protected PrintWriter transmissor;
	protected BufferedReader receber;
	
	public JogadorCliente (String ip, int porta) throws Exception{
		
		try {
			
			conexao = new Socket(ip, porta);
			transmissor = new PrintWriter(conexao.getOutputStream());
			receber = new BufferedReader( new InputStreamReader(conexao.getInputStream()));
			
		} catch (Exception e) {
			throw new Exception("Erro de conex�o");
		}
		
	}
	
	public void envie (String mensagem) throws Exception{
		
		try {
			this.transmissor.println(mensagem);
			this.transmissor.flush();		
		} catch (Exception e) {
			throw new Exception("Erro de transmiss�o");
		}
		
	}
	
	public boolean pedido() throws Exception{
		
		if (this.receber.ready())
			return true;
		
		return false;
	}
	
	public String receber() throws Exception{
		String ret = null;
		
		try {
			ret = this.receber.readLine();
		} catch (Exception e) {
		    throw new Exception("Erro de recebimento");
		}
		return ret;	
	}
	
	public boolean equals (Object obj){
		
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		
		JogadorCliente jog = (JogadorCliente)obj;
		
		if (this.conexao.equals(jog.conexao))
			return false;
		if (this.receber.equals(jog.receber))
			return false;
		if (this.transmissor.equals(jog.transmissor))
			return false;
		
		return true;
	}
	
	public String toString (){
		String ret = "{";
		
		ret += this.conexao + "\n";
		ret += this.receber + "\n";
		ret += this.transmissor + "\n";
		ret += "}";
		
		return ret;
	}
	
	public int hashCode (){
		int hash = super.hashCode();
		
		hash = hash*3 + this.conexao.hashCode();
		hash = hash*3 + this.receber.hashCode();
		hash = hash*3 + this.transmissor.hashCode();
		
		return hash;
	}
	
	public JogadorCliente (JogadorCliente modelo) throws Exception{
		if (modelo == null)
			throw new Exception("Modelo n�o fornecido");
		
		this.conexao = modelo.conexao;
		this.receber = modelo.receber;
		this.transmissor = modelo.transmissor;
		
	}
	
	public Object clone(){
		JogadorCliente clo = null;
		
		try {
			clo = new JogadorCliente(this);
		} catch (Exception e) {	}
		
		return clo;
	}
	
}
