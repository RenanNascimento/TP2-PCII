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
			System.out.println("Total de votos zona 001: "+v.getNumVotosZona001());
			System.out.println("Total de votos zona 002: "+v.getNumVotosZona002());
			System.out.println("Total de votos zona 003: "+v.getNumVotosZona003());
		}
		System.out.println("-----------------------------");
		
	}
	
}