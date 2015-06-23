package UrnaEletronica;

public class Prefeito extends Candidato
{
	
	protected VicePrefeito vicePrefeito;
	protected int numVotosTotal, numVotosZona001, numVotosZona002, numVotosZona003;
	
    public Prefeito(String nome, String email, String dataNascimento, int codigo, VicePrefeito vicePrefeito) {
        super(nome, email, dataNascimento, codigo);
        this.vicePrefeito = vicePrefeito;
        numVotosTotal = 0;
        numVotosZona001 = 0;
        numVotosZona002 = 0;
        numVotosZona003 = 0;
    }
        
    public int getNumVotosTotal() {
		return numVotosTotal;
	}

	public void setNumVotosTotal() {
		this.numVotosTotal++;
	}

	public int getNumVotosZona001() {
		return numVotosZona001;
	}

	public void setNumVotosZona001() {
		this.numVotosZona001++;
	}

	public int getNumVotosZona002() {
		return numVotosZona002;
	}

	public void setNumVotosZona002() {
		this.numVotosZona002++;
	}

	public int getNumVotosZona003() {
		return numVotosZona003;
	}

	public void setNumVotosZona003() {
		this.numVotosZona003++;
	}

	public static boolean verificaCodigoPrefeito (int codigo) throws CodigoInvalidoException
    {
        if (codigo<10 || codigo>98)
            {
                throw new CodigoInvalidoException ("Codigo do prefeito invalido!!!");
            }
        else
            return true;
    }
    
    public static void listarPrefeitoCompleto (Prefeito p){	
    	
    	System.out.println("");
		System.out.println("Dados do Prefeito");
		System.out.println("Codigo: "+p.getCodigo());
		System.out.println("Nome: "+p.getNome()); 
		System.out.println("Email: "+p.getEmail()); 
		System.out.println("Data de nascimento: "+p.getDataNascimento());
		System.out.println("Dados do Vice-Prefeito");
		System.out.println("Codigo Vice-Prefeito: "+p.vicePrefeito.getCodigo()); 
		System.out.println("Nome Vice-Prefeito: "+p.vicePrefeito.getNome()); 
		System.out.println("Email Vice-Prefeito:"+p.vicePrefeito.getEmail()); 
		System.out.println("Data de nascimento Vice-Prefeito: "+p.vicePrefeito.getDataNascimento()); 
		System.out.println("------------------------------------");

    }
    
    public static void listarPrefeitoParcial (Prefeito p){
    	    	
    	System.out.println("");
		System.out.println("Dados do Prefeito");
		System.out.println("Codigo: "+p.getCodigo());
		System.out.println("Nome: "+p.getNome()); 
		System.out.println("Dados do Vice-Prefeito");
		System.out.println("Codigo Vice-Prefeito: "+p.vicePrefeito.getCodigo()); 
		System.out.println("Nome Vice-Prefeito: "+p.vicePrefeito.getNome()); 
		System.out.println("------------------------------------");
	
    }
}
