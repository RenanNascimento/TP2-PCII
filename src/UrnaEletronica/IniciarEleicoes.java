package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;
import static UrnaEletronica.Eleitor.pesquisaEleitor;
import static UrnaEletronica.Prefeito.listarPrefeitoParcial;

public class IniciarEleicoes 
{
	public static void Iniciar (MinhasListas listas, Relatorio relatorio)
	{
		Scanner in = new Scanner (System.in);
		String nome;
		String titulo;
		String zona;
		String secao;
		String horaAbertura;
		int numEleitoresSecao;
		Eleitor presidentes [] = new Eleitor [3];
		int i;
		int opcao, opcaoVotar;
		int codigo;
		Eleitor eleitor;
		Prefeito p;
		Iterator t;
		boolean votou;
		
		try
		{
			for (i=0; i<3; i++)
			{
				System.out.println("Digite o nome do presidente: ");
				nome = in.next();
				System.out.println("Digite o titulo do presidente: ");
				titulo = in.next();
				verificaTituloEleitor (titulo, listas.eleitores);
				System.out.println("Digite a zona no presidente: ");
				System.out.println("Zonas disponiveis - 001 - 002 - 003");
				zona = in.next();
				if(zona.equals("001") || zona.equals("002") || zona.equals("003")){				
					System.out.println("Digite a secao do presidente: ");
					secao = in.next();
					System.out.println("Digite a hora de abertura da secao: ");
					horaAbertura = in.next();
					System.out.println("Digite o numero de eleitores da secao: ");
					numEleitoresSecao = in.nextInt();
					presidentes [i] = new Eleitor (nome, titulo, zona, secao, horaAbertura, numEleitoresSecao);
					listas.eleitores.add(presidentes [i]);
				}else{
					throw new ZonaInvalidaException ("Zona invalida!!!");
				}
			}
			
			do
			{
				System.out.println("Digite uma das opcoes abaixo: ");
				System.out.println("1 - Zona 001");
				System.out.println("2 - Encerrar votacao zona 001");
				System.out.println("3 - Zona 002");
				System.out.println("4 - Encerrar votacao zona 002");
				System.out.println("5 - Zona 003");
				System.out.println("6 - Encerrar votacao zona 003");
				opcao = in.nextInt();
				
				switch (opcao)
				{
					case 1: 
						try
						{
							t = listas.prefeitos.iterator();
							System.out.println("Digite o titulo do eleitor para votacao: ");
							titulo = in.next();
							if (verificaTituloEleitor (titulo, listas.eleitores))
							{
								eleitor = pesquisaEleitor (titulo, listas.eleitores);
								if (eleitor.getZona().equals("001"))
								{
									votou = false;
									p = null;
									while(votou==false){
										System.out.println("Digite o codigo do prefeito: ");
										System.out.println("Caso 99 - BRANCO");
										codigo = in.nextInt();
										if(codigo == 99){
											relatorio.setVotoBranco();
											votou=true;
											break;
										}
										while(t.hasNext()){
											p = (Prefeito) t.next();
											if(codigo == p.getCodigo()){
												listarPrefeitoParcial(p);
												break;
											}
										}
										System.out.println("Voce realmente deseja votar nesse prefeito (1-Sim/0-Nao): ");
										opcaoVotar = in.nextInt();
										if(opcaoVotar == 1){
											p.setNumVotosTotal();
											p.setNumVotosZona001();
											votou = true;
										}else{
											votou = false;
										}
									}
								}
							}
						}
						catch (TituloInvalidoException e)
						{
							System.out.println("Erro: "+e.toString());
						}
						catch (EleitorNaoExistenteException e)
						{
							System.out.println("Erro: "+e.toString());
						}
				}
			}
			while (presidentes[0].getSecaoEncerrada ()==true && presidentes[1].getSecaoEncerrada()==true && presidentes [1].getSecaoEncerrada()==true);	
			
		}
		catch (TituloInvalidoException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		catch (ZonaInvalidaException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		
	}	
}