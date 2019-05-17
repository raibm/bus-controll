package desafio_01;

public class Onibus {
	private int qtdAssentos;
	private int qtdOcupados;
	
	public Onibus(int qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public int getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(int qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}
	
	public void add(int qtd) {
		this.qtdOcupados += qtd;
	}
	
	public void rmv(int qtd) {
		this.qtdOcupados -= qtd;
	}
	
	public int acentosLivres() {
		return this.qtdAssentos - qtdOcupados;
	}

	public int getQtdOcupados() {
		return qtdOcupados;
	}

	public void setQtdOcupados(int qtdOcupados) {
		this.qtdOcupados = qtdOcupados;
	}
	
}
