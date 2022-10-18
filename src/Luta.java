
import java.util.Random;
//import java.util.ArrayList;

public class Luta {
	private Lutador desafiante;
	private Lutador desafiado;
	private Juiz juiz;
	private boolean aprovada;
	private double premioDaLuta;
	private float comissaoJuiz;
	private boolean lutaRealizada;
	private double premioDoLutador;
	private double premioDoJuiz;
	private double mediaComissoesJuiz;
	private boolean considerarNumeroDeEspectadores;
	private double bonusDoLutadorEspectadores;
	private float bonusDoJuizEspectadores;
	private Categoria categoria;
	private double peso;
	// premio da luta = 10000....comissão do juiz = 10% do valor do premio da luta
	// (1000)....então o valor de premio da luta que sobra é 9000, porque é o valor
	// do premio da luta (10000) - comissão do juiz (1000)

	public Categoria getCategoria() {
		return categoria;
	}

	private void setCategoria() {
		if (peso < 52.2) {
			this.categoria = Categoria.Inválido;
		} else if (this.peso <= 70.3) {
			this.categoria = Categoria.Leve;
		} else if (this.peso <= 83.9) {
			this.categoria = Categoria.Médio;
		} else if (this.peso <= 150.2) {
			this.categoria = Categoria.Pesado;
		} else
			this.categoria = Categoria.Inválido;

	}

	public Luta(Lutador desafiante, Lutador desafiado, Juiz juiz, float comissaoJuiz, double premioDaLuta,
			boolean considerarNumeroDeEspectadores, double bonusDoLutadorEspectadores, float bonusDoJuizEspectadores) {
		this.desafiante = desafiante;
		this.desafiado = desafiado;
		this.juiz = juiz;
		this.comissaoJuiz = comissaoJuiz;
		this.premioDaLuta = premioDaLuta;
		this.considerarNumeroDeEspectadores = considerarNumeroDeEspectadores;
		this.bonusDoLutadorEspectadores = bonusDoLutadorEspectadores;
		this.bonusDoJuizEspectadores = bonusDoJuizEspectadores;
	}

	public void agendarLuta() {
		if ((desafiante.getCategoria() == desafiado.getCategoria()) && (desafiante != desafiado) && (juiz != null)) {
			System.out.println("Luta marcada!");
			System.out.println("Entre: " + desafiante.getNome() + " e " + desafiado.getNome() + " Presidida pelo juiz: "
					+ juiz.getNome());
			this.aprovada = true;
		} else {
			System.out.println(" A luta não pode ser marcada. ");
			this.aprovada = false;
		}
	}

	public void lutar() {
		Random random = new Random();
		int numeroDeEspectadores = random.ints(0, 2000000).findFirst().getAsInt();
	
		if (this.aprovada) {
			System.out.println("O juiz: " + juiz.getNome() + " apresenta os lutadores: " + desafiante.getNome() + " e "
					+ desafiado.getNome());
			System.out.println("No lado esquerdo, temos o desafiante: ");
			desafiante.status();
			System.out.println(" No lado direito, temos o desafiado: ");
			desafiado.status();

			
			int aleatorio = random.ints(0, 2).findFirst().getAsInt();
			juiz.realizarLutas(this);

			switch (aleatorio) {
			case 0:
				System.out.println("Luta empatada");
				desafiante.empatarLuta((premioDaLuta / 2) + (bonusDoLutadorEspectadores));
				desafiado.empatarLuta(premioDaLuta / 2 + (bonusDoLutadorEspectadores));
//				System.out.println(this.getPremioDoLutador() + "Premio recebido");
				System.out.println("O valor do prêmio de cada lutador é: " + getDividirPremio());
				if (considerarNumeroDeEspectadores) {
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(bonusDoJuizEspectadores, numeroDeEspectadores, this));
				} else {
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(this));
			}
				break;
			case 1:
				if (considerarNumeroDeEspectadores) {
					desafiante.ganharLuta(numeroDeEspectadores, premioDaLuta);
					desafiado.perderLuta();
					System.out.println("O vencedor é " + desafiante.getNome() + " e recebeu o prêmio de: " + getPremioDaLuta());
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(bonusDoJuizEspectadores, numeroDeEspectadores, this));
				} else {
					desafiante.ganharLuta(premioDaLuta);
					desafiado.perderLuta();
					System.out.println("O vencedor é " + desafiante.getNome() + " e recebeu o prêmio de: " + getPremioDaLuta());
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(this));
				}
				break;
			case 2:
				if (considerarNumeroDeEspectadores) {
					desafiado.ganharLuta(numeroDeEspectadores, premioDaLuta);
					desafiante.perderLuta();
					System.out.println("O vencedor é: " + desafiado.getNome() + " e recebeu o prêmio de: " + getPremioDaLuta());
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(bonusDoJuizEspectadores, numeroDeEspectadores, this));
				} else {
					desafiado.ganharLuta(premioDaLuta);
					desafiante.perderLuta();
					System.out.println("O vencedor é: " + desafiado.getNome() + " e recebeu o prêmio de: " + getPremioDaLuta());
					System.out.println("O valor da comissão do juiz é de: " + this.juiz.comissaoJuiz(this));
				}
				break;
			}
		} else {
			System.out.println("Luta não aprovada");
		}
	}

//	public void lutar(int numeroDeEspectadores) {
//		System.out.println("O número de espectadores é: " + numeroDeEspectadores);
//		if (numeroDeEspectadores <= 500) {
//			if ((numeroDeEspectadores >= 501) && (numeroDeEspectadores <= 2000)) {
//			}
//		} else {
//		}
////		return numeroDeEspectadores;
//	}
//
//	

	public double getDividirPremio() {
		double dividirPremio = (premioDaLuta / 2) + (bonusDoLutadorEspectadores);
		return dividirPremio;
	}

	public double comissaoJuiz() {

		if (lutaRealizada = true) {
			premioDoJuiz = (float) ((premioDaLuta * (comissaoJuiz / 100))+(bonusDoJuizEspectadores));
//			System.out.println("O valor da comissão do juiz é de: " + premioDoJuiz);
		}
		double premioDoJuizConvertido = (double) premioDoJuiz;
		return premioDoJuizConvertido;
	}

	public boolean isLutaRealizada() {
		return lutaRealizada;
	}

	public void setLutaRealizada(boolean lutaRealizada) {
		this.lutaRealizada = lutaRealizada;
	}

	public double getPremioDoLutador() {
		return premioDoLutador;
	}

	public void setPremioDoLutador(double premioDoLutador) {
		this.premioDoLutador = premioDoLutador;
	}

	public double getPremioDoJuiz() {
		return premioDoJuiz;
	}

	public void setPremioDoJuiz(double premioDoJuiz) {
		this.premioDoJuiz = premioDoJuiz;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public Lutador getDesafiado() {
		return desafiado;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public double getPremioDaLuta() {
//		this.getPremioDaLuta(premioDaLuta);
		return premioDaLuta;
	}

	public void setPremioDaLuta(double premioDaLuta) {
		this.premioDaLuta = premioDaLuta;
	}

	private void setComissaoJuiz(float comissaoJuiz) {
		if (lutaRealizada = true) {
			premioDoJuiz = (float) ((premioDaLuta * (comissaoJuiz / 100)) + (bonusDoJuizEspectadores));
			System.out.println("O valor do prêmio do juiz é de: " + premioDoJuiz);
			
		}
		this.comissaoJuiz = comissaoJuiz;
	}

	public float getComissaoJuiz() {
		// usuário tem que digitar
		return comissaoJuiz;

	}

	public double getMediaComissoesJuiz() {
		// média das comissões é a soma de todas as comissões dividida pela quantidade
		// de comissões ganhas

		return mediaComissoesJuiz;
	}

	public void setMediaComissoesJuiz(double mediaComissoesJuiz) {
		this.mediaComissoesJuiz = mediaComissoesJuiz;
	}

	public boolean isConsiderarNumeroDeEspectadores() {
//		System.out.println("O número de espectadores é: " + numeroDeEspectadores);
//		if (numeroDeEspectadores <= 500) {
//			if((numeroDeEspectadores >= 501) && (numeroDeEspectadores <=2000)) {
//			}
//		} else {
//		}
//		this.lutar(numeroDeEspectadores);
		return considerarNumeroDeEspectadores;
	}

	public void setConsiderarNumeroDeEspectadores(boolean considerarNumeroDeEspectadores) {
		this.considerarNumeroDeEspectadores = considerarNumeroDeEspectadores;
	}

	public double getBonusDoLutadorEspectadores() {
		return bonusDoLutadorEspectadores;
	}

	public void setBonusDoLutadorEspectadores(double bonusDoLutadorEspectadores) {
		this.bonusDoLutadorEspectadores = bonusDoLutadorEspectadores;
	}

	public double getBonusDoJuizEspectadores() {
		return bonusDoJuizEspectadores;
	}

	public void setBonusDoJuizEspectadores(float bonusDoJuizEspectadores) {
		this.bonusDoJuizEspectadores = bonusDoJuizEspectadores;
	}

}

//	public void getPremioDaLuta(double premioDaLuta) {
// usuário tem que digitar
//		System.out.println("Digite o prêmio da luta: " + premioDaLuta);
//		this.premioDaLuta = premioDaLuta;
//		if (this.realizada) {
//			int premioRealizado = 0;
//			switch (premioRealizado) {
//			case 0:
//				System.out.println("Luta empatada entre desafiante: " + desafiante.getNome() + " e desafiado: " + desafiado.getNome() + " .Cada um recebeu metade do valor do prêmio: " + getPremioDaLuta());
//				desafiante.empatarLuta();
//				desafiado.empatarLuta();
//				getPremioDaLuta(premioDaLuta/2);
//				break;
//			case 1:
//				System.out.println("O vencedor é " + desafiante.getNome() + " que recebeu o prêmio total da luta: " + getPremioDaLuta());
//				desafiante.ganharLuta();
//				desafiado.perderLuta();
//				getPremioDaLuta(premioDaLuta);
//				break;
//			case 2:
//				System.out.println("O vencedor é " + desafiado.getNome() + " que recebeu o prêmio total da luta: " + getPremioDaLuta());
//				desafiado.ganharLuta();
//				desafiante.perderLuta();
//				getPremioDaLuta(premioDaLuta);
//				break;
//
//			}
//		}
//	}