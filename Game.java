import java.util.Random;
import java.util.Scanner;

public class Game {
    Computer computer;
    Human human;//  不用看成别的，就看成先声明，但还没有赋值的变量就行，就像int i； 会在后面初始化
    Random random = new Random();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   // 一切都是对象
        System.out.println("Welcome to Pig!");

        Game gc = new Game();
        while (true) {
            gc.run(sc);
            System.out.println("--------------------");
            System.out.println("Do you want to play again?");

            boolean check = gc.askYesNo(sc);
            if (!check) {
                System.out.println("Goodbye!");
                sc.close();
                break;
            }
        }

    }

    public void run(Scanner sc) {
        System.out.println("please enter your name");
        String name = sc.nextLine();
        createPlayers(name);
        System.out.println("Welcome " + name);

        while (!checkWinningStatus()) {
            int computerScore = computer.computerFunction(human, random);
            System.out.println( "computer's this round score " + computerScore );
            System.out.println("Computer's current score: " + computer.getScore());
            System.out.println("");
            System.out.println("");
//          if (checkWinningStatus()) {
//        	  break;
//        	  }

            int humanScore = human.humanFunction(computer,sc,random);
            System.out.println( "human's this round score " + humanScore );
            System.out.println( "Human's current score: " + human.getScore());
            System.out.println("");
            System.out.println("");

//            if (checkWinningStatus()) {
//                break;
//            }
        }

        printResults();
        printWinner();
    }

    /**
     * Creates one human player with the given humanName, and one computer player with a name.
     * @param humanName for human player
     */
    public void createPlayers(String humanName) {
        human = new Human(humanName);
        computer = new Computer();

    }

    /**
     * Checks if a winning status has been achieved
     * @return true if one player has won the game
     */
    public boolean checkWinningStatus() {
        int scoreOfHuman = human.getScore();
        int scoreOfComputer = computer.getScore();
        if (scoreOfHuman < 50 && scoreOfComputer < 50) {
            return false;
        }
        if (scoreOfHuman >= 50 && scoreOfComputer < 50) {
            return true;
        }
        if (scoreOfComputer >= 50 && scoreOfHuman < 50) {
            return true;
        }

        if (scoreOfHuman >= 50 && scoreOfComputer >= 50) {
            return scoreOfHuman != scoreOfComputer;
        }

        return false; // 所有其他情况都返回 false（这行理论上不会执行）
    }

    /**
     * Prints the final scores of the human player and computer player
     */
    public void printResults() {
        System.out.println("Human gets " + human.getScore());
        System.out.println("Computer gets " + computer.getScore());

    }

    /**
     * Determines who won the game, and prints the results
     */
    public void printWinner() {
        if (human.getScore() >= 50 && computer.getScore() < 50) {
            System.out.println("Human wins!");
        } else if (computer.getScore() >= 50 && human.getScore() < 50) {
            System.out.println("Computer wins!");
        }  else if(human.getScore() >= 50 && computer.getScore() > 50  && human.getScore() > computer.getScore()){
            System.out.println("Human wins!");
        } else if(human.getScore() >= 50 && computer.getScore() > 50  && human.getScore() < computer.getScore()){
            System.out.println("Computer wins!");
        }
    }

    /**
     * If the user responds a string starting with "y" or "Y", the function returns True.
     * If the  user responds a string starting with "n" or "N", the function returns False.
     * Any other response will cause the question to be repeated until the user provides an acceptable response.
     * @param sc to use for getting user input
     * @return true if user responds with "y" or "Y"
     */
    public boolean askYesNo(Scanner sc) {
        while(true) {
            String input = sc.nextLine();
            char letter = input.charAt(0);
            if(letter == 'Y' || letter =='y') {
                return true;
            }
            else if(letter == 'N' || letter =='n') {
                return false;
            }else {
                System.out.println("please enter again");
            }

        }
    }
}
