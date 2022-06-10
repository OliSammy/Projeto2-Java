import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno a = new Aluno("Eduardo", 01, "VFVFVFVFVF");
        Aluno b = new Aluno("Samuel", 02, "VVVVVFFFFF");
        Aluno c = new Aluno("Clara", 03, "FFFFFVVVVV");

        Disciplina POO = new Disciplina("POO", 01, "VVVVVVVVVV");
        POO.adicionarAluno(a);
        POO.adicionarAluno(b);
        POO.adicionarAluno(c);

        try {
            POO.gerarRespostasTurma();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
        }
    }
}
