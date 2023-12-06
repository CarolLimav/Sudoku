package sudoku;

public class Erro {
    private static int erros;

    private Erro() {
    }
    public static int getErros() {
        return erros;
    }
    public static void errou() {
        erros += 1;
        SudokuMain.getInstance().updateErroLabel(); 
    }
//    public static void errouCelula() {
//        erros += 1;  
//    }
    public static void restartErro() {
        erros = 0; 
    }
}
