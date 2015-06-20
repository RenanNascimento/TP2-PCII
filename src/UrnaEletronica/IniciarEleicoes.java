package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;

public class IniciarEleicoes 
{
	public static void Iniciar ()
	{
		Scanner in = new Scanner (System.in);
		String nome;
		String titulo;
		String zona;
		String secao;
		String horaAbertura;
		String numEleitoresSecao;
		Eleitor presitente;
		int opcao=0;
		
		ArrayList <Eleitor> presidentes = new ArrayList <Eleitor>();
		do
		{
			System.out.println("Digite uma das opcoes abaixo: ");
			System.out.println("1 - Cadastrar um presistente");
			System.out.println("0 - Voltar");
			opcao = in.nextInt();
			
			switch (opcao)
			{
				case 1:
//					try
//					{
//						System.out.println("Digite o nome do presidente: ");
//						nome = in.next();
//						System.out.println("Digite o titulo do presidente: ");
//						titulo = in.next();
//						verificaTituloEleitor (titulo, eleitores);
//					}
//					catch (TituloInvalidoException e)
//					{
//						System.out.println("Erro: "+e.toString());
//					}
					break;
			}
		}
		while (opcao!=0);
	}
}