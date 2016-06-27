package org.jogador;

/**A classe Jogador faz as ligações necessárias para conexão do servidor com os usuarios.
 * Recebendo e mandando informaçoes para os usuarios.
*  @author Anderson Rodrigues Lima.
 * @since 2016.
 * @version 1.0.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Jogador {
	
	protected BufferedReader receptor;
	protected PrintWriter transmissor;
	protected Socket conexao;
	
	public Jogador (Socket conexao) throws Exception{
		
		try {
			
		    this.conexao = conexao;
			
			this.receptor = new BufferedReader
					        (new InputStreamReader(conexao.getInputStream()));
			
			this.transmissor = new PrintWriter(conexao.getOutputStream());
			
		} catch (Exception e) {
			throw new Exception("Erro de conexão");
		}
	}
	
	public void envie(String s) throws Exception{
		
		try {
			this.transmissor.println(s);
			this.transmissor.flush();
		}
		catch (Exception erro){
			throw new Exception("Erro de transmissão");
		}	
	}
	
	public boolean pedido() throws Exception{
		
		if (this.receptor.ready())
			return true;
		
		return false;
	}
	
	public String receba() throws Exception{
		
		String ret = null;
		
		try {
			ret = this.receptor.readLine();
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
		if (!(obj instanceof Jogador))
			return false;
		
		Jogador jog = (Jogador)obj;
		
		if (!(this.receptor.equals(jog.receptor)))
			return false;
		if (!(this.transmissor.equals(jog.transmissor)))
			return false;
		return true;
	}
	
	public String toString (){
		String ret = "(";
		
		ret += this.receptor +", ";
		ret += this.transmissor;
		ret += ")";
		
		return ret;
	}
	
	public int hashCode(){
		int hash = super.hashCode();
		
		hash = hash*3 + this.receptor.hashCode();
		hash = hash*3 + this.transmissor.hashCode();
		
		return hash;
	}
	
	public Jogador (Jogador modelo) throws Exception{
		
		if (modelo == null)
			throw new Exception("Objeto não foi fornecido");
		
		this.receptor = modelo.receptor;
		this.transmissor = modelo.transmissor;
	}
	
	public Object clone (){
		
		Jogador jog = null;
		try {
			
			jog = new Jogador(this);
			
		} catch (Exception e) {}
		
		return jog;
	}
	
}
