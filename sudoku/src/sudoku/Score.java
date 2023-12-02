package sudoku;

public class Score {
	private int pontos;

	public Score(int pontos) {
		super();
		this.pontos = pontos;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Score [pontos=" + pontos + "]";
	}
	
	public void qtdPontos() {
		this.pontos = 0; 
	}
}
