package sudoku;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane ;
import javax.swing.border.MatteBorder;
import javax.swing.* ;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
   private static final long serialVersionUID = 1L;  // to prevent serial warning
   private static SudokuMain instance;
   private String playerNome;
   

	// private variables
   GameBoardPanel board = new GameBoardPanel();
   JButton btnIniciarJogo= new JButton("Iniciar Jogo");
   JLabel lblEscolhaONvel = new JLabel("Selecione o nível: ");;
   JComboBox comboBox = new JComboBox();
   JLabel lblNewLabel = new JLabel("SUDOKU");
   JButton btnPausar = new JButton("");
   JButton btnContinuar = new JButton("");
   JButton btnReiniciar = new JButton("Novo Jogo");
   JButton btnSair = new JButton("Sair");
   private final JLabel lblPlayerName = new JLabel("");
   JLabel lblPlayer = new JLabel("Player");
   JButton btnReset = new JButton("Redefinir Jogo");
 
   

   // Constructor
   private SudokuMain() {
	  Player jogador = new Player();
      Container cp = getContentPane();
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);
      cp.setBackground(new Color(176, 224, 230));
      
      //Botao start game
      btnIniciarJogo.setBounds(158, 357, 117, 25);
      getContentPane().add(btnIniciarJogo);

      //ComboBox
      comboBox.setBounds(115, 304, 191, 22);
      getContentPane().add(comboBox);
      comboBox.addItem("Fácil");
      comboBox.addItem("Médio");
      comboBox.addItem("Difícil");
      
      
      lblEscolhaONvel.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
      lblEscolhaONvel.setBounds(158, 275, 117, 15);
      getContentPane().add(lblEscolhaONvel);
      
      btnSair.setVisible(false);
      btnReset.setVisible(false);
     // board.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
      board.setBounds(0, 50, 435, 462);

      cp.add(board);     
      board.setVisible(false);
      	
   
	  setBounds(100, 100, 446, 646);
	  Cronometro.getInstance().setBounds(365, 12, 70, 15);
	  cp.add(Cronometro.getInstance());
	  Cronometro.getInstance().setVisible(false);

      // Add a button to the south to re-start the game via board.newGame()
      // ......

      // Initialize the game board to start the game
      
	  
      //pack();     // Pack the UI components, instead of using setSize()
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // to handle window-closing
      setTitle("Sudoku");
      setVisible(true);
      
      btnIniciarJogo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
				
        		if (comboBox.getSelectedItem().equals("Fácil")) 
        			board.newGame(Level.facil);
        		if (comboBox.getSelectedItem().equals("Médio")) 
        			board.newGame(Level.medio);
        		if (comboBox.getSelectedItem().equals("Difícil")) 
        			board.newGame(Level.dificil);
        		
        		cp.setBackground(new Color(176, 224, 230));
        		Cronometro.getInstance().startTimer();
        		playerNome = JOptionPane.showInputDialog("Player:");
        		jogador.setNome(playerNome);
        		lblPlayerName.setText(jogador.getNome());
        		startGame(true);	
        	}		
        });
      
 
	  lblNewLabel.setForeground(new Color(255, 255, 255));
	  lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 60));
	  lblNewLabel.setBounds(115, 76, 191, 155);

      getContentPane().add(lblNewLabel);
      btnPausar.setIcon(new ImageIcon(getClass().getResource("/files/pausa.png")));
      btnPausar.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		btnContinuar.setVisible(true);
      		btnPausar.setVisible(false);
      		Cronometro.getInstance().stopTimer();
      	}
      });
      btnContinuar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnContinuar.setVisible(false);
        		btnPausar.setVisible(true);
        		Cronometro.getInstance().startTimer();
        	}
        });
       

      btnPausar.setBounds(304, 10, 42, 27);
      getContentPane().add(btnPausar);
      
      btnContinuar.setIcon(new ImageIcon(getClass().getResource("/files/play.png")));
      btnContinuar.setBounds(304, 10, 42, 27);
      getContentPane().add(btnContinuar);
      btnContinuar.setVisible(false);
      
      btnPausar.setVisible(false);
      btnReiniciar.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		RestartGame(true);
      		cp.setBackground(new Color(176, 224, 230));
      		Cronometro.getInstance().restartTimer();
      	}
      });
      
   
      btnReiniciar.setBounds(24, 560, 117, 25);
      getContentPane().add(btnReiniciar);
      

      btnSair.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		System.exit(0);
      	}
      });
      btnSair.setBounds(304, 560, 105, 24);
      getContentPane().add(btnSair);
      
 
      lblPlayer.setVisible(false);
      lblPlayer.setBounds(10, 25, 46, 14);
      getContentPane().add(lblPlayer);
      lblPlayerName.setBounds(52, 25, 89, 14);
      
      getContentPane().add(lblPlayerName);
      
    
      btnReset.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		Cronometro.getInstance().restartTimer();
      		if (comboBox.getSelectedItem().equals("Fácil")) 
    			board.newGame(Level.facil);
    		if (comboBox.getSelectedItem().equals("Médio")) 
    			board.newGame(Level.medio);
    		if (comboBox.getSelectedItem().equals("Difícil")) 
    			board.newGame(Level.dificil);
      	}
      });
      btnReset.setBounds(158, 560, 130, 25);
      getContentPane().add(btnReset);
      

      btnReiniciar.setVisible(false);

      setLocationRelativeTo(null);
   }
   
   
   public static SudokuMain getInstance() {
	   if(instance == null)
		   instance = new SudokuMain();
	   return instance;
   }
   
   public void startGame(boolean bool) {
	   	Cronometro.getInstance().setVisible(bool);
		board.setVisible(bool);
		btnIniciarJogo.setVisible(!bool);
		lblEscolhaONvel.setVisible(!bool);
		comboBox.setVisible(!bool);
		lblNewLabel.setVisible(!bool);
		btnPausar.setVisible(bool);
		btnContinuar.setVisible(bool);
		btnReiniciar.setVisible(bool);
		btnSair.setVisible(bool);
		lblPlayer.setVisible(bool);
		lblPlayerName.setVisible(bool);
		btnReset.setVisible(bool); 
	}
  public void RestartGame(boolean bool) {
	  Cronometro.getInstance().setVisible(!bool);
		board.setVisible(!bool);
		btnIniciarJogo.setVisible(bool);
		lblEscolhaONvel.setVisible(bool);
		comboBox.setVisible(bool);
		lblNewLabel.setVisible(bool);
		btnPausar.setVisible(!bool);
		btnReiniciar.setVisible(!bool);
		btnContinuar.setVisible(!bool);
		btnSair.setVisible(!bool);
		lblPlayer.setVisible(!bool);
		lblPlayerName.setVisible(!bool);
		btnReset.setVisible(!bool); 
  }
 
   

/** The entry main() entry method */
   public static void main(String[] args) {
      // [TODO 1] Check "Swing program template" on how to run
      //  the constructor of "SudokuMain" [ok]
	   
	   EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuMain frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
   }
}
