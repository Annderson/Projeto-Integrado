package org.bdo;

/**A classe Valor é uma DBO, funciona como o espelho da tabela Valor do banco de dados, 
 * obtem as informações da cartela, faz todas as verificações da cartela tais como, obter as informações, 
 * alterar, excluir e inserir dados, serão usadas em classes DAOs.
 * @author Anderson Rodrigues Lima.
 * @since 2016.
 * @version 1.0.
 */

public class Valor {
	
	protected int id;
	protected int linha;
	protected int coluna;
	protected int idCartela;
	protected int valor;
	
	public int getId() {
		return id;
	}
	public int getLinha() {
		return linha;
	}
	public int getColuna() {
		return coluna;
	}
	public int getValor() {
		return valor;
	}	
	public int getIdCartela() {
		return idCartela;
	}
	
	public void setId(int id) throws Exception {
		if (id < 1)
			throw new Exception("Id invalido");
			
		this.id = id;
	}
	public void setLinha(int linha) throws Exception {
		if ((linha < 0) || (linha > 4))
			throw new Exception("Linha invalido");
		
		this.linha = linha;
	}
	public void setColuna(int coluna) throws Exception {
		if ((coluna < 0) || (coluna > 4))
			throw new Exception("Coluna invalido");
		
		this.coluna = coluna;
	}
	public void setIdCartela(int idCartela) throws Exception {
		if (idCartela < 1)
			throw new Exception("Cartela invalido");
		
		this.idCartela = idCartela;
	}
	public void setValor(int valor) throws Exception {
		if ((valor < 1) || (valor > 75))
			throw new Exception("Valor invalido");
		
		this.valor = valor;
	}
	
	public Valor (int id, int l, int c, int v, int idC) throws Exception{
		setId(id);
		setLinha(l);
		setColuna(c);
		setValor(v);
		setIdCartela(idC);
	}
	
	public boolean equals (Object obj){
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Valor))
			return false;
		
		Valor vl = (Valor)obj;
		
		if (this.id != vl.id)
			return false;
		if (this.linha != vl.linha)
			return false;
		if (this.coluna != vl.coluna)
			return false;
		if (this.valor != vl.valor)
			return false;
		if (this.idCartela != vl.idCartela)
			return false;
		
		return false;
	}
	
	public String toString (){
		String ret = "{";
		
		ret += "Id: " + this.id + "\n";
		ret += "Linha: " + this.linha + "\n";
		ret += "Coluna: " + this.coluna + "\n";
		ret += "Valor: " + this.valor + "\n";
		ret += "IdCartela: " + this.idCartela + "}";
		
		return ret;
	}
	
	public int hashCode(){
		final int PRIMO = 3;
		int hash = super.hashCode();
		
		hash = hash*PRIMO + new Integer(this.id).hashCode();
		hash = hash*PRIMO + new Integer(this.linha).hashCode();
		hash = hash*PRIMO + new Integer(this.coluna).hashCode();
		hash = hash*PRIMO + new Integer(this.valor).hashCode();
		hash = hash*PRIMO + new Integer(this.idCartela).hashCode();
		
		return hash;
		
	}
	
	public Valor (Valor modelo)throws Exception{
		if (modelo == null)
			throw new Exception("Modelo nulo, não foi fornecido");
		
		this.id = modelo.id;
		this.linha = modelo.linha;
		this.coluna = modelo.coluna;
		this.valor = modelo.valor;
		this.idCartela = modelo.idCartela;
		
	}
	
	public Object clone(){
		Valor vl = null;
		
		try {
			vl = new Valor(this);
		} catch (Exception e) {}
		
		return vl;
	}
	
}
