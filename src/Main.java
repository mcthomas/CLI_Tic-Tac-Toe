import java.util.Scanner;

public class Main {


    public static void main(String args[]) {  
       
        Boolean play = true;
        Boolean draw = false;
        int turn = 0;
        String move = "";
        Board gameBoard = new Board();
        Scanner input = new Scanner(System.in);
        System.out.println("Tic-Tac-Toe");
        gameBoard.updateBoard();
        String playerOne =
                        "Player One, enter your desired move's column number, followed by its row number.";
        String playerTwo =
                        "Player Two, enter your desired move's column number, followed by its row number.";
        while (play) {
            while (!gameBoard.checkEnd()) {
                if (gameBoard.checkDraw()) {
                    draw = true;
                    break;
                }
                if (turn == 0) {
                    System.out.println(playerOne);
                    move = input.nextLine();
                    if (gameBoard.checkOpen(Integer.parseInt(move.substring(0, 1)) - 1,
                                    Integer.parseInt(move.substring(1, 2)) - 1)) {
                        gameBoard.move(Integer.parseInt(move.substring(0, 1)) - 1,
                                        Integer.parseInt(move.substring(1, 2)) - 1, 'X');
                        gameBoard.updateBoard();
                    } else {
                        System.out.println("");
                        System.out.println("Sorry, that is an illegal move.");
                        System.out.println("");
                        if (turn == 0) {
                            turn = 1;
                        } else
                            turn = 0;
                    }
                } else {
                    System.out.println(playerTwo);
                    move = input.nextLine();
                    if (gameBoard.checkOpen(Integer.parseInt(move.substring(0, 1)) - 1,
                                    Integer.parseInt(move.substring(1, 2)) - 1)) {
                        gameBoard.move(Integer.parseInt(move.substring(0, 1)) - 1,
                                        Integer.parseInt(move.substring(1, 2)) - 1, 'O');
                        gameBoard.updateBoard();
                    } else {
                        System.out.println("");
                        System.out.println("Sorry, that is an illegal move.");
                        System.out.println("");
                        if (turn == 0) {
                            turn = 1;
                        } else
                            turn = 0;
                    }

                }
                if (turn == 0) {
                    turn = 1;
                } else
                    turn = 0;
            }
            if (draw) {
                System.out.println("The game has ended in a tie!");
            }
            else if (turn == 1) {
                System.out.println("Player One Wins!");
            } else
                System.out.println("Player Two Wins!");
            System.out.println("");
            System.out.println("Enter 'P' to play again, or 'Q' to quit.");
            move = input.nextLine();
            if (move.equals("Q") || move.equals("q")) {
                play = false;
                break;
            }
            gameBoard = new Board();
            gameBoard.updateBoard();
            turn = 0;
        }

        System.out.println("Thanks for playing Tic-Tac-Toe!");
        input.close();
    
    }
}
