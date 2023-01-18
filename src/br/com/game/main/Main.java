package br.com.game.main;
import java.util.Scanner;

import br.com.game.jogador.Jogador;
import br.com.game.partida.Partida;

public class Main {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Jogador jogadores[] = new Jogador[2];
		
		for(int i = 0; i < jogadores.length; i++) {
			System.out.print("Informe o nome do Jogador " + (i+1) + ": ");
			jogadores[i] = new Jogador(entrada.nextLine(), (i+1));
		}
		
		Partida partida = new Partida(jogadores[0], jogadores[1]);
		
		boolean segundaJogada = false;
		
		while(partida.fimDeJogo()) {
			System.out.println(partida.toString());
			
			if(segundaJogada) {
				if(partida.ehIgual()) {
					System.out.println("O jogador de nome " + partida.getJogadorAtual().getNome() + " acertou!");
					partida.setQtdParesRevelados(partida.getQtdParesRevelados() + 1);
					partida.getJogadorAtual().setScore(partida.getJogadorAtual().getScore() + 1);
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
				
				if(partida.verificarJogada(x, y))
					segundaJogada = partida.fazerJogada(x, y);
				else
					System.out.println("Jogada Inválida!");
			}
		}
		
		entrada.close();
		
		if(jogadores[0].getScore() == jogadores[1].getScore())
			System.out.println("Empate!");
		else if(jogadores[0].getScore() > jogadores[1].getScore())
			System.out.println("Jogador de nome " + jogadores[0].getNome() + " venceu!");
		else
			System.out.println("Jogador de nome " + jogadores[1].getNome() + " venceu!");
			
	}
}