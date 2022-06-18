package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cadeiras {
    private ArrayList<Disciplina> cadeiras;

    public Cadeiras() {
        cadeiras = new ArrayList<Disciplina>();
    }

    public void adicionarDisciplina(Disciplina x) {
        cadeiras.add(x);
    }

    public Disciplina selecionarDisciplina(String nome) {
        for (Disciplina disciplina : cadeiras) {
            if (disciplina.getNomeDisciplina().equalsIgnoreCase(nome))
                return disciplina;
        }
        return null;
    }

    public Disciplina selecionarDisciplina(int id) {
        for (Disciplina disciplina : cadeiras) {
            if (disciplina.getIdDisciplina() == id)
                return disciplina;
        }
        return null;
    }

    public void acessarDisciplina(String nomeDisciplina) throws IOException {
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

    public void acessarDisciplina(String nomeDisciplina, String tipoDeOrdem) throws IOException {
        if (tipoDeOrdem.equalsIgnoreCase("por nota") || tipoDeOrdem.equalsIgnoreCase("por notas")) {
            tipoDeOrdem = "porNota";
        }
        File arquivo;
        if (System.getProperty("os.name").equalsIgnoreCase("Windows 11") || System.getProperty("os.name")
                .equalsIgnoreCase("Windows 10")) {
            arquivo = new File("C:\\Projeto2-Java\\Arquivos\\" + nomeDisciplina, nomeDisciplina + ".txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto2-Java/Arquivos/" + nomeDisciplina,
                    nomeDisciplina + tipoDeOrdem + ".txt");
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

    public ArrayList<Disciplina> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<Disciplina> cadeiras) {
        this.cadeiras = cadeiras;
    }
}
