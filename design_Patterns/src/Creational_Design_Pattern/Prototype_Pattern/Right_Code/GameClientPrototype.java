package Creational_Design_Pattern.Prototype_Pattern.Right_Code;

public class GameClientPrototype {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addPiece(new GamePiece("Red",1));
        gameBoard.addPiece(new GamePiece("Blue",5));
        gameBoard.showBoardState();

        //Checkpoint this state
        GameBoard copiedBoard = gameBoard.clone();

        System.out.println("1Copied Board");
        copiedBoard.showBoardState();
        gameBoard.addPiece(new GamePiece("green",6));
        System.out.println("2Copied Board");
        GameBoard copiedBoard2 = gameBoard.clone();
        copiedBoard2.showBoardState();

    }
}
