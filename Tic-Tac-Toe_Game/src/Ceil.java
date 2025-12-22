public class Ceil {
    private int row;
    private int col;
    private Symbol symbol;

    public Ceil(int row,int col){
        this.row=row;
        this.col=col;
        this.symbol=Symbol.EMPTY;
    }

    public Boolean isEmpty(){
        return symbol==Symbol.EMPTY;
    }
    public void setSymbol(Symbol symbol){
        this.symbol=symbol;
    }

    public Symbol getSymbol(){
        return symbol;
    }

}
