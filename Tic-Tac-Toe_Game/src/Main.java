public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Create players
        Player player1 = new Player("Alice", Symbol.X);
        Player player2 = new Player("Bob", Symbol.O);

        // Create and start game
        Game game = new Game(player1, player2);
        game.startGame();

        // Simulate some moves
        game.playMove(0, 0);  // Alice plays X at (0,0)
        game.playMove(1, 1);  // Bob plays O at (1,1)
        game.playMove(0, 1);  // Alice plays X at (0,1)
        game.playMove(1, 0);  // Bob plays O at (1,0)
        game.playMove(0, 2);  // Alice plays X at (0,2) - Alice wins!

        System.out.println("\nFinal Status: " + game.getStatus());
    }
}