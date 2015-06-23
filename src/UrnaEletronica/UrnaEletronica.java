package UrnaEletronica;

import java.util.Scanner;

import static UrnaEletronica.MenuCandidato.CandidatoMenu;
import static UrnaEletronica.MenuEleitor.EleitorMenu;
import static UrnaEletronica.IniciarEleicoes.Iniciar;

public class UrnaEletronica {

	public static void main(String[] args) {		
		int opcao;
		Scanner in = new Scanner (System.in);
		MinhasListas listas = new MinhasListas ();
		Relatorio relatorio = new Relatorio ();
		
		do
		{
			System.out.println("Escolha uma das opcoes abaixo: ");
			System.out.println("1 - Candidatos");
			System.out.println("2 - Eleitores");
			System.out.println("3 - Iniciar eleições");
			System.out.println("4 - Relatorios");
			System.out.println("0 - SAIR");
			opcao = in.nextInt();
			
			switch (opcao)
			{
				case 1: CandidatoMenu(listas);
						break;
				case 2: EleitorMenu(listas);
						break;
				case 3: Iniciar(listas,relatorio);
						break;
				case 4: // Produz os relatorios
					 	break;
				case 0: System.exit(0);
				default: System.out.println("Opcao invalida!!!");
			}
		}
		while (true);
	}
}