import java.util.Random;

public class Tabuleiro {

	private Peca[][] tabuleiro;
	
	public Tabuleiro() {	
		this.tabuleiro = new Peca[4][4];
		this.iniciarTabuleiro();
	}
	
	private static Peca[] vetorRandom() {
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
			//System.out.println("|---.---.---.---|");
			Peca[] vetorRandom = vetorRandom();
			for(int n = 0; n < this.tabuleiro.length; n++) {
				this.tabuleiro[m][n] = vetorRandom[n];
				//System.out.print("| " + this.tabuleiro[m][n].getValor() + " ");
				if(n == 3) {
					//System.out.print("|");
				}
			}
			
			//System.out.println();
		}
		
		//System.out.println("|---.---.---.---|");
	}
	
	@Override
	public String toString() {
		String tabuleiro = "    (0) (1) (2) (3)\n";		
		for(int m = 0; m < this.tabuleiro.length; m++) {
			tabuleiro += "   |---.---.---.---|\n";
			tabuleiro += "(%d)".formatted(m);
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
	private static Peca pecas[] = new Peca[2];
	private static boolean controleDeJogada = false;
	
	
	public boolean verificarJogada() {
		if(pecas[0].getValor().equals(pecas[1].getValor())) {
			System.out.println("Acertou!");
			return true;
		} else {
			System.out.println("Errou!");
			pecas[0].setEstadoDeVisibilidade(false);
			pecas[1].setEstadoDeVisibilidade(false);
			
			return false;
		}
	}
	
	public boolean fazerJogada(int x, int y) {
		boolean retorno = false;
		
		if(!controleDeJogada) {
			pecas[0] = this.tabuleiro[x][y];
			pecas[0].setEstadoDeVisibilidade(true);
			controleDeJogada = true;
			
		} else {
			pecas[1] = this.tabuleiro[x][y];
			pecas[1].setEstadoDeVisibilidade(true);
			
			controleDeJogada = false;
		}
		
		return retorno;
	}
		
	public Peca[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public void setTabuleiro(Peca[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
