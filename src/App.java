import java.util.Scanner;

import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Cadeiras cadeiras = new Cadeiras();
        String nome;
        int id;
        String respostas;
        Disciplina disciplina;
        System.out.println(
                "Selecione a opção que deseja realizar:\n1.Cadastrar novadisciplina\t2.Acessar disciplina\t3.Sair do programa.");
        int op = ler.nextInt();
        while (op != 3) {
            switch (op) {
                case 1:
                    System.out.println("\nDigite o nome da disciplina e a id que deseja associar a ela.");
                    nome = ler.next();
                    id = ler.nextInt();
                    disciplina = new Disciplina(nome, id);
                    cadeiras.adicionarDisciplina(disciplina);
                    break;
                case 2:
                    System.out.println("\nDigite o nome ou o id da disciplina que deseja selecionar.");
                    nome = ler.next();
                    try {
                        int temp = Integer.parseInt(nome);
                        disciplina = cadeiras.selecionarDisciplina(temp);
                    } catch (Exception e) {
                        disciplina = cadeiras.selecionarDisciplina(nome);
                    }
                    if (disciplina == null) {
                        System.out.println("Disciplina inexistente.");
                    } else {
                        System.out.println("\nDisciplina " + disciplina.getNomeDisciplina() + " selecionada.");
                        System.out.println(
                                "\n1.Cadastrar Alunos e notas\t2.Gerar notas\t3.Consultar notas\t4.Sair do menu disciplina");
                        int op2 = ler.nextInt();
                        while (op2 != 4) {
                            switch (op2) {
                                case 1:
                                    System.out.println("Quantos alunos deseja cadastrar?");
                                    int qtde = ler.nextInt();
                                    for (int i = 0; i < qtde; i++) {
                                        System.out.println(
                                                "\nDigite o nome, a matricula e as respostas do aluno a ser cadastrado");
                                        nome = ler.next();
                                        id = ler.nextInt();
                                        respostas = ler.next();
                                        Aluno aluno = new Aluno(nome, id, respostas);
                                        disciplina.adicionarAluno(aluno);
                                    }
                                    break;
                                case 2:
                                    System.out.println(
                                            "\nDigite o caminho do arquivo de gabarito. Certifique se de digitar o caminho corretamente e com duas barras '\\' ");
                                    String caminho = ler.next();
                                    disciplina.receberGarabito(caminho);
                                    try {
                                        disciplina.gerarRespostasTurma();
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                    System.out.println("Gerando notas...");
                                    for (int i = 0; i < 10; i++) {
                                        System.out.print("#");
                                        Thread.sleep(1000);
                                    }
                                    System.out.println("\nNotas geradas com sucesso.\n");
                                    break;
                                case 3:
                                    try {
                                        disciplina.consultarNotas();
                                    } catch (Exception e) {
                                        System.out.println(
                                                "Não foi possivel consultar as notas.\nCadastre alunos, só assim será possivel acessar as notas.");

                                    }
                                    break;
                                default:
                                    break;
                            }
                            System.out.println(
                                    "\n1.Cadastrar Alunos e notas\t2.Gerar notas\t3.Consultar notas\t4.Sair do menu disciplina");
                            op2 = ler.nextInt();
                        }
                    }

                default:
                    break;
            }
            System.out.println(
                    "\nSelecione a opção que deseja realizar:\n1.Cadastrar nova disciplina\t2.Acessar disciplina\t3.Sair do programa.");
            op = ler.nextInt();
        }
        ler.close();
    }
}
