package eduweb.pl;

public class Main {

    public static void main(String[] args) {

        char[][] board = new char[10][10];
        fillBoard(board);
        printLetters(board);
        printBoard(board);
    }

    private static void fillBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getRandomShip(Math.random());
            }
        }
    }

    static void printLetters(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
        }

        System.out.print('\n');
    }

    static void  printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(i + 1 < 10)
                System.out.print(' ');
                System.out.print(i + 1);

            for (int j = 0; j < board[i].length; j++) {
                char shipValue = board[i][j];
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }

    private static char getRandomShip(double random) {
        if(random < 0.2) {
            return 'O';
        } else {
            return ' ';
        }
    }
}
