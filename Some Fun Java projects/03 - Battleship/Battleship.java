import java.util.*;
import java.io.*;

public class Battleship {

        // initialize scanner for user inputs
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Battleship!");

        // player 1 create 5x5
        System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] board_p1 = createBoard(input);
        char[][] history_p1 = createHistory();
        printBattleShip(board_p1);
        printBlankLines();

        input.nextDouble()
        // player 2 create 5x5
        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        char[][] board_p2 = createBoard(input);
        char[][] history_p2 = createHistory();
        printBattleShip(board_p2);
        printBlankLines();

        // initialize win or not; turn counter; and each player's total success hit
        // counter
        boolean hasWin = false;
        int turnCount = 0;
        int p1hitCount = 0;
        int p2hitCount = 0;

        // While not yet win, keep fire in turn
        do {
            // player1's turn
            if (turnCount % 2 == 0) {
                System.out.println("Player 1, enter hit row/column:");
                int idx_row = input.nextInt();
                int idx_col = input.nextInt();
                if ((idx_row < 0) || (idx_row > 4) || (idx_col < 0) || (idx_col > 4)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    turnCount--;
                } else if ((history_p2[idx_row][idx_col] == 'X') || (history_p2[idx_row][idx_col] == 'O')) {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    turnCount--;
                } else {
                    if (board_p2[idx_row][idx_col] == '@') {
                        board_p2[idx_row][idx_col] = 'X';
                        history_p2[idx_row][idx_col] = 'X';
                        System.out.println("PLAYER 1 HIT PLAYER 2’s SHIP!");
                        printBattleShip(history_p2);
                        p1hitCount++;
                        if (p1hitCount < 5) {
                            System.out.println();
                        } else {
                            hasWin = true;
                        }
                    } else {
                        board_p2[idx_row][idx_col] = 'O';
                        history_p2[idx_row][idx_col] = 'O';
                        System.out.println("PLAYER 1 MISSED!");
                        printBattleShip(history_p2);
                        System.out.println();
                    }

                }
            }
            // player2's turn
            else {
                System.out.println("Player 2, enter hit row/column:");
                int idx_row = input.nextInt();
                int idx_col = input.nextInt();
                if ((idx_row < 0) || (idx_row > 4) || (idx_col < 0) || (idx_col > 4)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    turnCount--;
                } else if ((history_p1[idx_row][idx_col] == 'X') || (history_p1[idx_row][idx_col] == 'O')) {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    turnCount--;
                } else {
                    if (board_p1[idx_row][idx_col] == '@') {
                        board_p1[idx_row][idx_col] = 'X';
                        history_p1[idx_row][idx_col] = 'X';
                        System.out.println("PLAYER 2 HIT PLAYER 1’s SHIP!");
                        printBattleShip(history_p1);
                        p2hitCount++;
                        if (p2hitCount < 5) {
                            System.out.println();
                        } else {
                            hasWin = true;
                        }
                    } else {
                        board_p1[idx_row][idx_col] = 'O';
                        history_p1[idx_row][idx_col] = 'O';
                        System.out.println("PLAYER 2 MISSED!");
                        printBattleShip(history_p1);
                        System.out.println();
                    }
                }
            }

            turnCount++;
        } while (hasWin == false);

        if (p1hitCount > p2hitCount) {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        } else {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
        }

        // print final board
        System.out.println("\nFinal boards:\n");
        printBattleShip(board_p1);
        System.out.println();
        printBattleShip(board_p2);

    }

    // Use this method to load 2 player's ship history 2d char Array.
    public static char[][] createHistory() {
        // initialize map for coordinate creation
        char[][] map = new char[5][5];

        // fill each map with '-' char as default
        for (char[] row : map) {
            Arrays.fill(row, '-');
        }
        return map;
    }

    // Use this method to load 2 players' ship coordinate 2d char Array.
    public static char[][] createBoard(Scanner input) {

        // initialize map for coordinate creation
        char[][] map = new char[5][5];

        // fill each map with '-' char as default
        for (char[] row : map) {
            Arrays.fill(row, '-');
        }

        // take player input, assign to initialized map
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter ship " + i + " location:");
            int idx_row = input.nextInt();
            int idx_col = input.nextInt();
            if ((idx_row < 0) || (idx_row > 4) || (idx_col < 0)
                    || (idx_col > 4)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                i--;
            } else if ((map[idx_row][idx_col] == '@')) {
                System.out.println("You already have a ship there. Choose different coordinates.");
                i--;
            } else {
                map[idx_row][idx_col] = '@';
            }

        }

        // System.out.println(Arrays.deepToString(map));
        return map;
    }

    // Use this method to print 100 empty lines.
    public static void printBlankLines() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

}
