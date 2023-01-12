public class Peca {

	private String valor;
	private boolean estadoDeVisibilidade;
	
	public Peca(String valor) {
		this.valor = valor;
		this.estadoDeVisibilidade = false;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public boolean isEstadoDeVisibilidade() {
		return estadoDeVisibilidade;
	}

	public void setEstadoDeVisibilidade(boolean estadoDeVisibilidade) {
		this.estadoDeVisibilidade = estadoDeVisibilidade;
	}
}
