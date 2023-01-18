package br.com.game.tabuleiro;
import java.util.Random;

public class Tabuleiro {

	private Peca[][] tabuleiro;
	private Peca[] pecasJogadas;
	
	public Tabuleiro() {	
		this.tabuleiro = new Peca[4][4];
		this.pecasJogadas = new Peca[2];
		this.iniciarTabuleiro();
	}
	
	/*private static Peca[] vetorRandom() {
		Peca[] vetor = {new Peca("A"), new Peca("B"), new Peca("C"), new Peca("D")};
		Random random = new Random();
		
		for(int i = 0; i < vetor.length; i++) {
			Peca aux = vetor[i];
			int posicaoRandom = random.nextInt(vetor.length-1);
			vetor[i] = vetor[posicaoRandom];
			vetor[posicaoRandom] = aux;
		}
		
		return vetor;
	}
	
	private void iniciarTabuleiro() {
		for(int m = 0; m < this.tabuleiro.length; m++) {
			Peca[] vetorRandom = vetorRandom();
			for(int n = 0; n < this.tabuleiro.length; n++) {
				this.tabuleiro[m][n] = vetorRandom[n];
			}
		}
	}*/
	
	private void iniciarTabuleiro() {
		String[] vetor = {"A", "B", "C", "D"};
		Random random = new Random();
		
		int i;
		
		for(String str : vetor) {
			for(i = 0; i < 4; i++) {
				while(true) {
					int x = random.nextInt(4);
					int y = random.nextInt(4);
					
					if(this.tabuleiro[x][y] == null) {
						this.tabuleiro[x][y] = new Peca(str);
						break;
					}
				}
			}
		}
	}
	
	public void virarPecas() {
		this.pecasJogadas[0].setEstadoDeVisibilidade(false);
		this.pecasJogadas[1].setEstadoDeVisibilidade(false);
	}
	
	private boolean controleDeJogada = false;	
	public boolean fazerJogada(int x, int y) {
		if(!controleDeJogada) {
			pecasJogadas[0] = this.tabuleiro[x][y];
			pecasJogadas[0].setEstadoDeVisibilidade(true);
			controleDeJogada = true;
			return false;
		} else {
			pecasJogadas[1] = this.tabuleiro[x][y];
			pecasJogadas[1].setEstadoDeVisibilidade(true);
			controleDeJogada = false;
			return true;
		}
	}
	
	@Override
	public String toString() {
		String tabuleiro = "    (0) (1) (2) (3)\n";		
		for(int m = 0; m < this.tabuleiro.length; m++) {
			tabuleiro += "   |---.---.---.---|\n";
			tabuleiro += "("+m+")";
			for(int n = 0; n < this.tabuleiro.length; n++) {
				Peca pecaAtual = this.tabuleiro[m][n];
				
				if(pecaAtual.isEstadoDeVisibilidade())
					tabuleiro += "| " + pecaAtual.getValor() + " ";
				else
					tabuleiro += "|   ";
				
				if(n == 3)
					tabuleiro += "|";
			}
			
			tabuleiro += "\n";
		}
		tabuleiro += "   |---.---.---.---|\n";
		return tabuleiro;
	}

	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Peca[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Peca[] getPecasJogadas() {
		return pecasJogadas;
	}

	public void setPecasJogadas(Peca[] pecasJogadas) {
		this.pecasJogadas = pecasJogadas;
	}	
}
