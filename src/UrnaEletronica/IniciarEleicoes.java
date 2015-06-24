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
import static UrnaEletronica.Eleitor.validacaoTituloEleitor;
import static UrnaEletronica.Prefeito.validacaoCodigoPrefeito;
import static UrnaEletronica.Vereador.validacaoCodigoVereador;

public class IniciarEleicoes 
{
	public static void Iniciar (MinhasListas listas, Relatorio relatorio)
	{
		Scanner in = new Scanner (System.in);
		String nome;
		String titulo;
		String zona="";
		String secao;
		String horaAbertura, horaEncerramento;
		int numEleitoresSecao;
		Eleitor presidentes [] = new Eleitor [3];
		int i;
		int opcao, opcaoVotar;
		int codigo;
		Eleitor eleitor;
		Prefeito p;
		Vereador v;
		Iterator t, h;
		boolean votouPrefeito, votouVereador, cadastroPresidente = false;
		int confirmaFechamento;
			
		try{
			for (i=0; i<3; i++)
			{
				System.out.println("Digite o nome do presidente: ");
				nome = in.next();
				System.out.println("Digite o titulo do presidente: ");
				titulo = in.next();
				verificaTituloEleitor (titulo, listas.eleitores);
				System.out.println("Zonas disponiveis - 001 - 002 - 003");
				if(i==0){
					System.out.println("Presidente associado a zona 001");
					zona = "001";
				}else{
					if(i==1){
						System.out.println("Presidente associado a zona 002");
						zona = "002";
					}else{
						if(i==2){
							System.out.println("Presidente associado a zona 003");
							zona = "003";
						}
					}
				}
				if(zona.equals("001") || zona.equals("002") || zona.equals("003")){				
					System.out.println("Digite a secao do presidente: ");
					secao = in.next();
					System.out.println("Digite a hora de abertura da secao: ");
					horaAbertura = in.next();
					System.out.println("Digite o numero de eleitores da secao: ");
					numEleitoresSecao = in.nextInt();
					System.out.println("---------------------------------------");
					System.out.println("");
					presidentes [i] = new Eleitor (nome, titulo, zona, secao, horaAbertura, numEleitoresSecao);
				}else{
					throw new ZonaInvalidaException ("Zona invalida!!!");
				}
			}
			
			for (i=0; i<3; i++)
			{
				listas.eleitores.add(presidentes [i]);
				cadastroPresidente = true;
			}
		}
		catch (TituloInvalidoException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		catch (ZonaInvalidaException e)
		{
			System.out.println("Erro: "+e.toString());
		}
		if(cadastroPresidente){
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
						try{
							votouPrefeito=false;
							votouVereador=false;
							while (votouPrefeito==false || votouVereador==false)
							{
								if (presidentes[0].getSecaoEncerrada ()==false)
								{
									t = listas.prefeitos.iterator();
									h = listas.vereadores.iterator();
									System.out.println("Digite o titulo do eleitor para votacao: ");
									titulo = in.next();
									if (validacaoTituloEleitor (titulo, listas.eleitores))
									{
										eleitor = pesquisaEleitor (titulo, listas.eleitores);
										if (eleitor.getZona().equals("001"))
										{
											//Votacao prefeito
											p = null;
											while(votouPrefeito==false){
												t = listas.prefeitos.iterator();
												System.out.println("Digite o codigo do prefeito: ");
												System.out.println("Caso 99 - BRANCO");
												codigo = in.nextInt();
												if(codigo == 99){
													relatorio.setVotoBrancoPrefeito();
													votouPrefeito=true;
													break;
												}else{
													validacaoCodigoPrefeito (codigo, listas.prefeitos);
												
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
														votouPrefeito = true;
														System.out.println("Voto confirmado!!!");
													}else{
														votouPrefeito = false;
													}
												}
											}
											
											//Votacao vereador
											System.out.println("");
											v = null;
											while(votouVereador==false){
												h = listas.vereadores.iterator();
												System.out.println("Digite o codigo vererador: ");
												System.out.println("Caso 9999 - BRANCO");
												codigo = in.nextInt();
												if (codigo == 9999){
													relatorio.setVotoBrancoVereador();
													votouVereador=true;
													break;
												}else{
													validacaoCodigoVereador (codigo, listas.vereadores);
	
													while(h.hasNext()){
														v = (Vereador) h.next();
														if (codigo == v.getCodigo()) {
															listarVereador (v);
															break;
														}
													}
													System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
													opcaoVotar = in.nextInt();
													if(opcaoVotar == 1){
														v.setNumVotosTotal();
														v.setNumVotosZona001();
														votouVereador = true;
														System.out.println("Voto confirmado!!!");
													}else{
														votouVereador = false;
													}
												}
											}
										}else{
											throw new ZonaInvalidaException ("Zona invalida!!!");
										}
									}
								}
								else
									System.out.println("A votacao na zona 001 esta encerrada!!!");
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
						catch (CodigoInvalidoException e)
						{
							System.out.println("Erro: "+e.toString());
						}
						catch (ZonaInvalidaException e)
						{
							System.out.println("Erro: "+e.toString());
						}

						break; // Fim do case 1
					
					case 2:
						try{
							System.out.println("Para encerrar a votacao da zona 001 digite o titulo do presidente da zona: "); 
							titulo = in.next();
							if(titulo.equals(presidentes[0].getTitulo())){
								System.out.println("Voce realmente deseja encerrar a votacao na zona 001? 1-Sim/0-Nao");
								confirmaFechamento = in.nextInt();
								if (confirmaFechamento==1){
									System.out.println("Digite o horario de encerramento: "); horaEncerramento = in.next();
									presidentes [0].setSecaoEncerrada(true);
									presidentes [0].setHoraEncerramento(horaEncerramento);
								}
								else{
									System.out.println("Voce optou por nao encerrar a votacao na zona 001");
								}
								break;
							}else{
								throw new TituloInvalidoException ("Titulo invalido!!!");
							}
						}
						catch (TituloInvalidoException e)
						{
							System.out.println("Erro: "+e.toString());
						}
						break;

					case 3:
						try{
							if (presidentes[1].getSecaoEncerrada ()==false)
							{
								t = listas.prefeitos.iterator();
								h = listas.vereadores.iterator();
								System.out.println("Digite o titulo do eleitor para votacao: ");
								titulo = in.next();
								if (validacaoTituloEleitor (titulo, listas.eleitores))
								{
									eleitor = pesquisaEleitor (titulo, listas.eleitores);
									if (eleitor.getZona().equals("002"))
									{
										//Votacao prefeito
										votouPrefeito = false;
										p = null;
										while(votouPrefeito==false){
											System.out.println("Digite o codigo do prefeito: ");
											System.out.println("Caso 99 - BRANCO");
											codigo = in.nextInt();
											if(codigo == 99){
												relatorio.setVotoBrancoPrefeito();
												votouPrefeito=true;
												break;
											}else{
												verificaCodigoPrefeito (codigo);
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
												p.setNumVotosZona002();
												votouPrefeito = true;
												System.out.println("Voto confirmado!!!");
											}else{
												votouPrefeito = false;
											}
										}
										
										//Votacao vereador
										System.out.println("");
										votouVereador = false;
										v = null;
										while(votouVereador==false){										
											System.out.println("Digite o codigo vererador: ");
											System.out.println("Caso 9999 - BRANCO");
											codigo = in.nextInt();
											verificaCodigoVereador (codigo);
											if (codigo == 9999){
												relatorio.setVotoBrancoVereador();
												votouVereador=true;
												break;
											}
											while(h.hasNext()){
												v = (Vereador) h.next();
												if (codigo == v.getCodigo()) {
													listarVereador (v);
													break;
												}
											}
											System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
											opcaoVotar = in.nextInt();
											if(opcaoVotar == 1){
												v.setNumVotosTotal();
												v.setNumVotosZona002();
												votouVereador = true;
												System.out.println("Voto confirmado!!!");
											}else{
												votouVereador = false;
											}		
										}
									}
								}
							}
							else
								System.out.println("A votacao na zona 002 esta encerrada!!!");
						}
						catch (TituloInvalidoException e)
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
						break; // Fim do case 3
						
					case 4:
						try{
							System.out.println("Para encerrar a votacao da zona 002 digite o titulo do presidente da zona: "); 
							titulo = in.next();
							if(titulo.equals(presidentes[1].getTitulo())){
								System.out.println("Voce realmente deseja encerrar a votacao na zona 002? 1-Sim/0-Nao");
								confirmaFechamento = in.nextInt();
								if (confirmaFechamento==1){
									System.out.println("Digite o horario de encerramento: "); horaEncerramento = in.next();
									presidentes [1].setSecaoEncerrada(true);
									presidentes [1].setHoraEncerramento(horaEncerramento);
								}
								else{
									System.out.println("Voce optou por nao encerrar a votacao na zona 002");
								}
								break; 
							}else{
								throw new TituloInvalidoException ("Titulo invalido!!!");
							}
						}
						catch (TituloInvalidoException e)
						{
							System.out.println("Erro: "+e.toString());
						}
						break;
						
					case 5:
						try{
							if (presidentes[2].getSecaoEncerrada ()==false)
							{
								t = listas.prefeitos.iterator();
								h = listas.vereadores.iterator();
								System.out.println("Digite o titulo do eleitor para votacao: ");
								titulo = in.next();
								if (validacaoTituloEleitor (titulo, listas.eleitores))
								{
									eleitor = pesquisaEleitor (titulo, listas.eleitores);
									if (eleitor.getZona().equals("003"))
									{
										//Votacao prefeito
										votouPrefeito = false;
										p = null;
										while(votouPrefeito==false){
											System.out.println("Digite o codigo do prefeito: ");
											System.out.println("Caso 99 - BRANCO");
											codigo = in.nextInt();
											verificaCodigoPrefeito (codigo);
											if(codigo == 99){
												relatorio.setVotoBrancoPrefeito();
												votouPrefeito=true;
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
												p.setNumVotosZona003();
												votouPrefeito = true;
												System.out.println("Voto confirmado!!!");
											}else{
												votouPrefeito = false;
											}
										}
										
										//Votacao vereador
										System.out.println("");
										votouVereador = false;
										v = null;
										while(votouVereador==false){										
											System.out.println("Digite o codigo vererador: ");
											System.out.println("Caso 9999 - BRANCO");
											codigo = in.nextInt();
											verificaCodigoVereador (codigo);
											if (codigo == 9999){
												relatorio.setVotoBrancoVereador();
												votouVereador=true;
												break;
											}
											while(h.hasNext()){
												v = (Vereador) h.next();
												if (codigo == v.getCodigo()) {
													listarVereador (v);
													break;
												}
											}
											System.out.println("Voce realmente deseja votar nesse vereador (1-Sim/0-Nao): ");
											opcaoVotar = in.nextInt();
											if(opcaoVotar == 1){
												v.setNumVotosTotal();
												v.setNumVotosZona003();
												votouVereador = true;
												System.out.println("Voto confirmado!!!");
											}else{
												votouVereador = false;
											}		
										}
									}
								}
							}
							else
								System.out.println("A votacao na zona 003 esta encerrada!!!");
						}
						catch (TituloInvalidoException e)
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
						break; // Fim do case 5
						
					case 6: 
						try{
							System.out.println("Para encerrar a votacao da zona 003 digite o titulo do presidente da zona: "); 
							titulo = in.next();
							if(titulo.equals(presidentes[2].getTitulo())){
								System.out.println("Voce realmente deseja encerrar a votacao na zona 003? 1-Sim/0-Nao");
								confirmaFechamento = in.nextInt();
								if (confirmaFechamento==1){
									System.out.println("Digite o horario de encerramento: "); horaEncerramento = in.next();
									presidentes [2].setSecaoEncerrada(true);
									presidentes [2].setHoraEncerramento(horaEncerramento);
								}else{
									System.out.println("Voce optou por nao encerrar a votacao na zona 003");
								}
								break; 
							}else{
								throw new TituloInvalidoException ("Titulo invalido!!!");
							}
						}
						catch (TituloInvalidoException e)
						{
							System.out.println("Erro: "+e.toString());
						}
						break;

					default: System.out.println("Opcao invalida!!!");
				}
			}
			while (presidentes[0].getSecaoEncerrada ()==false || presidentes[1].getSecaoEncerrada()==false || presidentes [2].getSecaoEncerrada()==false);	
		}
	}	
}