import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Aluno a = new Aluno("Matheus", 01, "VVVVVVVVVV");
        Aluno b = new Aluno("Samuel", 02, "VVVVVFFFFF");
        Aluno c = new Aluno("Clara", 03, "FFFFFVVVVV");

        Disciplina POO = new Disciplina("POO", 01);
        POO.adicionarAluno(a);
        POO.adicionarAluno(b);
        POO.adicionarAluno(c);

        POO.receberGarabito("C:\\workspace\\JavaProjects\\Projeto-Arquivos-POO\\Arquivos\\gabarito.txt");
        POO.gerarRespostasTurma();

        try {
            POO.gerarRespostasTurma();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getMessage());
        }

    }
}
