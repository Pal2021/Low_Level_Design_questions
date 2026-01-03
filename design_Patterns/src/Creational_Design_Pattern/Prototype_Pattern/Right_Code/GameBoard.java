package Creational_Design_Pattern.Prototype_Pattern.Right_Code;
import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard>{
    private List<GamePiece> pieces = new ArrayList<>();

    public void addPiece(GamePiece piece){
        pieces.add(piece);
    }

    public List<GamePiece> getPieces(){
        return pieces;
    }

    public void showBoardState(){
        for(GamePiece piece:pieces){
            System.out.println(piece);
        }
    }

    @Override
    public GameBoard clone() {
        GameBoard gameBoard=new GameBoard();
        for(GamePiece piece:pieces){
            gameBoard.addPiece(piece.clone());
        }
        return gameBoard;
    }
}