package UrnaEletronica;

import java.util.Scanner;
import java.util.Iterator;

import static UrnaEletronica.MenuCandidato.CandidatoMenu;
import static UrnaEletronica.MenuEleitor.EleitorMenu;
import static UrnaEletronica.IniciarEleicoes.Iniciar;
import static UrnaEletronica.MenuRelatorio.RelatorioMenu;

public class UrnaEletronica {

	public static void main(String[] args) {	
		
		Iterator i, j, k;
		int opcao;
		Scanner in = new Scanner (System.in);
		MinhasListas listas = new MinhasListas ();
		Relatorio relatorio = new Relatorio ();
		boolean votou=false;
		boolean menu=true;
		
		do
		{
			System.out.println("Escolha uma das opcoes abaixo: ");
			System.out.println("1 - Candidatos");
			System.out.println("2 - Eleitores");
			System.out.println("3 - Iniciar eleições");
			System.out.println("4 - Relatorios");
			System.out.println("0 - SAIR");
			opcao = in.nextInt();
			
			if (opcao==0)
				menu=false;
			
			switch (opcao)
			{
				case 1: CandidatoMenu(listas);
						break;
				case 2: EleitorMenu(listas);
						break;
				case 3:
					try{
							i = listas.eleitores.iterator();
							j = listas.prefeitos.iterator();
							k = listas.vereadores.iterator();
							if (i.hasNext()==false){
								throw new InexistenteException ("Nao existe nenhum eleitor");
							}
							else{
								if(j.hasNext()==false){
									throw new InexistenteException ("Nao existe nenhum prefeito");
								}else{
									if(k.hasNext()==false){
										throw new InexistenteException ("Nao existe nenhum vereador");
									}else{
										Iniciar(listas,relatorio);
										votou = true;
									}
								}
							}
							break;
					}
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
					
				case 4:
					try{
							i = listas.eleitores.iterator();
							j = listas.prefeitos.iterator();
							k = listas.vereadores.iterator();
							if (i.hasNext()==false){
								throw new InexistenteException ("Nao existe nenhum eleitor");
							}
							else{
								if(j.hasNext()==false){
									throw new InexistenteException ("Nao existe nenhum prefeito");
								}else{
									if(k.hasNext()==false){
										throw new InexistenteException ("Nao existe nenhum vereador");
									}else{
										if(votou==false){
											throw new InexistenteException ("Nao foi realizada a votacao");
										}else{
											RelatorioMenu(listas,relatorio);
										}
									}
								}
							}						
							break;
					}
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
				default:
					if(opcao!=0)
						System.out.println("Opcao invalida!!!");
			}
		}
		while (menu);

	}
}