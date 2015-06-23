package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;
import static UrnaEletronica.Eleitor.pesquisaEleitor;
import static UrnaEletronica.Prefeito.listarPrefeitoParcial;
import static UrnaEletronica.Prefeito.verificaCodigoPrefeito;
import static UrnaEletronica.Vereador.verificaCodigoVereador;
import static UrnaEletronica.Vereador.listarVereador;

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
		Vereador v;
		Iterator t, h;
		boolean votou;
		int confirmaFechamento;
		
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
						if (presidentes[0].getSecaoEncerrada ()==true)
						{
							t = listas.prefeitos.iterator();
							h = listas.vereadores.iterator();
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
										verificaCodigoPrefeito (codigo);
										if(codigo == 99){
											relatorio.setVotoBrancoPrefeito();
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
									votou = false;
									v = null;
									System.out.println("Digite o codigo vererador: ");
									System.out.println("Caso 9999 - BRANCO");
									codigo = in.nextInt();
									verificaCodigoVereador (codigo);
									if (codigo == 9999){
										relatorio.setVotoBrancoVereador();
										votou=true;
										break;
									}
									while(h.hasNext()){
										v = (Vereador) h.next();
										if (codigo == v.getCodigo()) {
											listarVereador (v);
											break;
										}
										System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
										opcaoVotar = in.nextInt();
										if(opcaoVotar == 1){
											v.setNumVotosTotal();
											v.setNumVotosZona001();
											votou = true;
										}else{
											votou = false;
										}
									}
								}
							}
						}
						else
							System.out.println("A votacao na zona 001 esta encerrada!!!");
					break; // Fim do case 1
					
					case 2:
						System.out.println("Voce realmente deseja encerrar a votacao na zona 001? 1-Sim/0-Nao");
						confirmaFechamento = in.nextInt();
						if (confirmaFechamento==1)
							presidentes [0].setSecaoEncerrada(true);
						else
							System.out.println("Voce optou por nao encerrar a votacao na zona 001");
						break; // Fim do case 2
					
					case 3:
						if (presidentes[1].getSecaoEncerrada ()==true)
						{
							t = listas.prefeitos.iterator();
							h = listas.vereadores.iterator();
							System.out.println("Digite o titulo do eleitor para votacao: ");
							titulo = in.next();
							if (verificaTituloEleitor (titulo, listas.eleitores))
							{
								eleitor = pesquisaEleitor (titulo, listas.eleitores);
								if (eleitor.getZona().equals("002"))
								{
									votou = false;
									p = null;
									while(votou==false){
										System.out.println("Digite o codigo do prefeito: ");
										System.out.println("Caso 99 - BRANCO");
										codigo = in.nextInt();
										verificaCodigoPrefeito (codigo);
										if(codigo == 99){
											relatorio.setVotoBrancoPrefeito();
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
									votou = false;
									v = null;
									System.out.println("Digite o codigo vererador: ");
									System.out.println("Caso 9999 - BRANCO");
									codigo = in.nextInt();
									verificaCodigoVereador (codigo);
									if (codigo == 9999){
										relatorio.setVotoBrancoVereador();
										votou=true;
										break;
									}
									while(h.hasNext()){
										v = (Vereador) h.next();
										if (codigo == v.getCodigo()) {
											listarVereador (v);
											break;
										}
										System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
										opcaoVotar = in.nextInt();
										if(opcaoVotar == 1){
											v.setNumVotosTotal();
											v.setNumVotosZona001();
											votou = true;
										}else{
											votou = false;
										}
									}
								}
							}
						}
						else
							System.out.println("A votacao na zona 002 esta encerrada!!!");
						break; // Fim do case 003
						
					case 4:
						System.out.println("Voce realmente deseja encerrar a votacao na zona 002? 1-Sim/0-Nao");
						confirmaFechamento = in.nextInt();
						if (confirmaFechamento==1)
							presidentes [1].setSecaoEncerrada(true);
						else
							System.out.println("Voce optou por nao encerrar a votacao na zona 002");
						break; // Fim do case 4
					
					case 5:
						if (presidentes[2].getSecaoEncerrada ()==true)
						{
							t = listas.prefeitos.iterator();
							h = listas.vereadores.iterator();
							System.out.println("Digite o titulo do eleitor para votacao: ");
							titulo = in.next();
							if (verificaTituloEleitor (titulo, listas.eleitores))
							{
								eleitor = pesquisaEleitor (titulo, listas.eleitores);
								if (eleitor.getZona().equals("003"))
								{
									votou = false;
									p = null;
									while(votou==false){
										System.out.println("Digite o codigo do prefeito: ");
										System.out.println("Caso 99 - BRANCO");
										codigo = in.nextInt();
										verificaCodigoPrefeito (codigo);
										if(codigo == 99){
											relatorio.setVotoBrancoPrefeito();
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
									votou = false;
									v = null;
									System.out.println("Digite o codigo vererador: ");
									System.out.println("Caso 9999 - BRANCO");
									codigo = in.nextInt();
									verificaCodigoVereador (codigo);
									if (codigo == 9999){
										relatorio.setVotoBrancoVereador();
										votou=true;
										break;
									}
									while(h.hasNext()){
										v = (Vereador) h.next();
										if (codigo == v.getCodigo()) {
											listarVereador (v);
											break;
										}
										System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
										opcaoVotar = in.nextInt();
										if(opcaoVotar == 1){
											v.setNumVotosTotal();
											v.setNumVotosZona001();
											votou = true;
										}else{
											votou = false;
										}
								}
								}
							}
						}
						else
							System.out.println("A votacao na zona 003 esta encerrada!!!");
						break; // Fim do case 5
						
					case 6: 
						System.out.println("Voce realmente deseja encerrar a votacao na zona 003? 1-Sim/0-Nao");
						confirmaFechamento = in.nextInt();
						if (confirmaFechamento==1)
							presidentes [2].setSecaoEncerrada(true);
						else
							System.out.println("Voce optou por nao encerrar a votacao na zona 003");
						break; // Fim do case 6
					default: System.out.println("Opcao invalida!!!");
				}
			}
			while (presidentes[0].getSecaoEncerrada ()==false && presidentes[1].getSecaoEncerrada()==false && presidentes [1].getSecaoEncerrada()==false);	
			
		}
		catch (TituloInvalidoException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		catch (ZonaInvalidaException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		catch (EleitorNaoExistenteException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		catch (CodigoInvalidoException e)
		{
			System.out.println("Erro: "+e.toString());
		}
	}	
}