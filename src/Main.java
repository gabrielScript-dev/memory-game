import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Jogador jogador1 = new Jogador("Gabriel", 1);
		Jogador jogador2 = new Jogador("Matheus", 2);
		
		Partida partida = new Partida(jogador1, jogador2);
		
		boolean segundaJogada = false;
		
		while(partida.getQtdParesRevelados() <= 8) {
			System.out.println(partida.toString());
			
			if(segundaJogada) {
				if(partida.verificarJogada()) {
					System.out.println("O jogador de nome " + partida.getJogadorAtual().getNome() + " acertou!");
					partida.setQtdParesRevelados(1);
					partida.getJogadorAtual().setScore(1);
				} else {
					System.out.println("O jogador de nome " + partida.getJogadorAtual().getNome() + " errou!");
					partida.trocarJogador();
				}
				segundaJogada = false;
			} else {
				System.out.print("Informe o valor de X: ");
				int x = entrada.nextInt();
				System.out.print("Informe o valor de Y: ");
				int y = entrada.nextInt();
				
				segundaJogada = partida.fazerJogada(x, y);
			}
		}
		
		entrada.close();
	}
}