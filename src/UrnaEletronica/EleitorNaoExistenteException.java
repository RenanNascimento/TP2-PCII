package UrnaEletronica;

public class EleitorNaoExistenteException extends Exception 
{
	public EleitorNaoExistenteException (String mensagem)
    {
        super (mensagem);
    }
}