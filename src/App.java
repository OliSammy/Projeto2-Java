import java.util.Scanner;

import domainexception.GabaritoInvalidoException;
import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Scanner lerNum = new Scanner(System.in);
        Cadeiras cadeiras = new Cadeiras();
        String nome;
        int id;
        String respostas;
        Disciplina disciplina;
        System.out.println(
                "Selecione a opção que deseja realizar:\n1.Cadastrar novadisciplina\t2.Acessar disciplina\t3.Sair do programa.");
        int op = lerNum.nextInt();
        while (op != 3) {
            switch (op) {
                case 1:
                    System.out.println("\nDigite o nome da disciplina:");
                    nome = ler.nextLine();
                    System.out.println("Digite a id que deseja associar a ela:");
                    id = lerNum.nextInt();
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
                        int op2 = lerNum.nextInt();
                        while (op2 != 4) {
                            switch (op2) {
                                case 1:
                                    System.out.println("Quantos alunos deseja cadastrar?");
                                    int qtde = lerNum.nextInt();
                                    for (int i = 0; i < qtde; i++) {
                                        System.out.println(
                                                "\nDigite o nome, a matricula e as respostas do aluno a ser cadastrado");
                                        nome = ler.next();
                                        id = lerNum.nextInt();
                                        respostas = ler.next();
                                        Aluno aluno = new Aluno(nome, id, respostas);
                                        disciplina.adicionarAluno(aluno);
                                    }
                                    break;
                                case 2:
                                    System.out.println(
                                            "\nDigite o caminho do arquivo de gabarito. Certifique se de digitar o caminho corretamente e com duas barras '\\' ");
                                    String caminho = ler.next();
                                    try {
                                        disciplina.receberGarabito(caminho);
                                        try {
                                            disciplina.gerarRespostasTurma();
                                            System.out.println("Gerando notas...");
                                            for (int i = 0; i < 10; i++) {
                                                System.out.print("#");
                                                Thread.sleep(1000);
                                            }
                                            System.out.println("\nNotas geradas com sucesso.\n");
                                        } catch (Exception e) {
                                            System.out.println("Error: " + e.getMessage());
                                        }
                                    } catch (GabaritoInvalidoException e) {
                                        System.out.println(e.getMessage());
                                    } catch (Exception e) {
                                        System.out.println(
                                                "Não foi possível encontrar o arquivo. Verifique se você escreveu corretamente o caminho, e tente novamente.");
                                    }

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
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            System.out.println(
                                    "\n1.Cadastrar Alunos e notas\t2.Gerar notas\t3.Consultar notas\t4.Sair do menu disciplina");
                            op2 = lerNum.nextInt();
                        }
                    }
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println(
                    "\nSelecione a opção que deseja realizar:\n1.Cadastrar nova disciplina\t2.Acessar disciplina\t3.Sair do programa.");
            op = lerNum.nextInt();
        }
        ler.close();
        lerNum.close();
    }
}