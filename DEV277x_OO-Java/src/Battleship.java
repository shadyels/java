import java.util.Scanner;

public class Battleship {
    public static int rows = 10;
    public static int columns = 10;
    public static String[][] ocean = new String[rows][columns];
    public static String[][] computerMoves = new String[rows][columns];
    public static int playerShips = 5;
    public static int computerShips = 5;

    public static void main(String[] args) {
        System.out.println("Welcome to BattleShips!");

        createOceanMap();
        System.out.println();

        deployPlayerShips();
        System.out.println();

        deployComputerShips();
        System.out.println();

        do {
            battle();
        } while(playerShips != 0 && computerShips != 0);

        gameOver();
    }

    public static void createOceanMap() {
        //top row
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();

        //ocean itself
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                ocean[i][j] = " ";
                if (j == 0) {
                    System.out.print(i + "|" + ocean[i][j]);
                } else if (j == (ocean[i].length - 1)) {
                    System.out.print(ocean[i][j] + "|" + i);
                } else {
                    System.out.print(ocean[i][j]);
                }
            }
            System.out.println();
        }

        //bottom row
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void deployPlayerShips() {
        int i = 0;

        while (i < playerShips) {
            Scanner input = new Scanner(System.in);
            System.out.println("Position your ship " + (i + 1) + "/" + playerShips);
            System.out.print("Enter X coordinate for your ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int y = input.nextInt();

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (ocean[x][y].equals(" "))) {
                ocean[x][y] = "@";
                i++;
            } else if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (ocean[x][y].equals("@"))) {
                System.out.println("You can't deploy your ship on an existing ship");
            } else {
                System.out.println("Your coordinates are out of bounds");
            }
        }
        printOceanMap();
    }

    public static void deployComputerShips() {
        int i = 0;

        System.out.println("The computer is deploying its ships...");

        while (i < computerShips) {
            int x = (int) (Math.random() * 10);
            int y = (int) (Math.random() * 10);

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (ocean[x][y].equals(" "))) {
                ocean[x][y] = "x";
                i++;
            }
        }
    }

    public static void battle() {
        playerTurn();
        System.out.println();

        computerTurn();
        System.out.println();
    }

    public static void playerTurn() {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your coordinates");

        System.out.print("x: ");
        int x = input.nextInt();

        System.out.print("y: ");
        int y = input.nextInt();

        if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) {
            if (ocean[x][y].equals("x")) {
                System.out.println("You sank of the computer ships!");
                ocean[x][y] = "*";
                printOceanMap();
                --computerShips;
            } else {
                System.out.println("No ships at these coordinates!");
                ocean[x][y] = "-";
                printOceanMap();
            }
        } else {
            System.out.println("Your coordinates are out of bounds!");
            playerTurn();
        }
    }

    public static void computerTurn() {
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);

        for(int i = 0; i < computerMoves.length; i++) {
            for (int j = 0; j < computerMoves[i].length; j++){
                computerMoves[i][j] = "0";
            }
        }

        if(computerMoves[x][y].equals("0")){
            if (ocean[x][y].equals("@")) {
                System.out.println("The computer sank one of your ships!");
                ocean[x][y] = "#";
                printOceanMap();
                --playerShips;
            } else {
                System.out.println("Your ships are safe! The computer missed");
                computerMoves[x][y] = "1";
                printOceanMap();
            }
        } else {
            computerTurn();
        }
    }

    public static void gameOver() {
        if (playerShips == 0) {
            System.out.println("Sorry! The computer sank your fleet and won...");
        } else {
            System.out.println("Congratulations! You sank the computer's fleet and won this game!");
        }
    }

    public static void printOceanMap() {
        //top row
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();

        //ocean
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if (j == 0) {
                    System.out.print(i + "|" + ocean[i][j]);
                } else if (j == (ocean[i].length - 1)) {
                    System.out.print(ocean[i][j] + "|" + i);
                } else {
                    System.out.print(ocean[i][j]);
                }
            }
            System.out.println();
        }

        //bottom row
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
}
