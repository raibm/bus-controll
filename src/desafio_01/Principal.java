package desafio_01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		ControleViagem CV = new ControleViagem();
		ArrayList<Cidade> cidades = new ArrayList<Cidade>();
		boolean status = true, qtdAprovado = true, falha = true;
		Cidade cidadeO, cidadeD;
		Viagem v;
		String options = "";
		String relatorioFinal = "";
		int menu, qtdAssento, qtdCidade, qtdPassageiro = 0, nome, ref;

		do {
			try {
				do {
					menu = Integer.valueOf(JOptionPane.showInputDialog("[1] - Adicionar viagem" + "\n[0] - Sair"));
					cidades = new ArrayList<Cidade>();
					CV = new ControleViagem();
					switch (menu) {
					case 0:
						JOptionPane.showMessageDialog(null, "Finalizado.");
						status = false;
						break;
					case 1:
						qtdAssento = Integer.valueOf(JOptionPane.showInputDialog("Número de acentos: "));
						Onibus o = new Onibus(qtdAssento);
						qtdCidade = Integer.valueOf(JOptionPane.showInputDialog("Quantidade de cidades no trajeto: "));

						for (int i = 0; i < qtdCidade; i++) {
							Cidade c = new Cidade(i);
							options += "[" + i + "]" + "Cidade " + c.getNome() + "\n";
							cidades.add(c);
						}
						;

						for (int i = 0; i < cidades.size()-1; i++) {
							qtdAprovado = true;
							do {
								if (i == 0) {
									cidadeO = cidades.get(i);
									qtdPassageiro = Integer.valueOf(JOptionPane.showInputDialog(
											"Cidade " + i + "\nQuantidade de passageiros que embarcarão: "));
									if(qtdPassageiro != 0) {
										if (qtdPassageiro <= o.getQtdAssentos()) {
											if (qtdPassageiro == 0) {
												qtdAprovado = false;
											}
											ref = Integer.valueOf(JOptionPane.showInputDialog(
													"Escolha a cidade de destino: " + "\nCidades: " + "\n" + options));
											cidadeD = cidades.get(ref);
											v = new Viagem(o, cidadeO, cidadeD, qtdPassageiro);
											o.add(qtdPassageiro);
											qtdAprovado = false;
											CV.addViagem(v);
											relatorioFinal += "Viagem [" + i + "] origem: Cidade " + cidadeO.getNome()
													+ ", destino: Cidade " + cidadeD.getNome() + ", quatidade embarcada: "
													+ qtdPassageiro + ", quantidade de passagens disponíveis nessa viagem: "
													+ o.acentosLivres() + "\n";
										} else {
											JOptionPane.showConfirmDialog(null, "Quantidade de passagens indisponíveis."
													+ "Total disponível: " + o.getQtdAssentos());
										}
									}else {
										qtdAprovado = false;

									}
									
								} else if(i != cidades.size()){
									cidadeO = cidades.get(i);
									qtdPassageiro = Integer.valueOf(JOptionPane.showInputDialog(
											"Cidade " + i + "\nQuantidade de passageiros que embarcarão: "));
									CV.procurarViagens(cidadeO);
									if (qtdPassageiro <= o.acentosLivres()) {
										if (qtdPassageiro != 0) {
											ref = Integer.valueOf(JOptionPane.showInputDialog(
													"Escolha a cidade de destino: " + "\nCidades: " + "\n" + options));
											if (ref <= i && i != cidades.size() - 1) {

												do {
													JOptionPane.showConfirmDialog(null, "Esse trajeto não é valido.");
													ref = Integer.valueOf(
															JOptionPane.showInputDialog("Escolha a cidade de destino: "
																	+ "\nCidades: " + "\n" + options));
													if (ref > i) {
														falha = false;
													}
												} while (falha);

											}
											cidadeD = cidades.get(ref);
											v = new Viagem(o, cidadeO, cidadeD, qtdPassageiro);
											o.add(qtdPassageiro);
											qtdAprovado = false;
											CV.addViagem(v);

											relatorioFinal += "Viagem [" + i + "] origem: Cidade " + cidadeO.getNome()
													+ ", destino: Cidade " + cidadeD.getNome()
													+ ", quatidade embarcada: " + qtdPassageiro
													+ ", quantidade de passagens disponíveis nessa viagem: "
													+ o.acentosLivres() + "\n";
										} else {
											qtdAprovado = false;
										}

									} else {
										JOptionPane.showConfirmDialog(null, "Quantidade de passagens indisponíveis."
												+ "Total disponível: " + o.acentosLivres());
									}
								}

							} while (qtdAprovado);
						}

						JOptionPane.showConfirmDialog(null, relatorioFinal);
					default:
						break;
					}
				} while (status);
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Ops... algum erro aconteceu!");
			}
		} while (status);

	}

}
