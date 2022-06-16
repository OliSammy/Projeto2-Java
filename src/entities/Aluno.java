package entities;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private int matricula;
    private String respostas;
    private int nota;

    public Aluno() {
    }

    public Aluno(String nome, int matricula, String respostas) {
        this.nome = nome;
        this.matricula = matricula;
        this.respostas = respostas;
    }

    public void gerarNota(String gabarito) {
        nota = 0;
        if (respostas.equalsIgnoreCase("vvvvvvvvvv") || respostas.equalsIgnoreCase("ffffffffff"))
            nota = 0;
        else {
            for (int i = 0; i < gabarito.length(); i++) {
                if (respostas.charAt(i) == gabarito.charAt(i)) {
                    nota += 1;
                }
            }
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota *= nota;
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

    @Override
    public int compareTo(Aluno outroAluno) {
        return this.nome.compareTo(outroAluno.getNome());
    }
}