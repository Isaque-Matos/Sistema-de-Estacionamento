package Projeto;

public class Vagas {

	protected int numeroVaga;
	protected String blocoVaga;
	protected int tempoEmMinutos; // tempo que ficou na vaga em minutos
	protected int numeroPiso; 
	
	public Vagas(int numeroVaga, String blocoVaga, int tempoEmMinutos, int numeroPiso) {
		this.numeroVaga = numeroVaga;
		this.blocoVaga = blocoVaga;
		this.tempoEmMinutos = tempoEmMinutos;
		this.numeroPiso = numeroPiso;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public String getBlocoVaga() {
		return blocoVaga;
	}

	public void setBlocoVaga(String blocoVaga) {
		this.blocoVaga = blocoVaga;
	}

	public int getTempoEmMinutos() {
		return tempoEmMinutos;
	}

	public void setTempoEmMinutos(int tempoEmMinutos) {
		this.tempoEmMinutos = tempoEmMinutos;
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}
	
	
	
	
	
	
	
	
}
