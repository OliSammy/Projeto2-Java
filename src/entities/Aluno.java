package entities;

public class Aluno {
    private String nome;
    private int matricula;
    private String respostas;

    public Aluno(String nome, int matricula, String respostas) {
        this.nome = nome;
        this.matricula = matricula;
        this.respostas = respostas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }
}