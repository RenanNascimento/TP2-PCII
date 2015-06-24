package UrnaEletronica;

import java.util.ArrayList;

public class Eleitor 
{
	protected String nome;
	protected String dataDeNascimento;
	protected String titulo;
	protected String zona;
	protected String secao;
	protected String horaAbertura, horaEncerramento;
	protected int numEleitoresSecao;
	protected boolean secaoEncerrada;
	protected boolean votouPrefeito;
	protected boolean votouVereador;
	
	public Eleitor (String nome, String dataDeNascimento, String titulo, String zona, String secao) 
	{
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
		this.votouPrefeito = false;
		this.votouVereador = false;
	}
	
	public Eleitor (String nome, String titulo, String zona, String secao, String horaAbertura, int numEleitoresSecao)
	{
		this.nome = nome;
		this.titulo = titulo;
		this.zona = zona;
		this.secao = secao;
		this.horaAbertura = horaAbertura;
		this.horaEncerramento = "";
		this.numEleitoresSecao = numEleitoresSecao;
		this.secaoEncerrada = false;
		this.votouPrefeito = false;
		this.votouVereador = false;
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
	
	public boolean getSecaoEncerrada ()
	{
		return this.secaoEncerrada;
	}
	
	public void setSecaoEncerrada (boolean secaoEncerrada)
	{
		this.secaoEncerrada = secaoEncerrada;
	}
	
	public void setHoraEncerramento(String horaEncerramento){
		this.horaEncerramento = horaEncerramento;
	}
	
	public String getHoraEncerramento(){
		return horaEncerramento;
	}
	
	public boolean getVotouPrefeito ()
	{
		return this.votouPrefeito;
	}
	
	public void setVotouPrefeito (boolean votouPrefeito)
	{
		this.votouPrefeito = votouPrefeito;
	}
	
	public boolean getVotouVeredor ()
	{
		return this.votouVereador;
	}
	
	public void setVotouVereador (boolean votouVereador)
	{
		this.votouVereador = votouVereador;
	}
	
	public static boolean verificaTituloEleitor (String titulo, ArrayList <Eleitor> eleitores) throws TituloInvalidoException
	{
		int i;
		
		for (i=0; i<eleitores.size(); i++)
			if (titulo.equals(eleitores.get(i).getTitulo()))
				throw new TituloInvalidoException ("Ja existe uma pessoa com esse titulo cadastrado!!!");
		return true;
	}
	
	public static boolean validacaoTituloEleitor (String titulo, ArrayList <Eleitor> eleitores) throws TituloInvalidoException
	{
		int i;
		
		for (i=0; i<eleitores.size(); i++){
			if (titulo.equals(eleitores.get(i).getTitulo()))
				return true;
		}
		throw new TituloInvalidoException ("Titulo inexistente!!!");

	}
	
	public static Eleitor pesquisaEleitor (String titulo, ArrayList <Eleitor> eleitores) throws EleitorNaoExistenteException
	{
		int i;
		Eleitor eleitor;
		
		for (i=0; i<eleitores.size(); i++)
			if (titulo.equals(eleitores.get(i).getTitulo()))
				{
					eleitor = eleitores.get(i);
					return (eleitor);
				}
		
		if (i==eleitores.size())
			throw new EleitorNaoExistenteException ("Nao existe nenhum eleitor com o titulo pesquisado!!!");
		return null; 
	}
	
	public static Eleitor pesquisaEleitorNome (String nome, ArrayList <Eleitor> eleitores) throws EleitorNaoExistenteException
	{
		int i;
		Eleitor eleitor;
		
		for (i=0; i<eleitores.size(); i++)
			if (nome.equals(eleitores.get(i).getNome()))
			{
				eleitor = eleitores.get(i);
				return (eleitor);
			}
		if (i==eleitores.size())
			throw new EleitorNaoExistenteException ("Nao existe nenhum eleitor com o titulo pesquisado!!!");
		return null;
	}
	
	public static void imprimeEleitorCompleta (Eleitor eleitor)
	{
		System.out.println("Nome do eleitor: "+eleitor.getNome());
		System.out.println("Data de nascimento: "+eleitor.getDataDeNascimento());
		System.out.println("Titulo do eleitor: "+eleitor.getTitulo());
		System.out.println("Zona do eleitor: "+eleitor.getZona());
		System.out.println("Secao: "+eleitor.getSecao());
		System.out.println("--------------------------------------------------");
		System.out.println("");
	}
	
	public static void imprimeEleitorParcial (Eleitor eleitor)
	{
		System.out.println("Nome do eleitor: "+eleitor.getNome());
		System.out.println("Titulo do eleitor: "+eleitor.getTitulo());
		System.out.println("--------------------------------------------------");
		System.out.println("");
	}
}