class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
    private GameStatus status;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.players = new Player[]{player1, player2};
        this.currentPlayerIndex = 0;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void startGame() {
        System.out.println("Game Started!");
        System.out.println(players[0].getName() + " (X) vs " + players[1].getName() + " (O)");
        board.display();
    }

    public boolean playMove(int row, int col) {
        if (status != GameStatus.IN_PROGRESS) {
            System.out.println("Game is over!");
            return false;
        }

        Player currentPlayer = players[currentPlayerIndex];

        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            System.out.println(currentPlayer.getName() + " played at (" + row + ", " + col + ")");
            board.display();
            checkGameStatus();

            if (status == GameStatus.IN_PROGRESS) {
                switchPlayer();
            }
            return true;
        } else {
            System.out.println("Invalid move! Try again.");
            return false;
        }
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        System.out.println(players[currentPlayerIndex].getName() + "'s turn");
    }

    private void checkGameStatus() {
        Symbol winner = board.checkWinner();

        if (winner == Symbol.X) {
            status = GameStatus.PLAYER_X_WON;
            System.out.println("Game Over! " + players[0].getName() + " wins!");
        } else if (winner == Symbol.O) {
            status = GameStatus.PLAYER_O_WON;
            System.out.println("Game Over! " + players[1].getName() + " wins!");
        } else if (board.isFull()) {
            status = GameStatus.DRAW;
            System.out.println("Game Over! It's a draw!");
        }
    }

    public void displayBoard() {
        board.display();
    }

    public Player getWinner() {
        if (status == GameStatus.PLAYER_X_WON) {
            return players[0];
        } else if (status == GameStatus.PLAYER_O_WON) {
            return players[1];
        }
        return null;
    }

    public GameStatus getStatus() {
        return status;
    }
}