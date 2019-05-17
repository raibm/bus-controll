package desafio_01;

import java.util.ArrayList;

public class ControleViagem {
	private ArrayList<Viagem> viagens = new ArrayList<Viagem>();

	public void addViagem(Viagem v) {
		this.viagens.add(v);
	}

	public void procurarViagens(Cidade co) {
		for (int i = 0; i < viagens.size(); i++) {
			if(viagens.get(i).getcDestino() == co) {
				viagens.get(i).getOnibus().rmv(viagens.get(i).getQtdPassageiros());
				if(viagens.get(i).getQtdPassageiros() > viagens.get(i).getOnibus().getQtdAssentos()) {
					viagens.get(i).getOnibus().setQtdOcupados(viagens.get(i).getOnibus().getQtdAssentos());
				}
			}
		}
	}

}
