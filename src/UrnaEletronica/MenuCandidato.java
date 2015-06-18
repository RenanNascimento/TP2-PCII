package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Prefeito.verificaCodigoPrefeito;
import static UrnaEletronica.Prefeito.listarPrefeito;

public class MenuCandidato 
{
	
	public static void CandidatoMenu(){

		Scanner in = new Scanner(System.in);
		
		ArrayList<Prefeito> prefeitos = new ArrayList<Prefeito>();
		ArrayList<Vereador> vereadores = new ArrayList<Vereador>();
		
		Iterator i, j;
		
		Prefeito p;
		Vereador v;
		VicePrefeito vP;
		
		boolean menu = true, submenuPrefeito;
		
	    String nome, nomeVicePrefeito,email, emailVicePrefeito, dataNascimento, dataNascimentoVicePrefeito;
	    int codigo, codigoVicePrefeito, opcao, opcaoPrefeito, index, confirma;
	    
	    
	    do{
	    	System.out.println("");
	    	System.out.println("Menu - Candidato");
	    	System.out.println("Digite a opcao desejada: ");
	    	System.out.println("1 - Prefeito");
	    	System.out.println("2 - Vereador");
	    	System.out.println("0 - SAIR");
	    	opcao = in.nextInt();
	    	if(opcao==0){
	    		menu = false;
	    	}
	    	
	    	switch(opcao){
	    	
	    		case 1:
	    			do{
	    				System.out.println("");
	    				submenuPrefeito = true;
	    				System.out.println("Menu - Prefeito");
	    				System.out.println("Digite a opcao desejada: ");
	    				System.out.println("1 - Cadastrar");
	    				System.out.println("2 - Excluir");
	    				System.out.println("3 - Listar");
	    				System.out.println("4 - Pesquisar");
	    				System.out.println("5 - Alterar");
	    				System.out.println("0 - VOLTAR");
	    				opcaoPrefeito = in.nextInt();
	    				if(opcaoPrefeito==0){
	    					submenuPrefeito = false;
	    				}
	    				
	    				switch(opcaoPrefeito){
	    				
	    					case 1:
	    						
	    						try{
		    						System.out.println("Digite os dados do Prefeito");
		    						System.out.println("Codigo: "); codigo = in.nextInt(); 
		    						System.out.println("Nome: "); nome = in.next();
		    						System.out.println("Email: "); email = in.next();
		    						System.out.println("Data de nascimento: "); dataNascimento = in.next();
		    						System.out.println("");
		    						System.out.println("Digite os dados do Vice-Prefeito");
		    						System.out.println("Codigo Vice-Prefeito: "); codigoVicePrefeito = in.nextInt();
		    						System.out.println("Nome Vice-Prefeito: "); nomeVicePrefeito = in.next();
		    						System.out.println("Email Vice-Prefeito:"); emailVicePrefeito = in.next();
		    						System.out.println("Data de nascimento Vice-Prefeito: "); dataNascimentoVicePrefeito = in.next();
		    						
		    						//Verifica se o codigo ja existe
		    						confirma = 0;
		    						i = prefeitos.iterator();
		    						while(i.hasNext()){
		    							p = (Prefeito) i.next();
		    							if(codigo == p.getCodigo()){
		    								confirma = 1;
		    								throw new CodigoJaExistenteException ("Codigo ja existente!!!");
		    							}
		    						}
		    						
		    						if(verificaCodigoPrefeito(codigo) && confirma == 0){
		    							vP = new VicePrefeito(nomeVicePrefeito, emailVicePrefeito, dataNascimentoVicePrefeito, codigoVicePrefeito);
		    							p = new Prefeito(nome, email, dataNascimento, codigo, vP);
		    							prefeitos.add(p);
		    						}
	    						
	    						}
	    				        catch(CodigoInvalidoException e){
	    				        	System.out.println("Erro: "+e.toString());
	    				        }
	    						catch(CodigoJaExistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						
	    						break;
	    					
	    					case 2:
	    						try{
	    							i = prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new PrefeitoInexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Prefeito que sera excluido: "); codigo = in.nextInt();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(codigo == p.getCodigo()){
			    								System.out.println("Dados do Prefeito que se deseja excluir: ");
			    								listarPrefeito(p);
			    								break;
			    							}
			    						}
			    						if(index==prefeitos.size()){
			    							throw new PrefeitoInexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
			    						else{
			    							System.out.println("");
			    							System.out.println("Voce realmente deseja excluir esse Prefeito? 1-Sim/0-Nao"); confirma = in.nextInt();
			    							if(confirma == 1){
			    								prefeitos.remove(index);
			    							}
			    						}
	    							}
	    						}
		    					catch(PrefeitoInexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    						
	    					case 3:
	    						try{
	    							i = prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new PrefeitoInexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
			    						i = prefeitos.iterator();
			    						while(i.hasNext()){
			    							p = (Prefeito) i.next();
			    							listarPrefeito(p);
			    						}
	    							}
	    						}
		    					catch(PrefeitoInexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    					
	    					case 4:
	    						try{
	    							i = prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new PrefeitoInexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
		    							System.out.println("Digite o codigo do Prefeito a ser pesquisado: ");
			    						codigo = in.nextInt();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(codigo == p.getCodigo()){
			    								listarPrefeito(p);
			    								break;
			    							}
			    						}
			    						if(index==prefeitos.size()){
			    							throw new PrefeitoInexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
		    						}
	    						}
	    						catch(PrefeitoInexistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						break;
	    					
	    					case 5:
	    						try{
	    							i = prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new PrefeitoInexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Prefeito cujos dados serao alterados: "); codigo = in.nextInt();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(codigo == p.getCodigo()){
			    								System.out.println("Dados do Prefeito que serao alterados: ");
			    								listarPrefeito(p);
			    								System.out.println("");
				    							System.out.println("Voce realmente deseja alterar os dados desse Prefeito? 1-Sim/0-Nao"); confirma = in.nextInt();
				    							if(confirma == 1){
						    						System.out.println("Digite os dados do Prefeito");
						    						System.out.println("Codigo: "); codigo = in.nextInt(); p.setCodigo(codigo);
						    						System.out.println("Nome: "); nome = in.next(); p.setNome(nome);
						    						System.out.println("Email: "); email = in.next(); p.setEmail(email);
						    						System.out.println("Data de nascimento: "); dataNascimento = in.next(); p.setDataNascimento(dataNascimento);
						    						System.out.println("");
						    						System.out.println("Digite os dados do Vice-Prefeito");
						    						System.out.println("Codigo Vice-Prefeito: "); codigoVicePrefeito = in.nextInt(); p.vicePrefeito.setCodigo(codigoVicePrefeito);
						    						System.out.println("Nome Vice-Prefeito: "); nomeVicePrefeito = in.next(); p.vicePrefeito.setNome(nomeVicePrefeito);
						    						System.out.println("Email Vice-Prefeito:"); emailVicePrefeito = in.next();p.vicePrefeito.setEmail(emailVicePrefeito);
						    						System.out.println("Data de nascimento Vice-Prefeito: "); dataNascimentoVicePrefeito = in.next(); p.vicePrefeito.setDataNascimento(dataNascimentoVicePrefeito);
				    							}
			    								break;
			    							}
			    						}
			    						if(index==prefeitos.size()){
			    							throw new PrefeitoInexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
	    							}
	    						}
	    						catch(PrefeitoInexistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						break;
	    						
	    					default:
	    						if(opcaoPrefeito!=0){
	    							System.out.println("Opcao invalida!!!");
	    						}
	    				}
	    				
	    			}while(submenuPrefeito);
	    			break;
	    			
	    		case 2:
	    			//menu vereador
	    			break;
	    		default:
	    			if(opcao!=0){
	    				System.out.println("Opcao invalida!!!");
	    			}
	    	}
	    	
	    }while(menu);
	
	}
}