package UrnaEletronica;

import java.util.ArrayList;

public class Vereador extends Candidato{
	
    public Vereador(String nome, String email, String dataNascimento, int codigo) {
        super(nome, email, dataNascimento, codigo);
    }

    public static boolean verificaCodigoVereador (int codigo) throws CodigoInvalidoException
    {
        if (codigo<1000 || codigo>9998)
            {
                throw new CodigoInvalidoException ("Codigo do vereador invalido!!!");
            }
        else
            return true;
    }
    
    public static void listarVereador (Vereador v){	
    	
    	System.out.println("");
		System.out.println("Dados do Vereador");
		System.out.println("Codigo: "+v.getCodigo());
		System.out.println("Nome: "+v.getNome()); 
		System.out.println("Email: "+v.getEmail()); 
		System.out.println("Data de nascimento: "+v.getDataNascimento());
		System.out.println("------------------------------------");
    }
    
    public static boolean validacaoCodigoVereador (int codigo, ArrayList <Vereador> vereadores)
	{
		int i;
		
		for (i=0; i<vereadores.size(); i++){
			if (codigo == vereadores.get(i).getCodigo())
				return true;
		}
			return false;
	}
}