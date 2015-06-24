package UrnaEletronica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import static UrnaEletronica.Prefeito.verificaCodigoPrefeito;
import static UrnaEletronica.Prefeito.listarPrefeitoCompleto;
import static UrnaEletronica.Prefeito.listarPrefeitoParcial;
import static UrnaEletronica.Vereador.verificaCodigoVereador;
import static UrnaEletronica.Vereador.listarVereador;

public class MenuCandidato 
{
	
	public static void CandidatoMenu(MinhasListas listas){

		Scanner in = new Scanner(System.in);
		
		Iterator i, j;
		
		Prefeito p;
		Vereador v;
		VicePrefeito vP;
		
		boolean menu = true, submenuPrefeito, submenuVereador;
		
	    String nome, nomeVicePrefeito,email, emailVicePrefeito, dataNascimento, dataNascimentoVicePrefeito;
	    int codigo, opcao, opcaoPrefeito, opcaoVereador, index, confirma;
	    
	    
	    do{
	    	System.out.println("");
	    	System.out.println("Menu - Candidato");
	    	System.out.println("Digite a opcao desejada: ");
	    	System.out.println("1 - Prefeito");
	    	System.out.println("2 - Vereador");
	    	System.out.println("0 - VOLTAR");
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
		    						System.out.println("Nome Vice-Prefeito: "); nomeVicePrefeito = in.next();
		    						System.out.println("Email Vice-Prefeito:"); emailVicePrefeito = in.next();
		    						System.out.println("Data de nascimento Vice-Prefeito: "); dataNascimentoVicePrefeito = in.next();
		    						
		    						//Verifica se o codigo ja existe
		    						confirma = 0;
		    						i = listas.prefeitos.iterator();
		    						while(i.hasNext()){
		    							p = (Prefeito) i.next();
		    							if(codigo == p.getCodigo()){
		    								confirma = 1;
		    								throw new CodigoJaExistenteException ("Codigo ja existente!!!");
		    							}
		    						}
		    						
		    						if(verificaCodigoPrefeito(codigo) && confirma == 0){
		    							vP = new VicePrefeito(nomeVicePrefeito, emailVicePrefeito, dataNascimentoVicePrefeito, codigo);
		    							p = new Prefeito(nome, email, dataNascimento, codigo, vP);
		    							listas.prefeitos.add(p);
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
	    							i = listas.prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Prefeito que sera excluido: "); codigo = in.nextInt();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(codigo == p.getCodigo()){
			    								System.out.println("Dados do Prefeito que se deseja excluir: ");
			    								listarPrefeitoCompleto(p);
			    								break;
			    							}
			    						}
			    						if(index==listas.prefeitos.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
			    						else{
			    							System.out.println("");
			    							System.out.println("Voce realmente deseja excluir esse Prefeito? 1-Sim/0-Nao"); confirma = in.nextInt();
			    							if(confirma == 1){
			    								listas.prefeitos.remove(index);
			    							}
			    						}
	    							}
	    						}
		    					catch(InexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    						
	    					case 3:
	    						try{
	    							i = listas.prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
			    						i = listas.prefeitos.iterator();
			    						while(i.hasNext()){
			    							p = (Prefeito) i.next();
			    							listarPrefeitoParcial(p);
			    						}
	    							}
	    						}
		    					catch(InexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    					
	    					case 4:
	    						try{
	    							i = listas.prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
		    							System.out.println("Digite o nome do Prefeito a ser pesquisado: ");
			    						nome = in.next();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(nome.equals(p.getNome())){
			    								listarPrefeitoParcial(p);
			    								break;
			    							}
			    						}
			    						if(index==listas.prefeitos.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
		    						}
	    						}
	    						catch(InexistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						break;
	    					
	    					case 5:
	    						try{
	    							i = listas.prefeitos.iterator();
	    							if(i.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Prefeito");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Prefeito cujos dados serao alterados: "); codigo = in.nextInt();
			    						for(index=0; i.hasNext(); index++){
			    							p = (Prefeito) i.next();
			    							if(codigo == p.getCodigo()){
			    								System.out.println("Dados do Prefeito que serao alterados: ");
			    								listarPrefeitoCompleto(p);
			    								System.out.println("");
				    							System.out.println("Voce realmente deseja alterar os dados desse Prefeito? 1-Sim/0-Nao"); confirma = in.nextInt();
				    							if(confirma == 1){
						    						System.out.println("Digite os dados do Prefeito");
						    						System.out.println("Nome: "); nome = in.next(); p.setNome(nome);
						    						System.out.println("Email: "); email = in.next(); p.setEmail(email);
						    						System.out.println("Data de nascimento: "); dataNascimento = in.next(); p.setDataNascimento(dataNascimento);
						    						System.out.println("");
						    						System.out.println("Digite os dados do Vice-Prefeito");
						    						System.out.println("Nome Vice-Prefeito: "); nomeVicePrefeito = in.next(); p.vicePrefeito.setNome(nomeVicePrefeito);
						    						System.out.println("Email Vice-Prefeito:"); emailVicePrefeito = in.next();p.vicePrefeito.setEmail(emailVicePrefeito);
						    						System.out.println("Data de nascimento Vice-Prefeito: "); dataNascimentoVicePrefeito = in.next(); p.vicePrefeito.setDataNascimento(dataNascimentoVicePrefeito);
				    							}
			    								break;
			    							}
			    						}
			    						if(index==listas.prefeitos.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Prefeito!!!");
			    						}
	    							}
	    						}
	    						catch(InexistenteException e){
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
	    			
	    			do{
	    				System.out.println("");
	    				submenuVereador = true;
	    				System.out.println("Menu - Vereador");
	    				System.out.println("Digite a opcao desejada: ");
	    				System.out.println("1 - Cadastrar");
	    				System.out.println("2 - Excluir");
	    				System.out.println("3 - Listar");
	    				System.out.println("4 - Pesquisar");
	    				System.out.println("5 - Alterar");
	    				System.out.println("0 - VOLTAR");
	    				opcaoVereador = in.nextInt();
	    				if(opcaoVereador==0){
	    					submenuVereador = false;
	    				}
	    				
	    				switch(opcaoVereador){
	    				
	    					case 1:
	    						
	    						try{
		    						System.out.println("Digite os dados do Vereador");
		    						System.out.println("Codigo: "); codigo = in.nextInt(); 
		    						System.out.println("Nome: "); nome = in.next();
		    						System.out.println("Email: "); email = in.next();
		    						System.out.println("Data de nascimento: "); dataNascimento = in.next();
		    						
		    						//Verifica se o codigo ja existe
		    						confirma = 0;
		    						j = listas.vereadores.iterator();
		    						while(j.hasNext()){
		    							v = (Vereador) j.next();
		    							if(codigo == v.getCodigo()){
		    								confirma = 1;
		    								throw new CodigoJaExistenteException ("Codigo ja existente!!!");
		    							}
		    						}
		    						
		    						if(verificaCodigoVereador(codigo) && confirma == 0){
		    							v = new Vereador(nome, email, dataNascimento, codigo);
		    							listas.vereadores.add(v);
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
	    							j = listas.vereadores.iterator();
	    							if(j.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Vereador");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Vereador que sera excluido: "); codigo = in.nextInt();
			    						for(index=0; j.hasNext(); index++){
			    							v = (Vereador) j.next();
			    							if(codigo == v.getCodigo()){
			    								System.out.println("Dados do Vereador que se deseja excluir: ");
			    								listarVereador(v);
			    								break;
			    							}
			    						}
			    						if(index==listas.vereadores.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Vereador!!!");
			    						}
			    						else{
			    							System.out.println("");
			    							System.out.println("Voce realmente deseja excluir esse Vereador? 1-Sim/0-Nao"); confirma = in.nextInt();
			    							if(confirma == 1){
			    								listas.vereadores.remove(index);
			    							}
			    						}
	    							}
	    						}
		    					catch(InexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    						
	    					case 3:
	    						try{
	    							j = listas.vereadores.iterator();
	    							if(j.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Vereador");
	    							}
	    							else{
			    						j = listas.vereadores.iterator();
			    						while(j.hasNext()){
			    							v = (Vereador) j.next();
			    							listarVereador(v);
			    						}
	    							}
	    						}
		    					catch(InexistenteException e){
		    						System.out.println("Erro: "+e.toString());
		    					}
	    						break;
	    					
	    					case 4:
	    						try{
	    							j = listas.vereadores.iterator();
	    							if(j.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Vereador");
	    							}
	    							else{
		    							System.out.println("Digite o codigo do Vereador a ser pesquisado: ");
			    						codigo = in.nextInt();
			    						for(index=0; j.hasNext(); index++){
			    							v = (Vereador) j.next();
			    							if(codigo == v.getCodigo()){
			    								listarVereador(v);
			    								break;
			    							}
			    						}
			    						if(index==listas.vereadores.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Vereador!!!");
			    						}
		    						}
	    						}
	    						catch(InexistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						break;
	    					
	    					case 5:
	    						try{
	    							j = listas.vereadores.iterator();
	    							if(j.hasNext() == false){
	    								throw new InexistenteException ("Não existe nenhum Vereador");
	    							}
	    							else{
	    								System.out.println("Digite o codigo do Vereador cujos dados serao alterados: "); codigo = in.nextInt();
			    						for(index=0; j.hasNext(); index++){
			    							v = (Vereador) j.next();
			    							if(codigo == v.getCodigo()){
			    								System.out.println("Dados do Vereador que serao alterados: ");
			    								listarVereador(v);
			    								System.out.println("");
				    							System.out.println("Voce realmente deseja alterar os dados desse Vereador? 1-Sim/0-Nao"); confirma = in.nextInt();
				    							if(confirma == 1){
						    						System.out.println("Digite os dados do Vereador");
						    						System.out.println("Codigo: "); codigo = in.nextInt(); v.setCodigo(codigo);
						    						System.out.println("Nome: "); nome = in.next(); v.setNome(nome);
						    						System.out.println("Email: "); email = in.next(); v.setEmail(email);
						    						System.out.println("Data de nascimento: "); dataNascimento = in.next(); v.setDataNascimento(dataNascimento);
						    						System.out.println("");
				    							}
			    								break;
			    							}
			    						}
			    						if(index==listas.vereadores.size()){
			    							throw new InexistenteException ("O codigo pesquisado nao faz referencia a um Vereador!!!");
			    						}
	    							}
	    						}
	    						catch(InexistenteException e){
	    							System.out.println("Erro: "+e.toString());
	    						}
	    						break;
	    						
	    					default:
	    						if(opcaoVereador!=0){
	    							System.out.println("Opcao invalida!!!");
	    						}
	    				}
	    				
	    			}while(submenuVereador);
	    			break;

	    		default:
	    			if(opcao!=0){
	    				System.out.println("Opcao invalida!!!");
	    			}
	    	}
	    	
	    }while(menu);
	
	}
}