package UrnaEletronica;

public class Prefeito extends Candidato
{
    public Prefeito(String nome, String email, String dataNascimento, int codigo) {
        super(nome, email, dataNascimento, codigo);
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
}
