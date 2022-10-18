
import java.util.ArrayList;

public class Juiz extends Pessoa {

	double mediaComissoesJuiz;
	String dadosLutasDoJuiz;
	private ArrayList<Luta> lutasRealizadasJuiz = new ArrayList<Luta>();

	double comissao;
	int anosDeExperiencia;
	int lutasRealizadas;
	
	//int colecionarLutas;
	
	public void apresentar() {
		System.out.println("Juiz: " + this.getNome());
		System.out.println("Nacionalidade: " + this.getNacionalidade());
		System.out.println("Idade: " + this.getIdade());
		
	}
	
	public void realizarLutas(Luta luta) {
		lutasRealizadasJuiz.add(luta);
		System.out.println("Presidiu luta ");
		this.setLutasRealizadas(this.getLutasRealizadas()+1);
		this.status();
		
	}
	
	public void status() {
		System.out.println("--------------------------------------");
		System.out.println("Juiz: " + this.getNome());
		System.out.println("Nacionalidade: " + this.getNacionalidade());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("Comissão: " + this.getComissao());
		System.out.println("Anos de experiência: " + this.getAnosDeExperiencia());
		System.out.println("Lutas realizadas: " + this.getLutasRealizadas());
//		System.out.println("Vitórias: " + this.vitoria);
//		System.out.println("Derrotas: " + this.derrota);
//		System.out.println("Empates: " + this.empate);
		System.out.println("--------------------------------------");
	}
	
	public ArrayList<Luta> getLutasRealizadasJuiz() {
		return lutasRealizadasJuiz;
	}
	
	
	public Juiz(String nome, String nacionalidade, int idade, double comissao, int anosDeExperiencia,
			int lutasRealizadas) {
		super(nome, nacionalidade, idade);
		this.comissao = comissao;
		this.anosDeExperiencia = anosDeExperiencia;
		this.lutasRealizadas = lutasRealizadas;
		
	}


	public double comissaoJuiz(Luta luta) {
		double premioDoJuiz = 0;
		if (luta.isLutaRealizada()) {
			premioDoJuiz = (float) ((luta.getPremioDaLuta() * (luta.getComissaoJuiz() / 100))+(luta.getBonusDoJuizEspectadores()));
//			System.out.println("O valor da comissão do juiz é de: " + premioDoJuiz);
		}
		double premioDoJuizConvertido = (double) premioDoJuiz;
		return premioDoJuizConvertido;
	}

	
	
	public double comissaoJuiz(float bonusDoJuizEspectadores, int numeroDeEspectadores, Luta luta) {
	if (numeroDeEspectadores <= 500) {
		bonusDoJuizEspectadores = (float) (comissaoJuiz(luta) + 100);
	} else if (numeroDeEspectadores >= 501 && numeroDeEspectadores <= 2000) {
		bonusDoJuizEspectadores = (float) (comissaoJuiz(luta) + 500);
	} else {
		bonusDoJuizEspectadores = (float) (comissaoJuiz(luta) + 1000);
	}

	return bonusDoJuizEspectadores;
}

	
	

//	public int getColecionar() {
//		return colecionarLutas;
//	}
//	public void setColecionar(int colecionarLutas) {
//		this.colecionarLutas = colecionarLutas;
//	}
	
	
	public double getComissao() {
		return comissao;
	}

//	public double getMediaComissoesJuiz() {
//		//média = soma de todas as comissões ganhas dividida pelo total de comissões
//		return mediaComissoesJuiz;
//	}
//
//	public void setMediaComissoesJuiz(double mediaComissoesJuiz) {
//		this.mediaComissoesJuiz = mediaComissoesJuiz;
//	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}

	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public int getLutasRealizadas() {
		return lutasRealizadas;
	}

	public void setLutasRealizadas(int lutasRealizadas) {
		this.lutasRealizadas = lutasRealizadas;
	}

}