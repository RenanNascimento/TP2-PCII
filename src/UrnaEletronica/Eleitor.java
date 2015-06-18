package UrnaEletronica;

import java.util.ArrayList;

public class Eleitor 
{
	protected String nome;
	protected String dataDeNascimento;
	protected String titulo;
	protected String zona;
	protected String secao;
	
	public Eleitor (String nome, String dataDeNascimento, String titulo, String zona, String secao) 
	{
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}
	
	public static boolean verificaTituloEleitor (String titulo, ArrayList <Eleitor> eleitores) throws TituloInvalidoException
	{
		int i;
		
		for (i=0; i<eleitores.size(); i++)
			if (titulo==eleitores.get(i).getTitulo())
				throw new TituloInvalidoException ("Ja existe uma passoa com esse titulo cadastrado!!!");
		return true;
		
	}
}