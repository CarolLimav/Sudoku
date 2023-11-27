package sudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SudokuMain extends JFrame {
		private static final long serialVersionUID = 1L;  // to prevent serial warning
	   // private variables
	   GameBoardPanel board = new GameBoardPanel();
	   JButton btnNewGame = new JButton("NOVO JOGO");
	   static String[] niveis = {"Fácil", "Médio", "Dificil"};
	   JComboBox<String> comboBox = new JComboBox<>(niveis);
	   
	   // Constructor
	   public SudokuMain() {
	      Container cp = getContentPane();
	      cp.setLayout(new BorderLayout());

	      cp.add(board, BorderLayout.CENTER);
	      JPanel panel = new JPanel();
	      panel.add(new JLabel("Escolha o Nível: "));
	      cp.add(comboBox, BorderLayout.NORTH); 
	      // Add a button to the south to re-start the game via board.newGame()
	      // ......
	      
	      // Initialize the game board to start the game
	       btnNewGame.addActionListener((ActionListener) new ActionListener() {
	    	    public void actionPerformed(ActionEvent e) {
	    	    	Level level = null;
	    	    	String nivel = (String) comboBox.getSelectedItem(); 
	    	    	if(nivel.equals("Fácil")) {
	    	    	level = Level.facil; 
	    	    	}
	    	    	if(nivel.equals("Médio")) {
		    	    	level = Level.medio; 
		    	    	}
	    	    	if(nivel.equals("Dificil")) {
		    	    	level = Level.dificil; 
		    	    	}
	    	    	board.newGame(level);  //método newGame() para quando o botão for clicado
	    	    	
	    	    }
	    	});
	     cp.add(btnNewGame, BorderLayout.SOUTH);
	     board.newGame(Level.dificil); 

	      pack();     // Pack the UI components, instead of using setSize()
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
	      setTitle("Sudoku");
	      setVisible(true);
	   }

	   /** The entry main() entry method */
	   public static void main(String[] args) {
	      // [TODO 1] Check "Swing program template" on how to run
	      //  the constructor of "SudokuMain"
	      // .........
		   SudokuMain sudokuApp = new SudokuMain();
		      
		      
		      
		      // Tornar a janela visível
		      sudokuApp.setVisible(true);
	   }

}
