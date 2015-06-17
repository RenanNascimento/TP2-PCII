package UrnaEletronica;

public class Prefeito extends Candidato
{
	protected VicePrefeito vicePrefeito;
	
    public Prefeito(String nome, String email, String dataNascimento, int codigo, VicePrefeito vicePrefeito) {
        super(nome, email, dataNascimento, codigo);
        this.vicePrefeito = vicePrefeito;
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
    
    public static void listarPrefeito (Prefeito p){
    	
    	System.out.println("");
		System.out.println("Dados do Prefeito");
		System.out.println("Codigo: "+p.getCodigo());
		System.out.println("Nome: "+p.getNome()); 
		System.out.println("Email: "+p.getEmail()); 
		System.out.println("Data de nascimento: "+p.getDataNascimento());
		System.out.println("");
		System.out.println("Dados do Vice-Prefeito");
		System.out.println("Codigo Vice-Prefeito: "+p.vicePrefeito.getCodigo()); 
		System.out.println("Nome Vice-Prefeito: "+p.vicePrefeito.getNome()); 
		System.out.println("Email Vice-Prefeito:"+p.vicePrefeito.getEmail()); 
		System.out.println("Data de nascimento Vice-Prefeito: "+p.vicePrefeito.getDataNascimento()); 
    	
    }
}