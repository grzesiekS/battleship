package eduweb.pl;

public class Main {

    enum State {
        EMPTY, HIT, MISS, SUNK
    }

    public static void main(String[] args) {

        State[][] board = new State[10][10];
        fillBoard(board);
        printLetters(board);
        printBoard(board);
    }

    private static void fillBoard(State[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getRandomShip(Math.random());
            }
        }
    }

    static void printLetters(State[][] board) {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i));
        }

        System.out.print('\n');
    }

    static void  printBoard(State[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(i + 1 < 10)
                System.out.print(' ');
                System.out.print(i + 1);

            for (int j = 0; j < board[i].length; j++) {
                char shipValue = stateToChar(board[i][j]);
                System.out.print(shipValue);
            }
            System.out.print('\n');
        }
    }

    private static char stateToChar(State state) {
        char value;

        switch (state) {
            case EMPTY -> {
                value = ' ';
                break;
            }
            case HIT -> {
                value = 'O';
                break;
            }
            default -> {
                value = '?';
            }
        }

        return value;
    }

    private static State getRandomShip(double random) {
        if(random < 0.2) {
            return State.HIT;
        } else if(random > 0.8) {
            return State.EMPTY;
        } else {
            return State.MISS;
        }
    }
}
