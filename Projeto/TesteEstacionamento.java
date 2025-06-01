package Projeto;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TesteEstacionamento {

    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
        int op, vagas = 30; //opção, máximo de vagas

        do {
            System.out.println("\n=== ESTACIONAMENTO GARAGEM BOYS ===");
            System.out.println("\n1 - Cadastrar Veículo e Vaga");
            System.out.println("\n2 - Retirar Veículo (Gerar Ticket)");
            System.out.println("\n3 - Listar Veículos no Estacionamento");
            System.out.println("\n0 - Sair");
            System.out.print("\nEscolha uma opção: ");
            op = leia.nextInt();
            leia.nextLine(); // limpa o buffer

            switch (op) {

                case 1:
                    if (vagas == 0) {
                        System.out.println("\nEstacionamento cheio!");
                        break;
                    }
                    
                    System.out.print("\nDigite o número da vaga: ");
                    int numVaga = leia.nextInt();
                    leia.nextLine();

                    // Verificar se a vaga já está ocupada
                    boolean vagaOcupada = false;
                    for (Veiculo v : carros) {
                        if (v.getNumeroVaga() == numVaga) {
                            vagaOcupada = true;
                            break;
                        }
                    }

                    if (vagaOcupada) {
                        System.out.println("\nA vaga " + numVaga + " já está ocupada. Escolha outra vaga.");
                        break;
                    }

                    System.out.print("\nDigite o bloco da vaga: ");
                    String blocoVaga = leia.nextLine().toUpperCase();

                    System.out.print("\nDigite o número do piso: ");
                    int piso = leia.nextInt();
                    leia.nextLine();

                    System.out.print("\nDigite a placa do veículo: ");
                    String placa = leia.nextLine().toUpperCase();

                    System.out.print("\nDigite o modelo do Veículo: ");
                    String modelo = leia.nextLine();

                    System.out.print("\nDigite a cor do Veículo: ");
                    String cor = leia.nextLine();
                    
                    Veiculo novoCarro = new Veiculo(numVaga, blocoVaga, piso, placa, modelo, cor);
                    
                    System.out.println("\nVeículo cadastrado com sucesso!!!");
                    
                    carros.add(novoCarro);
                    vagas--;
                    System.out.println("\nAinda há "+vagas+" vagas!");
                    break;

                case 2:
                    System.out.print("\nDigite a placa do veículo para retirada: ");
                    String placaRetirar = leia.nextLine().toUpperCase();
                    boolean encontrado = false;
                    
                    
                    //
                    for (Veiculo v : carros) {
                        if (v.getPlacaVeiculo().equalsIgnoreCase(placaRetirar)) {
                            v.registrarSaida();
                            v.visualizar();
                            gerarTicketTxt(v);
                            carros.remove(v);
                            vagas++;
                            encontrado = true;
                            System.out.println("\nVeículo removido e ticket gerado.");
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\nVeículo não encontrado.");
                    }

                    break;

                case 3:
                    if (carros.isEmpty()) {
                        System.out.println("\nNenhum veículo no estacionamento.");
                    } else {
                        System.out.println("\n=== Veículos Estacionados ===");
                        for (Veiculo v : carros) {
                            v.visualizar();
                        }
                    }
                    break;

                case 0:
                    System.out.println("\nPrograma Encerrado!!!");
                    break;

                default:
                    System.out.println("\nOpção inválida, tente novamente!");
            }

        } while (op != 0);

        leia.close(); //fechando o scanner
    }

    //gera o arquivo txt, utilizando "FileWriter"
    public static void gerarTicketTxt(Veiculo v) {
        String nomeArquivo = "ticket_" + v.getPlacaVeiculo() + ".txt";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("====== TICKET DE ESTACIONAMENTO ======\n");
            writer.write("Número da Vaga: " + v.getNumeroVaga() + "\n");
            writer.write("Bloco: " + v.getBlocoVaga() + "\n");
            writer.write("Piso: " + v.getNumeroPiso() + "\n");
            writer.write("Placa: " + v.getPlacaVeiculo() + "\n");
            writer.write("Modelo: " + v.getModeloVeiculo() + "\n");
            writer.write("Cor: " + v.getCorVeiculo() + "\n");

            // Formatar data, utilizando DateTimeFormatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            writer.write("Entrada: " + v.getHorarioEntrada().format(formatter) + "\n");
            writer.write("Saída: " + v.getHorarioSaida().format(formatter) + "\n");
            writer.write("Tempo Estacionado (min): " + v.getTempoEmMinutos() + "\n");
            writer.write("Valor Total: " + v.formatarMoeda() + "\n");
            writer.write("=======================================\n");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o ticket: " + e.getMessage());
        }
    }
}
