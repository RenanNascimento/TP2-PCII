package UrnaEletronica;

public class Candidato 
{
    private String nome;
    private String email;
    private String dataNascimento;
    private int codigo;

    public Candidato(String nome, String email, String dataNascimento, int codigo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
