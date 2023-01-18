package br.com.game.partida;

import br.com.game.jogador.Jogador;
import br.com.game.tabuleiro.Tabuleiro;

public class Partida {

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogadorAtual;
	private Tabuleiro tabuleiro;
	private int qtdParesRevelados;

	public Partida(Jogador jogador1, Jogador jogador2) {
		super();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogadorAtual = jogador1;
		this.qtdParesRevelados = 0;
		this.tabuleiro = new Tabuleiro();
	}
	
	public boolean fimDeJogo() {
		// 8 -> Quantidade total de peças
		return this.qtdParesRevelados < 8;
	}
	
	public boolean ehIgual() {
		return this.tabuleiro.getPecasJogadas()[0].getValor().equals(this.tabuleiro.getPecasJogadas()[1].getValor());
	}
	
	public boolean verificarJogada(int x, int y) {
		return (x < 4 && y < 4) && this.tabuleiro.getTabuleiro()[x][y].isEstadoDeVisibilidade() != true;
	}
	
	public void trocarJogador() {
		if(jogadorAtual.equals(this.jogador1))
			this.jogadorAtual = this.jogador2;
		else
			this.jogadorAtual = this.jogador1;
		
		this.tabuleiro.virarPecas();
	}
	
	public boolean fazerJogada(int x, int y) {
		return this.tabuleiro.fazerJogada(x, y);
	}
	
	@Override
	public String toString() {
		return "\n" + this.tabuleiro.toString() + "\nJogador " + this.jogadorAtual.getId() + " de nome " + this.jogadorAtual.getNome() + " informe sua jogada";
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Jogador getJogadorAtual() {
		return jogadorAtual;
	}

	public void setJogadorAtual(Jogador jogadorAtual) {
		this.jogadorAtual = jogadorAtual;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getQtdParesRevelados() {
		return qtdParesRevelados;
	}

	public void setQtdParesRevelados(int qtdParesRevelados) {
		this.qtdParesRevelados = qtdParesRevelados;
	}
}