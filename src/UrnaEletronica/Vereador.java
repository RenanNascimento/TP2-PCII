package UrnaEletronica;

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
    
}
