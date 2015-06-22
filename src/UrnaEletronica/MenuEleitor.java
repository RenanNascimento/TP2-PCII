package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;
import static UrnaEletronica.Eleitor.pesquisaEleitor;
import static UrnaEletronica.Eleitor.imprimeEleitorCompleta;
import static UrnaEletronica.Eleitor.imprimeEleitorParcial;
import static UrnaEletronica.Eleitor.pesquisaEleitorNome;


public class MenuEleitor 
{	
	public static void EleitorMenu (MinhasListas listas)
	{
		Scanner in = new Scanner (System.in);
		
		String nome;
		String dataDeNascimento;
		String titulo;
		String zona;
		String secao;
		Eleitor eleitor;
		int opcao;
		int confirma;
		Iterator i;
		
		do
		{
		System.out.println("Digite uma das opcoes abaixo: ");
		System.out.println("1 - Cadastrar eleitor");
		System.out.println("2 - Excluir eleitor");
		System.out.println("3 - Listar eleitores");
		System.out.println("4 - Pesquisar eleitores");
		System.out.println("5 - Alterar eleitor");
		System.out.println("0 - Voltar");
		opcao = in.nextInt();
		
		switch (opcao)
		{
			case 1: 
					try
					{
						System.out.println("Digite o nome do eleitor: ");
						nome = in.next();
						System.out.println("Digite a data de nascimento do eleitor: ");
						dataDeNascimento = in.next();
						System.out.println("Digite o titulo do eleitor: ");
						titulo = in.next();
						verificaTituloEleitor (titulo, listas.eleitores);
						System.out.println("Digite a zona do eleitor: ");
						zona = in.next();
						System.out.println("Digite a secao do eleitor: ");
						secao = in.next();
						eleitor = new Eleitor (nome, dataDeNascimento, titulo, zona, secao);
						listas.eleitores.add(eleitor);
					}
					catch (TituloInvalidoException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
			
			case 2: try
					{
						i = listas.eleitores.iterator();
						if (i.hasNext()==false)
						{
							throw new InexistenteException ("Nao existe nenhum eleitor");
						}
						else
						{
							confirma = 0;
							System.out.println("Digite o titulo do eleitor a ser excluido: ");
							titulo = in.next();
							eleitor = pesquisaEleitor (titulo, listas.eleitores);
							imprimeEleitorCompleta (eleitor);
							System.out.println("Voce realmente deseja excluir esse ? 1-Sim/0-Nao"); confirma = in.nextInt();
							if (confirma==1)
							{
								listas.eleitores.remove(eleitor);
								System.out.println("Eleitor excluido com sucesso!!!");
							}
								
							else
								System.out.println("Voce optou por nao excluir o eleitor!!!");
						}
						
					}
			
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
			
					catch (EleitorNaoExistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
					
			case 3: try
					{
						i = listas.eleitores.iterator();
						if (i.hasNext()==false)
						{
							throw new InexistenteException ("Nao existe nenhum eleitor");
						}
						else
						{
							for (int index=0; index<listas.eleitores.size(); index++)
								imprimeEleitorParcial (listas.eleitores.get(index));
						}
					}
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
					
			case 4: try
					{
						i = listas.eleitores.iterator();
						if (i.hasNext()==false)
						{
							throw new InexistenteException ("Nao existe nenhum eleitor");
						}
						else
						{
							System.out.println("Digite o nome do eleitor a ser pesquisado: ");
							nome = in.next();
							eleitor = pesquisaEleitorNome (nome, listas.eleitores);
							imprimeEleitorCompleta (eleitor);
						}
					}
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					catch (EleitorNaoExistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
					
			case 5:
					try
					{
						i = listas.eleitores.iterator();
						if (i.hasNext()==false)
						{
							throw new InexistenteException ("Nao existe nenhum eleitor");
						}
						else
						{
							confirma = 0;
							System.out.println("Digite o titulo do eleitor a ser alterado: ");
							titulo = in.next();
							eleitor = pesquisaEleitor (titulo, listas.eleitores);
							imprimeEleitorCompleta (eleitor);
							System.out.println("Voce realmente deseja alterar o eleitor acima? (1-Sim/0-Não");
							confirma = in.nextInt();
							if (confirma==1)
							{
								System.out.println("Digite o novo nome do eleitor: ");
								eleitor.setNome(in.next());
								System.out.println("Digite a nova data de nascimento do eleitor: ");
								eleitor.setDataDeNascimento(in.next());
								System.out.println("Digite a nova zona do eleitor: ");
								eleitor.setZona(in.next());
								System.out.println("Digite a nova secao do eleitor: ");
								eleitor.setSecao(in.next());
							}
							else
								System.out.println("Voce optou por nao alterar o eleitor!!!");
						}
					}
					catch (InexistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					catch (EleitorNaoExistenteException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
			default: if (opcao!=0)
					 	System.out.println("Opcao invalida!!!");
		}
		}
	while (opcao!=0);
	}
}