package UrnaEletronica;

public class Candidato 
{
    private String nome;
    private String email;
    private String dataNascimento;
    private int codigo;
    protected int numVotosTotal, numVotosZona001, numVotosZona002, numVotosZona003;

    public Candidato(String nome, String email, String dataNascimento, int codigo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.codigo = codigo;
        this.numVotosTotal = 0;
        this.numVotosZona001 = 0;
        this.numVotosZona002 = 0;
        this.numVotosZona003 = 0;
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
}