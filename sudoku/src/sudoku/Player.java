package sudoku;

public class Player {
	private String nome; 
	private int score; 
	private int tempoJogo;
	
	public Player(String nome, int score, int tempoJogo) {
		super();
		this.nome = nome;
		this.score = score;
		this.tempoJogo = tempoJogo;
	}


	public Player(String nome, int score) {
		super();
		this.nome = nome;
		this.score = score;
	}
	public Player() {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void acertouCelula() {
	       
        score += 15;
 }
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTime() {
		return tempoJogo;
	}
	public void setTime(int tempoJogo) {
		this.tempoJogo = tempoJogo;
	}
	 
	public String toString() {
		return "Jogador: " + nome;
	}
}
