
public class Partida {

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador jogadorAtual;
	private Tabuleiro tabuleiro;

	public Partida(Jogador jogador1, Jogador jogador2) {
		super();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.jogadorAtual = jogador1;
		this.tabuleiro = new Tabuleiro();
	}
	
	private static boolean controleDeJogada = false;
	public void fazerJogada(int x, int y) {
		if(!controleDeJogada) {
			this.tabuleiro.fazerJogada(x, y);
			controleDeJogada = true;
		} else {
			this.tabuleiro.fazerJogada(x, y);
			System.out.print(this.toString());
			
			if(this.tabuleiro.verificarJogada()) {
				jogadorAtual.setScore(this.jogadorAtual.getScore() + 1);
			} else {
				if(this.jogadorAtual.equals(this.jogador1))
					this.jogadorAtual = jogador2;
				else
					this.jogadorAtual = jogador1;
			}
			
			controleDeJogada = false;
		}
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

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}	
}