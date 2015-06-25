package UrnaEletronica;

import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Prefeito.listarPrefeitoCompleto;

public class Relatorio {

	
	private int votoBrancoPrefeito, votoBrancoVereador;
	
	public Relatorio (){
		
		this.votoBrancoPrefeito = 0;
		this.votoBrancoVereador = 0;
	}
	
	public void setVotoBrancoPrefeito (){
		
		this.votoBrancoPrefeito++;
	}
	
	public void setVotoBrancoVereador (){
		
		this.votoBrancoVereador++;
	}
	
	public int getVotoBrancoPrefeito (){
		
		return votoBrancoPrefeito;
	}
	
	public int getVotoBrancoVereador (){
		
		return votoBrancoVereador;
	}

	public static void listarVotosPrefeito (Prefeito p, int aux){
		
		System.out.println("Nome: "+p.getNome());
		System.out.println("Codigo: "+p.getCodigo());
		System.out.println("Nome Vice-Prefeito: "+p.vicePrefeito.getNome()); 
		System.out.println("Total de votos: "+p.getNumVotosTotal());
		if(aux==1){
			System.out.println("Total de votos zona 001: "+p.getNumVotosZona001());
			System.out.println("Total de votos zona 002: "+p.getNumVotosZona002());
			System.out.println("Total de votos zona 003: "+p.getNumVotosZona003());
		}
		System.out.println("-----------------------------");
	}
	
	public static void listarVotosVereador (Vereador v, int aux){
		
		System.out.println("Nome: "+v.getNome());
		System.out.println("Codigo: "+v.getCodigo());
		System.out.println("Total de votos: "+v.getNumVotosTotal());
		if(aux==1){
			System.out.println("");
			System.out.println("Total de votos zona 001: "+v.getNumVotosZona001());
			System.out.println("Total de votos zona 002: "+v.getNumVotosZona002());
			System.out.println("Total de votos zona 003: "+v.getNumVotosZona003());
			System.out.println("");
		}
		System.out.println("-----------------------------");
		
	}
	
	public static void prefeitoMaisMenosVotos (ArrayList<Prefeito> p, String x){
		
		int i;
		int maisVotos = p.get(0).getNumVotosTotal();
		int menosVotos = p.get(0).getNumVotosTotal();
		
		for(i=0; i<p.size(); i++){
			if(p.get(i).getNumVotosTotal() > maisVotos && x.equals("+")){
				maisVotos = p.get(i).getNumVotosTotal();
			}
			if(p.get(i).getNumVotosTotal() < menosVotos && x.equals("-")){
				menosVotos = p.get(i).getNumVotosTotal();
			}
		}
		
		for(i=0; i<p.size(); i++){
			if(p.get(i).getNumVotosTotal() == maisVotos && x.equals("+")){
				System.out.println("Nome: "+p.get(i).getNome());
				System.out.println("Codigo: "+p.get(i).getCodigo());
				System.out.println("Nome Vice-Prefeito: "+p.get(i).vicePrefeito.getNome()); 
				System.out.println("Total de votos: "+p.get(i).getNumVotosTotal());
				System.out.println("");
				break;
			}
			if(p.get(i).getNumVotosTotal() == menosVotos && x.equals("-")){
				System.out.println("Nome: "+p.get(i).getNome());
				System.out.println("Codigo: "+p.get(i).getCodigo());
				System.out.println("Nome Vice-Prefeito: "+p.get(i).vicePrefeito.getNome()); 
				System.out.println("Total de votos: "+p.get(i).getNumVotosTotal());
				System.out.println("");
				break;				
			}
		}
		
	}

	public static void vereadorMaisMenosVotos (ArrayList<Vereador> v, String x){
		
		int i;
		int maisVotos = v.get(0).getNumVotosTotal();
		int menosVotos = v.get(0).getNumVotosTotal();
		
		for(i=0; i<v.size(); i++){
			if(v.get(i).getNumVotosTotal() > maisVotos && x.equals("+")){
				maisVotos = v.get(i).getNumVotosTotal();
			}
			if((v.get(i).getNumVotosTotal() < menosVotos) && x.equals("-")){
				menosVotos = v.get(i).getNumVotosTotal();
			}
		}
		
		for(i=0; i<v.size(); i++){
			if(v.get(i).getNumVotosTotal() == maisVotos && x.equals("+")){
				System.out.println("Nome: "+v.get(i).getNome());
				System.out.println("Codigo: "+v.get(i).getCodigo()); 
				System.out.println("Total de votos: "+v.get(i).getNumVotosTotal());
				System.out.println("");
				break;
			}
			if(v.get(i).getNumVotosTotal() == menosVotos && x.equals("-")){
				System.out.println("Nome: "+v.get(i).getNome());
				System.out.println("Codigo: "+v.get(i).getCodigo()); 
				System.out.println("Total de votos: "+v.get(i).getNumVotosTotal());
				System.out.println("");
				break;				
			}
		}
		
	}

	
}