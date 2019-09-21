import java.util.Scanner;

public class MazeRunner {
    public static Maze myMap = new Maze();

    public static void main(String[] args) {
        intro();
        move();
    }

    public static void intro() {
        System.out.println("Welcome to the Maze, this is your current position: ");
        myMap.printMap();
    }

    public static void move (){
        int moves = 0;

        while(!myMap.didIWin()){
            System.out.print("Where would you like to move? D(own), U(p), L(eft) or R(ight)? ");
            Scanner input = new Scanner(System.in);
            String move = input.next();

            navigatePit(move);

            if (move.equals("D") && myMap.canIMoveDown()) {
                myMap.moveDown();
            } else if (move.equals("U") && myMap.canIMoveUp()) {
                myMap.moveUp();
            } else if (move.equals("L") && myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else if (move.equals("R") && myMap.canIMoveRight()) {
                myMap.moveRight();
            } else {
                System.out.println("Invalid Move!");
            }
            ++moves;
            myMap.printMap();
            movesMessage(moves);
            if(moves == 100) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations you have escaped the Maze in "+moves+" steps!");
    }

    public static void movesMessage(int moves) {
        if(moves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if(moves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if(moves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if(moves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
        }
    }

    public static void navigatePit(String move) {
        if(myMap.isThereAPit(move)) {
            System.out.print("There is a pit ahead, do you want to jump it? (Y/N) ");
            Scanner inputPit = new Scanner(System.in);
            String answerPit = inputPit.next();
            if(answerPit.equals("Y")){
                myMap.jumpOverPit(move);
            }
            else{
                System.out.println("Sorry you fell into a pit!");
                System.exit(0);
            }
        }
    }
}
