package entities;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import domainexception.DisciplinaVaziaException;
import domainexception.GabaritoInvalidoException;

public class Disciplina {
    private String nomeDisciplina;
    private int idDisciplina;
    private ArrayList<Aluno> turma;
    private String gabaritoOficial;

    public Disciplina(String nomeDisciplina, int idDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.idDisciplina = idDisciplina;
        turma = new ArrayList<Aluno>();
        File pastaDisciplina;
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 11")) {
            pastaDisciplina = new File("C:\\Projeto2-Java\\Arquivos",
                    nomeDisciplina);
        } else {
            pastaDisciplina = new File("/home/matheus/Programming/Projeto2-Java/Arquivos/",
                    nomeDisciplina);
        }
        pastaDisciplina.mkdir();
    }

    public void adicionarAluno(Aluno x) {
        turma.add(x);
    }

    public void receberGarabito(String caminho) throws FileNotFoundException, IOException, GabaritoInvalidoException {
        File arquivo = new File(caminho);
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        String temp = leitorBuff.readLine();
        if (temp.equalsIgnoreCase("vvvvvvvvvv") || temp.equalsIgnoreCase("ffffffffff")) {
            leitorBuff.close();
            throw new GabaritoInvalidoException();
        }
        gabaritoOficial = temp;
        leitorBuff.close();
    }

    public void gerarNotas() throws DisciplinaVaziaException {
        if (turma.isEmpty()) {
            throw new DisciplinaVaziaException();
        }
        for (Aluno aluno : turma) {
            aluno.gerarNota(gabaritoOficial);
        }
    }

    public void gerarRespostasTurma() throws IOException, DisciplinaVaziaException {
        gerarNotas();
        ArquivoAlfa();
        ArquivoNota();
    }

    public void ArquivoAlfa() throws IOException {
        File arquivo;
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 11") || System.getProperty("os.name")
                .equalsIgnoreCase("Windows 10")) {
            arquivo = new File("C:\\Projeto2-Java\\Arquivos\\" + nomeDisciplina, nomeDisciplina + ".txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto2-Java/Arquivos/" + nomeDisciplina,
                    nomeDisciplina + ".txt");
        }

        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        ArrayList<Aluno> x = new ArrayList<Aluno>();
        x = turma;
        Collections.sort(x);
        for (Aluno aluno : x) {
            escritorBuff.write(aluno.getRespostas() + "\t" + aluno.getNome() + "\t" + aluno.getNota() + "\n");
        }
        escritorBuff.close();
    }

    public void ArquivoNota() throws IOException {
        File arquivo;
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 11") || System.getProperty("os.name")
                .equalsIgnoreCase("Windows 10")) {
            arquivo = new File("C:\\Projeto2-Java\\Arquivos\\" + nomeDisciplina, nomeDisciplina + ".txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto2-Java/Arquivos/" + nomeDisciplina,
                    nomeDisciplina + ".txt");
        }
        FileWriter escritor = new FileWriter(arquivo);
        BufferedWriter escritorBuff = new BufferedWriter(escritor);
        Aluno[] x = ordemPorNotas(turma);
        for (Aluno aluno : x) {
            escritorBuff.write(aluno.getRespostas() + "\t" + aluno.getNome() + "\t" + aluno.getNota() + "\n");
        }
        escritorBuff.close();
    }

    public Aluno[] ordemPorNotas(ArrayList<Aluno> t) {
        Aluno[] teste = new Aluno[t.size()];
        for (int i = 0; i < t.size(); i++) {
            teste[i] = t.get(i);
        }
        int maior;
        for (int i = 0; i < teste.length - 1; i++) {
            maior = i;
            for (int j = i + 1; j < teste.length; j++) {
                if (teste[maior].getNota() < teste[j].getNota()) {
                    maior = j;
                }
            }
            Aluno temp = new Aluno();
            temp = teste[maior];
            teste[maior] = teste[i];
            teste[i] = temp;
        }
        return teste;
    }

    public void consultarNotas() throws FileNotFoundException, IOException, GabaritoInvalidoException {
        File arquivo;
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 11") || System.getProperty("os.name")
                .equalsIgnoreCase("Windows 10")) {
            arquivo = new File("C:\\Projeto2-Java\\Arquivos\\" + nomeDisciplina, nomeDisciplina + ".txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto2-Java/Arquivos/" + nomeDisciplina,
                    nomeDisciplina + ".txt");
        }
        FileReader leitor = new FileReader(arquivo);
        BufferedReader leitorBuff = new BufferedReader(leitor);
        try {
            String[] dados = leitorBuff.readLine().split("\t");
            while (dados != null) {
                System.out.println("Nome: " + dados[1] + " Nota: " + dados[2]);
                dados = leitorBuff.readLine().split("\t");
            }
        } catch (Exception e) {

        } finally {
            leitorBuff.close();
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
