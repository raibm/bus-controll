package desafio_01;


public class Viagem {
	private Onibus onibus;
	private Cidade cOrigem;
	private Cidade cDestino;
	private int qtdPassageiros;
	
	public Viagem (Onibus onibus, Cidade cOrigem, Cidade cDestino, int qtdPassageiros) {
		this.onibus = onibus;
		this.cOrigem = cOrigem;
		this.cDestino = cDestino;
		this.qtdPassageiros = qtdPassageiros;
		
	}

	public Onibus getOnibus() {
		return onibus;
	}

	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	
	public Cidade getcOrigem() {
		return cOrigem;
	}

	public void setcOrigem(Cidade cOrigem) {
		this.cOrigem = cOrigem;
	}

	public Cidade getcDestino() {
		return cDestino;
	}

	public void setcDestino(Cidade cDestino) {
		this.cDestino = cDestino;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}
	
	public int qtdDiposnivel() {
		return onibus.getQtdAssentos() - this.qtdPassageiros;
	}
	
	

}
