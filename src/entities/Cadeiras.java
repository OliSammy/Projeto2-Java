package entities;

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

    public ArrayList<Disciplina> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<Disciplina> cadeiras) {
        this.cadeiras = cadeiras;
    }
}
