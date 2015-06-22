package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Eleitor.verificaTituloEleitor;

public class IniciarEleicoes 
{
	public static void Iniciar (MinhasListas listas)
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
				zona = in.next();
				System.out.println("Digite a secao do presidente: ");
				secao = in.next();
				System.out.println("Digite a hora de abertura da secao: ");
				horaAbertura = in.next();
				System.out.println("Digite o numero de eleitores da secao: ");
				numEleitoresSecao = in.nextInt();
				presidentes [i] = new Eleitor (nome, titulo, zona, secao, horaAbertura, numEleitoresSecao);
				listas.eleitores.add(presidentes [i]);
			}
		}
		catch (TituloInvalidoException e)
		{
			System.out.println("Erro: "+e.toString());
		}
	}	
}