package UrnaEletronica;

import java.util.ArrayList;

public class Eleitor 
{
	protected String nome;
	protected String dataDeNascimento;
	protected String titulo;
	protected String zona;
	protected String secao;
	protected String horaAbertura;
	protected int numEleitoresSecao;
	
	public Eleitor (String nome, String dataDeNascimento, String titulo, String zona, String secao) 
	{
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
	}
	
	public Eleitor (String nome, String titulo, String zona, String secao, String horaAbertura, int numEleitoresSecao)
	{
		this.nome = nome;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
		this.horaAbertura = horaAbertura;
		this.numEleitoresSecao = numEleitoresSecao;
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
	
	public static Eleitor pesquisaEleitor (String titulo, ArrayList <Eleitor> eleitores) throws EleitorNaoExistenteException
	{
		int i;
		Eleitor eleitor;
		
		for (i=0; i<eleitores.size(); i++)
			if (titulo==eleitores.get(i).getTitulo())
				{
				eleitor = eleitores.get(i);
				return (eleitor);
				}
		
		if (i==eleitores.size())
			throw new EleitorNaoExistenteException ("Nao existe nenhum eleitor com o titulo pesquisado!!!");
		return null; 
	}
	
	public static void imprimeEleitor (Eleitor eleitor)
	{
		System.out.println("Nome do eleitor: "+eleitor.getNome());
		System.out.println("Data de nascimento: "+eleitor.getDataDeNascimento());
		System.out.println("Titulo do eleitor: "+eleitor.getTitulo());
		System.out.println("Zona do eleitor: "+eleitor.getZona());
		System.out.println("Secao: "+eleitor.getSecao());
		System.out.println("");
	}
}