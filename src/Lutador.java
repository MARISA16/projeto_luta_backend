
import java.util.Random;

public class Lutador extends Pessoa{
	
//	private String status;
	private String nome;
	private String nacionalidade;
	private int idade;
	private float altura;
	private float peso;
	private Categoria categoria;
	private int vitoria;
	private int derrota;
	private int empate;
	private double totalPremios;

	
	public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitoria, int derrota, int empate, double totalPremios) {
		super(nome, nacionalidade, idade);
		//this.nome = nome;
		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setIdade(idade);
		this.setAltura(altura);
		this.setPeso(peso);
		this.setVitoria(vitoria);
		this.setDerrota(derrota);
		this.setEmpate(empate);
		this.setTotalPremios(totalPremios);
	}
	public void apresentar() {
		System.out.println("Lutador: " + this.getNome());
		System.out.println("Nacionalidade: " + this.nacionalidade);
		System.out.println("Idade: " + this.idade);
		System.out.println("Altura: " + this.altura);
		
	}
	public void status() {
		System.out.println("--------------------------------------");
		System.out.println("Lutador: " + this.getNome());
		System.out.println("Nacionalidade: " + this.nacionalidade);
		System.out.println("Idade: " + this.idade);
		System.out.println("Altura: " + this.altura);
		System.out.println("Peso: " + this.peso);
		System.out.println("Categoria: " + this.categoria);
		System.out.println("Vitórias: " + this.vitoria);
		System.out.println("Derrotas: " + this.derrota);
		System.out.println("Empates: " + this.empate);
		System.out.println("Total de prêmios: " + this.totalPremios);
		System.out.println("--------------------------------------");
//		this.setStatus(this.getStatus());
//		this.status();
	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	public void ganharLuta(double premio) {
		System.out.println("Ganhando luta");
		this.setVitoria(this.getVitoria()+1);
		this.setTotalPremios(this.getTotalPremios() + premio);
		this.status();
	}
	
	
	public void ganharLuta(int numeroDeEspectadores, double premioDaLuta) {

		double bonusDoLutadorEspectadores = 0;
		if (numeroDeEspectadores <= 500) {
			switch (this.categoria) {
			case Leve:
				bonusDoLutadorEspectadores =  premioDaLuta * 1.05;
				break;
			case Médio:
				bonusDoLutadorEspectadores = premioDaLuta * 1.08;
				break;
			case Pesado:
				bonusDoLutadorEspectadores = premioDaLuta * 1.10;
				break;
			}
		} else if (numeroDeEspectadores >= 501 && numeroDeEspectadores <= 2000) {
			switch (this.categoria) {
			case Leve:
				bonusDoLutadorEspectadores = premioDaLuta * 1.08;
				break;
			case Médio:
				bonusDoLutadorEspectadores = premioDaLuta * 1.12;
				break;
			case Pesado:
				bonusDoLutadorEspectadores = premioDaLuta * 1.15;
				break;
			}
		} else {
			switch (this.categoria) {
			case Leve:
				bonusDoLutadorEspectadores = premioDaLuta * 1.10;
				break;
			case Médio:
				bonusDoLutadorEspectadores = premioDaLuta * 1.15;
				break;
			case Pesado:
				bonusDoLutadorEspectadores = premioDaLuta * 1.18;
				break;
			}

		}
		ganharLuta(bonusDoLutadorEspectadores);
//		return bonusDoLutadorEspectadores;
	}

	
	
	public void perderLuta() {
		System.out.println("Perdeu luta");
		this.derrota++;
		this.status();
	}
	public void empatarLuta(double premio) {
		System.out.println("Empatou");
		this.empate = this.empate + 1;
		this.setTotalPremios(this.getTotalPremios() + premio);
		this.status();
	}
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
		this.setCategoria();
	}
	public Categoria getCategoria() {
		return categoria;
	}
	private void setCategoria() {
//		if(this.getPeso()<52.2) {
//			this.categoria = Categoria.Inválido;
//		}else if(this.getPeso()<=70.3) {
//			this.categoria = Categoria.Inválido;
//		}
			if (peso < 52.2) {
				this.categoria = Categoria.Inválido;
			}else if(this.peso <= 70.3) {
				this.categoria = Categoria.Leve;
			}else if(this.peso <= 83.9) {
				this.categoria = Categoria.Médio;
			}else if(this.peso <= 150.2) {
				this.categoria = Categoria.Pesado;
			}else
				this.categoria = Categoria.Inválido;
		
	}
	public int getVitoria() {
		return vitoria;
	}
	public void setVitoria(int vitoria) {
		this.vitoria = vitoria;
	}
	public int getDerrota() {
		return derrota;
	}
	public void setDerrota(int derrota) {
		this.derrota = derrota;
	}
	public int getEmpate() {
		return empate;
	}
	public void setEmpate(int empate) {
		this.empate = empate;
	}
	public double getTotalPremios() {
		return totalPremios;
	}
	public void setTotalPremios(double totalPremios) {
		this.totalPremios = totalPremios;
	}
	
	
	
}
