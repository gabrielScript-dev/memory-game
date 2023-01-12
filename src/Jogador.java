public class Jogador extends Pessoa {
	
	private int id;
	private int score;
	
	public Jogador(String nome, int id) {
		super(nome);
		this.id = id;
		this.score = 0;
	}
	
	@Override
	public String toString() {
		return "O jogador " + this.id + " é " + this.getNome();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
