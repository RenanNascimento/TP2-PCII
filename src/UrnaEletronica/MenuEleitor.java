package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;
import static UrnaEletronica.Eleitor.pesquisaEleitor;
import static UrnaEletronica.Eleitor.imprimeEleitor;

public class MenuEleitor 
{
	public static void main (String [] args)
	{
		Scanner in = new Scanner (System.in);
		
		String nome;
		String dataDeNascimento;
		String titulo;
		String zona;
		String secao;
		Eleitor eleitor;
		ArrayList<Eleitor> eleitores = new ArrayList<Eleitor>();
		int opcao;
		
		System.out.println("Digite uma das opcoes abaixo: ");
		System.out.println("1 - Cadastrar eleitor");
		System.out.println("2 - Excluir eleitor");
		System.out.println("3 - Listar eleitores");
		System.out.println("4 - Pesquisar eleitores");
		System.out.println("5 - Alterar eleitor");
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
						verificaTituloEleitor (titulo, eleitores);
						System.out.println("Digite a zona do eleitor: ");
						zona = in.next();
						System.out.println("Digite a secao do eleitor: ");
						secao = in.next();
						eleitor = new Eleitor (nome, dataDeNascimento, titulo, zona, secao);
						eleitores.add(eleitor);
					}
					catch (TituloInvalidoException e)
					{
						System.out.println("Erro: "+e.toString());
					}
					break;
			
			case 2: try
					{
						System.out.println("Digite o titulo do eleitor ser excluido: ");
						titulo = in.nextLine();
						eleitor = pesquisaEleitor (titulo, eleitores);
						
					}
		}
	}
}