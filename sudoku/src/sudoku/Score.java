package sudoku;

public class Score {
	private static int pontos;

	private Score() {
//		super();
//		this.pontos = pontos;
	}

	public static int getPontos() {
		return pontos;
	}

//	public void setPontos(int pontos) {
//		this.pontos = pontos;
//	}
	public static void acertouCelula() {
	       
        pontos += 15;
        SudokuMain.getInstance().updateScoreLabel(); 
    }

	public static void resetScore() {
		pontos = 0;  
		SudokuMain.getInstance().updateScoreLabel(); 
	}
}
