package UrnaEletronica;

import java.util.Scanner;
import java.util.Iterator;

import static UrnaEletronica.Relatorio.listarVotosPrefeito;
import static UrnaEletronica.Relatorio.listarVotosVereador;
import static UrnaEletronica.Relatorio.prefeitoMaisMenosVotos;
import static UrnaEletronica.Relatorio.vereadorMaisMenosVotos;

public class MenuRelatorio {

	public static void RelatorioMenu(MinhasListas listas, Relatorio relatorio){
		
		Scanner in = new Scanner(System.in);
		
		boolean menu = true;
		int opcao;
		Iterator i, j;
		Prefeito p;
		Vereador v;
		
		do{
			
			System.out.println("1 - Qtde votos de cada prefeito");
			System.out.println("2 - Qtde votos de cada vereador");
			System.out.println("3 - Qtde votos de cada prefeito por zona");
			System.out.println("4 - Qtde votos de cada vereador por zona");
			System.out.println("5 - Qtde votos branco");
			System.out.println("6 - Prefeito com mais votos");
			System.out.println("7 - Prefeito com menos votos");
			System.out.println("8 - Vereador com mais votos");
			System.out.println("9 - Vereador com mais votos");
			System.out.println("0 - SAIR");
			opcao = in.nextInt();
	    	if(opcao==0){
	    		menu = false;
	    	}
	    	
	    	switch(opcao){
	    		
	    		case 1:
	    			i = listas.prefeitos.iterator();
	    			while(i.hasNext()){
	    				p = (Prefeito) i.next();
	    				listarVotosPrefeito(p,0);
	    			}
	    			break;
	    			
	    		case 2:
	    			j = listas.vereadores.iterator();
	    			while(j.hasNext()){
	    				v = (Vereador) j.next();
	    				listarVotosVereador(v,0);
	    			}
	    			break;
	    			
	    		case 3:
	    			i = listas.prefeitos.iterator();
	    			while(i.hasNext()){
	    				p = (Prefeito) i.next();
	    				listarVotosPrefeito(p,1);
	    			}
	    			break;
	    			
	    		case 4:
	    			j = listas.vereadores.iterator();
	    			while(j.hasNext()){
	    				v = (Vereador) j.next();
	    				listarVotosVereador(v,1);
	    			}
	    			break;	    			
	    			
	    		case 5:
	    			System.out.println("Qtde votos branco prefeito: "+relatorio.getVotoBrancoPrefeito());
	    			System.out.println("Qtde votos branco vereador: "+relatorio.getVotoBrancoVereador());
	    			break;
	    			
	    		case 6:
	    			prefeitoMaisMenosVotos(listas.prefeitos,"+");
	    			break;
	    			
	    		case 7:
	    			prefeitoMaisMenosVotos(listas.prefeitos,"-");
	    			break;
	    			
	    		case 8:
	    			vereadorMaisMenosVotos(listas.vereadores,"+");
	    			break;
	    			
	    		case 9:
	    			vereadorMaisMenosVotos(listas.vereadores,"-");
	    			break;
	    		
	    		default:
					if(opcao!=0){
						System.out.println("Opcao invalida!!!");
					}
					
	    	}
	    	
	    	
		}while(menu);
		
	}
	
}
