public class Board {
    private Ceil[][] ceils;
    private int size;
    public Board(int size){
        this.ceils=new Ceil[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                ceils[i][j]=new Ceil(i,j);
            }
        }
    }

    public boolean makeMove(int row,int col,Symbol symbol){
        if (!isValidMove(row, col)) {
            return false;
        }
        ceils[row][col].setSymbol(symbol);
        return true;
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        return ceils[row][col].isEmpty();
    }

    public Symbol checkWinner(){
        // Check rows
        Symbol rowWinner = checkRow();
        if (rowWinner != Symbol.EMPTY) return rowWinner;

        // Check columns
        Symbol colWinner = checkColumns();
        if (colWinner != Symbol.EMPTY) return colWinner;

        // Check diagonals
        return checkDiagonals();

    }

    private Symbol checkRow(){
        for (int i = 0; i < size; i++) {
            if (ceils[i][0].getSymbol() != Symbol.EMPTY &&
                    ceils[i][0].getSymbol() == ceils[i][1].getSymbol() &&
                    ceils[i][1].getSymbol() == ceils[i][2].getSymbol()) {
                return ceils[i][0].getSymbol();
            }
        }
        return Symbol.EMPTY;
    }
    private Symbol checkColumns() {
        for (int j = 0; j < size; j++) {
            if (ceils[0][j].getSymbol() != Symbol.EMPTY &&
                    ceils[0][j].getSymbol() == ceils[1][j].getSymbol() &&
                    ceils[1][j].getSymbol() == ceils[2][j].getSymbol()) {
                return ceils[0][j].getSymbol();
            }
        }
        return Symbol.EMPTY;
    }

    private Symbol checkDiagonals() {
        // Main diagonal
        if (ceils[0][0].getSymbol() != Symbol.EMPTY &&
                ceils[0][0].getSymbol() == ceils[1][1].getSymbol() &&
                ceils[1][1].getSymbol() == ceils[2][2].getSymbol()) {
            return ceils[0][0].getSymbol();
        }

        // Anti diagonal
        if (ceils[0][2].getSymbol() != Symbol.EMPTY &&
                ceils[0][2].getSymbol() == ceils[1][1].getSymbol() &&
                ceils[1][1].getSymbol() == ceils[2][0].getSymbol()) {
            return ceils[0][2].getSymbol();
        }

        return Symbol.EMPTY;
    }
    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (ceils[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        initializeBoard();
    }

    public void display() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                Symbol sym = ceils[i][j].getSymbol();
                char display = (sym == Symbol.EMPTY) ? ' ' : sym.toString().charAt(0);
                System.out.print(display + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


}
