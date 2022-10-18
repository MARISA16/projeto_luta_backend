
import java.util.Scanner;
import java.util.ArrayList;

public class Programa {
	private static Scanner scanner;
	// private static Luta[] lutasAgendadas = new Luta[10];

	// as 2 ColeçÕEes de array mudaram, são private e static.

	private static ArrayList<Luta> premioDaLuta = new ArrayList<Luta>();
	private static ArrayList<Luta> lutasAgendadas = new ArrayList<Luta>();
	private static ArrayList<Lutador> lutadores = new ArrayList<Lutador>();
	private static ArrayList<Juiz> juizes = new ArrayList<Juiz>();
//	private static ArrayList<Juiz> menuJuizes = new ArrayList<Juiz>();
	private static Luta lutaAgendada;
	private static boolean lutadorDesafiante;
	private static boolean lutadorDesafiado;
	private static boolean lutaEmpatada;
	private static Object lutaPerdida;
	private int numeroDeEspectadores;
	private double bonusDoLutadorEspectadores;
	private float bonusDoJuizEspectadores;
	private static ArrayList<Juiz> juizesCancelados = new ArrayList<Juiz>();

	private static Object juiz;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		Lutador prettyBoy = new Lutador("Pretty Boy", "França", 31, 1.75f, 68.9f, 11, 2, 1, 0);
		Lutador putscript = new Lutador("Putscript", "Brasil", 29, 1.68f, 57.8f, 14, 2, 3, 0);
		Lutador snapshadow = new Lutador("Snapshadow", "EUA", 35, 1.65f, 80.9f, 12, 2, 1, 0);
		Lutador deadCode = new Lutador("Dead Code", "Australia", 28, 1.93f, 81.6f, 13, 0, 2, 0);
		Lutador ufoCobol = new Lutador("UFOCobol", "Brasil", 37, 1.70f, 119.3f, 5, 4, 3, 0);
		Lutador nerdaart = new Lutador("Nerdaart", "EUA", 30, 1.81f, 105.7f, 12, 2, 4, 0);

		// Lutador lutador[] = { prettyBoy, putscript, snapshadow, deadCode, ufoCobol,
		// nerdaart };

		lutadores.add(prettyBoy);
		lutadores.add(putscript);
		lutadores.add(snapshadow);
		lutadores.add(deadCode);
		lutadores.add(ufoCobol);
		lutadores.add(nerdaart);

		Juiz falaMansa = new Juiz("Fala Mansa", "Brasil", 48, 1.35, 20, 150);
		Juiz william = new Juiz("William", "EUA", 35, 1.20, 11, 87);
		Juiz andersonSantos = new Juiz("Anderson Santos", "França", 33, 1.18, 9, 63);
		Juiz marisa = new Juiz("Marisa", "Portugal", 30, 1.19, 8, 58);
		Juiz leandro = new Juiz("Leandro", "Congo", 38, 1.10, 5, 40);
		Juiz eliel = new Juiz("Eliel", "Brasil", 24, 1.30, 7, 100);
		Juiz gabriel = new Juiz("Gabriel", "Guatemala", 30, 1.17, 13, 94);
		Juiz mayra = new Juiz("Mayra", "Alemanha", 35, 1.15, 11, 80);
		Juiz lisleny = new Juiz("Lisleny", "Reino Unido", 35, 1.22, 14, 77);
		Juiz eduardo = new Juiz("Eduardo", "México", 39, 1.16, 16, 68);

		juizes.add(falaMansa);
		juizes.add(william);
		juizes.add(andersonSantos);
		juizes.add(marisa);
		juizes.add(leandro);
		juizes.add(eliel);
		juizes.add(gabriel);
		juizes.add(mayra);
		juizes.add(lisleny);
		juizes.add(eduardo);

// Laço de repetição dos nossos menus. Se a opção do menu principal for = 4,
		// para de repetir.

		int ler = 0;
		do {
			ler = gerarMenuPrincipal();
			switch (ler) {
			case 1:
				consultarLutadores();
				Lutador lutadorSelecionado = selecionarLutador(lutadores);
//				Juiz juizSelecionado = selecionarJuiz(juizes);
				if (lutadorSelecionado != null) {
//				if ((lutadorSelecionado != null) && (juizSelecionado != null)) {
					lutadorSelecionado.status();
//					juizSelecionado.status();
				}
				break;

			case 2:
				adicionarLutadores();
				String nome;
				String pais;
				int idade;
				float altura;
				float peso;
				System.out.println(" Qual é o nome do Lutador?");
				nome = scanner.next();
				System.out.println(" Qual é o pais? ");
				pais = scanner.next();
				System.out.println(" Qual é a idade? ");
				idade = scanner.nextInt();
				System.out.println(" Qual é a altura ");
				altura = scanner.nextFloat();
				System.out.println("Qual é o peso? ");
				peso = scanner.nextFloat();

				Lutador novoLutador = new Lutador(nome, pais, idade, altura, peso, 0, 0, 0, 0);
				lutadores.add(novoLutador);
				break;

			case 3:
				juizes();
				break;
//				menuJuizes();
//				System.out.println(gerarMenuJuiz());

			case 4:
				agendarLutas(lutadores, juizes);
//				double premioDaLuta;
//				double premioDoLutador;
//				float comissaoJuiz;
//				double premioDoJuiz;
//				boolean lutaRealizada;
//				System.out.println("Digite o valor do prêmio: ");
//				premioDaLuta = scanner.nextDouble();
//				System.out.println("Digite o percentual da comissão: ");
//				comissaoJuiz = scanner.nextFloat();
//				System.out.println("Luta agendada com sucesso: " + lutasAgendadas.size());

//				if(lutaRealizada = true) {
//					premioDoJuiz = (float) (premioDaLuta*(comissaoJuiz/100));
//					System.out.println("O valor do prêmio do juiz é de: " + premioDoJuiz);
//					if(lutadorDesafiante) {
//						premioDoLutador = (premioDaLuta - premioDoJuiz);{
//							
//						} if(lutadorDesafiado) {
//							premioDoLutador = (premioDaLuta - premioDoJuiz);{
//								
//							}if (lutaEmpatada){
//								premioDoLutador = ((premioDaLuta - premioDoJuiz)/2);
//							}
//						}
//					}
//				}
				break;

			case 5:
				consultarAgendamentos();
				break;

			case 6:
				realizarLutas();
				break;

			}

		} while (ler != 7);

	}
//private static void consultarLutadores() {
//		Lutador status = null;
//		System.out.println(status.getStatus());
//		
//	}

	private static int juizes() {
		int lerDois = 0;
		do {
			lerDois = gerarMenuJuiz();
			switch (lerDois) {
			case 1:
				cadastrarJuizes();

				break;
			case 2:
				removerJuizes();

				break;
			case 3:
				consultarJuizes();

				break;
//			case 4:
//				retornarMenuPrincipal();
//				System.out.print(gerarMenuPrincipal());
//				break;
//			}
			}
		} while (lerDois != 4);
//		break;

		return 0;
	}

	private static void cadastrarJuizes() {
//		System.out.println("Cadastrando juiz.");

		System.out.println(" Qual é o nome do Juiz?");
		String nomeJuiz = scanner.next();
		System.out.println(" Qual é o pais? ");
		String paisJuiz = scanner.next();
		System.out.println(" Qual é a idade? ");
		int idadeJuiz = scanner.nextInt();
		System.out.println("Digite a comissão ");
		double comissaoJuiz = scanner.nextDouble();
		System.out.println("Digite os anos de experiência ");
		int anosDeExperiencia = scanner.nextInt();
		System.out.println("Digite as lutas realizadas ");
		int lutasRealizadas = scanner.nextInt();

		Juiz novoJuiz = new Juiz(nomeJuiz, paisJuiz, idadeJuiz, comissaoJuiz, anosDeExperiencia, lutasRealizadas);

		if (podeAdicionarJuiz(novoJuiz)) {
			juizes.add(novoJuiz);
			System.out.println("Juiz " + novoJuiz.getNome() + " adicionado com sucesso. ");
		} else {
			System.out.println("Não foi possível adicionar este juiz, pois já temos o mesmo com essas características");
		}
	}

	private static boolean podeAdicionarJuiz(Juiz verificarJuiz) {
		for (int i = 0; i < juizes.size(); i++) {
			if ((juizes.get(i).getNome().equals(verificarJuiz.getNome()))
					&& (juizes.get(i).getNacionalidade().equals(verificarJuiz.getNacionalidade()))
					&& (juizes.get(i).getIdade() == verificarJuiz.getIdade())) {
				return false;
			}
		}
		return true;
	}

	private static void removerJuizes() {
		System.out.println("------------------------------------");
		System.out.println("Escolha o juiz que deseja remover: ");
		System.out.println("------------------------------------");
		for (int i = 0; i < juizes.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + juizes.get(i).getNome());
		}
		int resposta = scanner.nextInt();
		Juiz juiz = juizes.get(resposta - 1);
		if (!podeRemoverJuiz(juiz)) {

			juizesCancelados.add(juizes.get(resposta - 1));
			juizes.remove(resposta - 1);
			System.out.println("Juiz " + juiz.getNome() + " foi removido com sucesso.");
		} else {
			System.out.println("O juiz não pode ser removido, pois está cadastrado para realizar uma luta.");
		}
	}

	private static boolean podeRemoverJuiz(Juiz removerJuiz) {
		for (int i = 0; i < lutasAgendadas.size(); i++) {
			if (lutasAgendadas.get(i).getJuiz() == removerJuiz) {
				return true;
			}
		}
		return false;
	}

	private static void consultarJuizes() {
//		Juiz juizSelecionado = selecionarJuiz(juizes);
//		if (juizSelecionado != null) {
//		if ((lutadorSelecionado != null) && (juizSelecionado != null)) {
//			juizSelecionado.status();
//			juizSelecionado.status();
//		}
		for (int i = 0; i < juizes.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + juizes.get(i).getNome());
		}
		int resposta = scanner.nextInt();
		Juiz juizSelecionado = juizes.get(resposta - 1);
		System.out.println("------------------------------------------------------------------");
		System.out.println("Exibindo dados de juiz: ");
		System.out.println("Nome: " + juizSelecionado.getNome());
		System.out.println("Idade: " + juizSelecionado.getIdade());
		System.out.println("Nacionalidade: " + juizSelecionado.getNacionalidade());
		System.out.println("Quantidade de lutas já realizadas: " + juizSelecionado.getLutasRealizadas());
		System.out.println("Anos de experiência do juiz: " + juizSelecionado.getAnosDeExperiencia());
		System.out.println("Total de comissão recebida: " + juizSelecionado.getComissao());
		System.out.println("Média das comissões: ");
		System.out.println("Dados das lutas já realizadas: ");
		System.out.println("----------------------------------------------------------------");
		for (int i = 0; i < juizSelecionado.getLutasRealizadasJuiz().size(); i++) {
			Luta lutas = juizSelecionado.getLutasRealizadasJuiz().get(i);

			System.out.println("Lutador desafiante: ");
			lutas.getDesafiante().status();
			System.out.println("Lutador desafiado: ");
			lutas.getDesafiado().status();
			System.out.println("O juiz que presidiu a luta foi: ");
//			juizSelecionado.getLutasRealizadasJuiz().get(i);
			System.out.println("O prêmio da luta é: " + lutas.getPremioDaLuta());
//			System.out.println("O prêmio do juiz é: " + lutas.comissaoJuiz());
			System.out.println("Deseja considerar o número dos expectadores na distribuição dos prêmios? " + lutas.isConsiderarNumeroDeEspectadores());
		}

	}

	private static int retornarMenuPrincipal() {

		return 0;
	}

	private static void adicionarLutadores() {
		// TODO Auto-generated method stub

	}

	private static void consultarLutadores() {
		// TODO Auto-generated method stub

	}

	// Adicionando lutador e consultando agendmento!
	private static int gerarMenuPrincipal() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1- Consultar dados dos lutadores");
		System.out.println("2- Adicionar Lutador ");
		System.out.println("3- Juízes");
		System.out.println("4- Agendar Lutas");
		System.out.println("5- Consultar Lutas Agendadas");
		System.out.println("6- Realizar Lutas");
		System.out.println("7- Sair");
		return scanner.nextInt();
	}

	private static int gerarMenuJuiz() {
		System.out.println("MENU DE JUIZES");
		System.out.println("1- Cadastrar novo Juiz");
		System.out.println("2- Remover Juiz cadastrado");
		System.out.println("3- Consultar dados do Juiz");
		System.out.println("4- Retornar ao Menu Principal");
		return scanner.nextInt();
	}

	private static void consultarAgendamentos() {
		// o array.lenght chama o numero final do vetor
		// arraylist usa o size

		for (int i = 0; i < lutasAgendadas.size(); i++) {

			// array[i] le o que esta dentro do colchete

			Luta luta = lutasAgendadas.get(i);
			System.out.println("Lutador desafiante: " + luta.getDesafiante().getNome() + " X " + " Lutador desafiado: "
					+ luta.getDesafiado().getNome());

			System.out.println("Luta presidida pelo juiz: " + luta.getJuiz().getNome());

		}
	}

	private static Lutador listarLutadores(java.util.ArrayList<Lutador> lutador) {
		int i;
		for (i = 0; i < lutador.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + lutador.get(i).getNome());
		}
		System.out.println("[" + (i + 1) + "] Sair");
		return null;
	}

	private static Juiz listarJuizes(java.util.ArrayList<Juiz> juiz) {
		int i;
		for (i = 0; i < juiz.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + juiz.get(i).getNome());
		}
		System.out.println("[" + (i + 1) + "] sair.");
		int opcaoJuiz = scanner.nextInt();
//		Juiz juizSelecionado = null;
//		if (opcaoJuiz >= 1 && opcaoJuiz <= juiz.size()) {
//			System.out.println("Você escolheu o lutador: " + juiz.get(opcaoJuiz - 1).getNome());
//			juizSelecionado = juiz.get(opcaoJuiz - 1);
//		} else if (opcaoJuiz == (juiz.size() + 1)) {
//			System.out.println("Finalizando");
//		} else {
//			System.out.println("Opção Inválida!!");
//		}
//		return juizSelecionado;
		return juiz.get(opcaoJuiz - 1);
	}

	private static void agendarLutas(ArrayList<Lutador> lutador, ArrayList<Juiz> juiz) {
		Lutador lutadorDesafiante, lutadorDesafiado;
		Juiz escolherJuiz;
		Luta lutaAgendada;
		int numeroDeEscolha;
		double bonusDoLutadorEspectadores = 0;
		float bonusDoJuizEspectadores = 0;
		System.out.println("Bem-vindo ao agendamento de lutas!");
		System.out.println("Escolha o desafiante: ");
		lutadorDesafiante = selecionarLutador(lutador);
		if (lutadorDesafiante != null) {
			System.out.println("Escolha o desafiado: ");
			lutadorDesafiado = selecionarLutador(lutador);
			if (lutadorDesafiado != null) {
				System.out.println("Escolha o juiz: ");
				escolherJuiz = listarJuizes(juiz);
				if (escolherJuiz != null) {

					double premioDaLuta;
					float comissaoJuiz;
					System.out.println("Digite o valor do prêmio: ");
					premioDaLuta = scanner.nextDouble();
					System.out.println("Digite o percentual da comissão: ");
					comissaoJuiz = scanner.nextFloat();
					System.out.println("Digite se deseja considerar o numero dos expectadores na distribuição dos prêmios (1 - Sim / 2 - Não): ");
					numeroDeEscolha = scanner.nextInt();
					boolean autorizarDistribuicaoPremios = false;
					switch (numeroDeEscolha) {
					case 1:
						autorizarDistribuicaoPremios = true;
						break;
					case 2:
						autorizarDistribuicaoPremios = false;
						break;
					default:
						System.out.println("Opção inválida!");
					}
					lutaAgendada = new Luta(lutadorDesafiante, lutadorDesafiado, escolherJuiz, comissaoJuiz,
							premioDaLuta, autorizarDistribuicaoPremios, bonusDoLutadorEspectadores, bonusDoJuizEspectadores);
					lutaAgendada.agendarLuta();
					lutasAgendadas.add(lutaAgendada);
					System.out.println("Luta agendada com sucesso: " + lutasAgendadas.size());
				}
			}
		}

	}

	private static void realizarLutas() {
		boolean lutaEncontrada = false;
		for (int i = 0; i < lutasAgendadas.size(); i++) {
			Luta lutaAgendada = lutasAgendadas.get(i);

			if (lutaAgendada != null) {
				lutaAgendada.lutar();
				lutaEncontrada = true;
			}

		}
		if (!lutaEncontrada) {
			System.out.println("Não há lutas agendadas.");
		} else {
			lutasAgendadas = new ArrayList<Luta>();
		}
	}

	private static Juiz selecionarJuiz(ArrayList<Juiz> juiz) {
		int opcaoJuiz;
		Juiz juizSelecionado = null;
		do {
			listarJuizes(juiz);
			System.out.println("De qual juiz você deseja ver os atributos?");
			opcaoJuiz = scanner.nextInt();
			if (opcaoJuiz >= 1 && opcaoJuiz <= juiz.size()) {
				System.out.println("Você escolheu o juiz: " + juiz.get(opcaoJuiz - 1).getNome());
				juizSelecionado = juiz.get(opcaoJuiz - 1);
				break;
			} else if (opcaoJuiz == (juiz.size() + 1)) {
				System.out.println("Finalizando");
			} else {
				System.out.println("Opção inválida!");
			}
		} while (opcaoJuiz != juiz.size() + 1);

		return juizSelecionado;
	}

	private static Lutador selecionarLutador(ArrayList<Lutador> lutador) {
		int opcaoLutador;
		Lutador lutadorSelecionado = null;
		do {
			listarLutadores(lutador);

			System.out.println("De qual lutador você deseja ver os atributos?");
			opcaoLutador = scanner.nextInt();

			if (opcaoLutador >= 1 && opcaoLutador <= lutador.size()) {
				System.out.println("Você escolheu o lutador: " + lutador.get(opcaoLutador - 1).getNome());
				lutadorSelecionado = lutador.get(opcaoLutador - 1);
				break;
			} else if (opcaoLutador == (lutador.size() + 1)) {
				System.out.println("Finalizando");
			} else {
				System.out.println("Opção Inválida!!");
			}

		} while (opcaoLutador != lutador.size() + 1);
		return lutadorSelecionado;
	}
}