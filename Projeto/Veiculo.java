package Projeto;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Veiculo extends Vagas implements Ticket {

    private String placaVeiculo;
    private String modeloVeiculo;
    private String corVeiculo;

    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    public Veiculo(int numeroVaga, String blocoVaga, int numeroPiso, String placaVeiculo,
                   String modeloVeiculo, String corVeiculo) {
        super(numeroVaga, blocoVaga, 0, numeroPiso); // começa com 0 minutos
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.corVeiculo = corVeiculo;
        this.horarioEntrada = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getCorVeiculo() {
        return corVeiculo;
    }

    public void setCorVeiculo(String corVeiculo) {
        this.corVeiculo = corVeiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void registrarSaida() {
        this.horarioSaida = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        Duration duracao = Duration.between(horarioEntrada, horarioSaida);
        this.tempoEmMinutos = (int) duracao.toMinutes();
    }

    public float pagamento() {
        int valor = 0;
        if (tempoEmMinutos <= 60) {
            valor = 10;
        } else {
            valor = (tempoEmMinutos / 60) * 10;
        }
        if (placaVeiculo.contains("L") && placaVeiculo.contains("U") && placaVeiculo.contains("I")
        		&& placaVeiculo.contains("S")) {
            valor = 5;
        }

        return valor;
    }

    public String formatarMoeda() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(2);
        return nf.format(this.pagamento());
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public void visualizar() {
        System.out.println("\n\t================INFORMAÇÕES DO TICKET==================");
        System.out.println("Número da Vaga: " + numeroVaga);
        System.out.println("Bloco da Vaga: " + blocoVaga);
        System.out.println("Número do Piso: " + numeroPiso);
        System.out.println("Placa do Veículo: " + placaVeiculo);
        System.out.println("Modelo do Veículo: " + modeloVeiculo);
        System.out.println("Cor do Veículo: " + corVeiculo);
        System.out.println("Horário de Entrada: " + horarioEntrada.format(formatter));

        if (horarioSaida != null) {
            System.out.println("Horário de Saída: " + horarioSaida);
            System.out.println("Tempo total (minutos): " + tempoEmMinutos);
            System.out.println("Pagamento Total: " + formatarMoeda());
        }
    }
}

	

