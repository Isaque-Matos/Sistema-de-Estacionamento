package Projeto;

public interface Ticket {

	public String nomeInterface = "Ticket";
	
    public float pagamento();
    abstract public void visualizar();
    abstract public String formatarMoeda();
}
