import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Jogador jogador1 = new Jogador("Gabriel", 1);
		Jogador jogador2 = new Jogador("Matheus", 2);
		
		Partida partida = new Partida(jogador1, jogador2);
		
		for(int i = 0; i < 20; i++) {
			System.out.println(partida.toString());
			System.out.print("Informe o valor de X: ");
			int x = entrada.nextInt();
			System.out.print("Informe o valor de Y: ");
			int y = entrada.nextInt();
			partida.fazerJogada(x, y);
		}
		
		entrada.close();
	}

}
