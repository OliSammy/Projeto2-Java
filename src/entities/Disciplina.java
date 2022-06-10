package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
        File diretorio = new File("C:\\workspace\\JavaProjects\\Projeto-Arquivos-POO\\Arquivos\\");
        diretorio.mkdir();
        File disciplina = new File(diretorio, nomeDisciplina);
        File arquivo = new File(disciplina.getAbsolutePath(), nomeDisciplina + ".txt");
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        Collections.sort(turma);
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

    public void ordenarAlfabetica() {

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
