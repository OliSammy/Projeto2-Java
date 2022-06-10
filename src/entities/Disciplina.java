package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Disciplina {
    private String nomeDisciplina;
    private int idDisciplina;
    private ArrayList<Aluno> turma;
    private String gabaritoOficial;

    public Disciplina(String nomeDisciplina, int idDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.idDisciplina = idDisciplina;
        turma = new ArrayList<Aluno>();
    }

    public void adicionarAluno(Aluno x) {
        turma.add(x);
    }

    public File gerarRespostasTurma() throws IOException {
        gerarNotas();

        File arquivo = new File("C:\\workspace\\JavaProjects\\Projeto-Arquivos-POO\\Arquivos", nomeDisciplina + ".txt");
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        for (Aluno aluno : turma) {
            escritorBuff.write(aluno.getRespostas() + "\t" + aluno.getNome() + "\t" + aluno.getNota() + "\n");
        }
        escritorBuff.close();
        return arquivo;
    }

    public void receberGarabito(String caminho) throws FileNotFoundException, IOException {
        File arquivo = new File(caminho);
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        gabaritoOficial = leitorBuff.readLine();
        leitorBuff.close();
    }

    public void gerarNotas() {

        for (Aluno aluno : turma) {
            aluno.gerarNota(gabaritoOficial);
        }
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public ArrayList<Aluno> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Aluno> turma) {
        this.turma = turma;
    }

    public String getGabaritoOficial() {
        return gabaritoOficial;
    }

    public void setGabaritoOficial(String gabaritoOficial) {
        this.gabaritoOficial = gabaritoOficial;
    }

}
