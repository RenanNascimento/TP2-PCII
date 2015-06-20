package UrnaEletronica;

import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Prefeito.listarPrefeitoCompleto;

public class Relatorio {

	
	private int codigo, qtdeVotos, qtdeVotosZona_1, qtdeVotosZona_2, qtdeVotosZona_3;
	private Iterator i;
	private Relatorio r_aux;
	
	public Relatorio (int codigo){
		
		this.codigo = codigo;
		this.qtdeVotos = 0;
		this.qtdeVotosZona_1 = 0;
		this.qtdeVotosZona_2 = 0;
		this.qtdeVotosZona_3 = 0;
		
	}
	
	public void setVotos (int codigo, String zona, ArrayList<Relatorio> r){
		
		i = r.iterator();
		while(i.hasNext()){
			r_aux = (Relatorio) i.next();
			if(codigo == r_aux.getCodigo()){
				qtdeVotos++;
				if(zona.equals("001")){
					qtdeVotosZona_1++;
				}else{
					if(zona.equals("002")){
						qtdeVotosZona_2++;
					}else{
						qtdeVotosZona_3++;
					}
				}
			}	
		}
		
	}
	
	public void listarRelatorio (ArrayList<Relatorio> r){
		
		i = r.iterator();
		while(i.hasNext()){
			r_aux = (Relatorio) i.next();
			if(r_aux.getCodigo()>=10 && r_aux.getCodigo()<=98){ //trata-se do prefeito
				System.out.println("Prefeito ");
				System.out.println("");
			}else{
				
			}
		}
		
	}
	
	public int getCodigo (){
		
		return codigo;
		
	}
	
	public int getQtdeVotos (){
		
		return qtdeVotos;
		
	}
	
	public int getQtdeVotosZona_1 (){
		
		return qtdeVotosZona_1;
		
	}
	
	public int getQtdeVotosZona_2 (){
		
		return qtdeVotosZona_2;
	
	}
	
	public int getQtdeVotosZona_3 (){
		
		return qtdeVotosZona_3;
		
	}
	
}

