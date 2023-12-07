package sudoku;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Cell extends JTextField {
	 private static final long serialVersionUID = 1L;  // to prevent serial warning
	 
	   // Define named constants for JTextField's colors and fonts
	   //  to be chosen based on CellStatus
	   public static final Color BG_GIVEN = new Color(240, 240, 240); // RGB
	   public static final Color FG_GIVEN = Color.BLACK;
	   public static final Color FG_NOT_GIVEN = Color.GRAY;
	   public static final Color BG_TO_GUESS  = Color.yellow;
	   public static final Color BG_CORRECT_GUESS =  new Color(255, 20, 147);  
	   public static final Color BG_WRONG_GUESS   = new Color(216, 0, 0);
	   public static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);
	   
	  
	   /** The row and column number [0-8] of this cell */ 

	   int row, col;
	   /** The puzzle number [1-9] for this cell */
	   int number;
	   /** The status of this cell defined in enum CellStatus */
	   CellStatus status;

	   /** Constructor */
	   public Cell(int row, int col) {
	      super();   // JTextField
	      this.row = row;
	      this.col = col;
	      // Inherited from JTextField: Beautify all the cells once for all
	      super.setHorizontalAlignment(JTextField.CENTER);
	      super.setFont(FONT_NUMBERS);
	        int topBorder = 0;
	        int leftBorder = 0;
	        int bottomBorder = 0; 
	        int rightBorder = 0; 
	        if(row % 3 == 0) { 
	        	topBorder = 2; 
	        
	        }else {
	        	topBorder = 1; 
	        }
	        if(col % 3 == 0 ) { 
	        	leftBorder = 2; 
	        
	        }else {
	        	leftBorder =  1; 
	        }
	        if((row + 1) % 3 == 0) { 
	        	bottomBorder = 2; 
	        
	        }else {
	        	bottomBorder =  1; 
	        }
	        if ((col + 1) % 3 == 0) {
	        	rightBorder = 2;
	        }else{
	        	rightBorder = 1;
	        }
	        super.setBorder(new MatteBorder(topBorder, leftBorder, bottomBorder, rightBorder, Color.BLACK));
	   }

	   /** Reset this cell for a new game, given the puzzle number and isGiven */
	   public void newGame(int number, boolean isGiven) {
	      this.number = number;
	      status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
	      
	      paint();    // paint itself
	   }

	   /** This Cell (JTextField) paints itself based on its status */
	   public void paint() {
	      if (status == CellStatus.GIVEN) {
	         // Inherited from JTextField: Set display properties
	         super.setText(number + "");
	         super.setEditable(false);
	         super.setBackground(BG_GIVEN);
	         super.setForeground(FG_GIVEN);
	      } else if (status == CellStatus.TO_GUESS) {
	         // Inherited from JTextField: Set display properties
	         super.setText("");
	         super.setEditable(true);
	         super.setBackground(BG_TO_GUESS);
	         super.setForeground(FG_NOT_GIVEN);
	      } else if (status == CellStatus.CORRECT_GUESS) {  // from TO_GUESS
	         super.setBackground(BG_CORRECT_GUESS);
	      } else if (status == CellStatus.WRONG_GUESS) {    // from TO_GUESS
	         super.setBackground(BG_WRONG_GUESS);
	      }
	   }
}
