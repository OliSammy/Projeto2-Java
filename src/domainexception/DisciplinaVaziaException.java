package domainexception;

public class DisciplinaVaziaException extends Exception {
    public DisciplinaVaziaException() {
        super("Disciplina encontrasse vazia no momento. \nCadastre alunos.");
    }
}
