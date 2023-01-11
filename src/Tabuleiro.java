import java.util.Random;

public class Tabuleiro {

	private String[][] tabuleiro;
	
	private String[] vetorRandom() {
		String[] vetor = {"A", "B", "C", "D"};
		Random random = new Random();
		
		for(int i = 0; i < vetor.length; i++) {
			String aux = vetor[i];
			int posicaoRandom = random.nextInt(vetor.length-1);
			vetor[i] = vetor[posicaoRandom];
			vetor[posicaoRandom] = aux;
		}
		
		return vetor;
	}
	
	private void iniciarTabuleiro() {
		for(int m = 0; m < 4; m++) {
			String[] vetorRandom = vetorRandom();
			for(int n = 0; n < 4; n++) {
				this.tabuleiro[m][n] = vetorRandom[n];
				System.out.print(this.tabuleiro[m][n] + " ");
			}
			
			System.out.println();
		}
	}
	
	private static String peca1 = "";
	private static boolean controleDeJogada = false;
	public boolean fazerJogada(int x, int y) {
		boolean retorno = false;
		
		if(!controleDeJogada) {
			peca1 = this.tabuleiro[x][y];
			controleDeJogada = true;
		} else {
			String peca2 = this.tabuleiro[x][y];
			
			if(peca1.equals(peca2)) {
				System.out.println("Acertou!");
				retorno = true;
			} else
				System.out.println("Errou!");
			
			controleDeJogada = false;
		}
		
		return retorno;
	}
	
	public Tabuleiro() {	
		this.tabuleiro = new String[4][4];
		this.iniciarTabuleiro();
	}
	
	public String[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	

}
