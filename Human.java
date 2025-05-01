import java.util.Random;
import java.util.Scanner;

public class Human {
    String name;
    int score = 0;
    public Human(String name){
        this.name = name;   //constructor
    }
    public int humanFunction(Computer computer, Scanner sc, Random random) {
        boolean symbolOfContinue = true;
        int eachRoundScore = 0;
//        if (computer.score > 50 ) {  //&& this.score < 50
//            symbolOfContinue = false;
//        } else {
//            symbolOfContinue = true;
//        }
        while (symbolOfContinue) {
            int value = random.nextInt(6) + 1;
            if (value == 6) {
                //symbolOfContinue = false;
                System.out.println("your value is " + value);
                return eachRoundScore;
            } else {
                System.out.println("your value is " + value);
                eachRoundScore += value;
            }
            while (true) {
                System.out.println("do you want to continue");
                String input = sc.nextLine();
                char firstLetter = input.charAt(0);
                if (firstLetter == 'Y' || firstLetter == 'y') {
                    break;
                } else if (firstLetter == 'N' || firstLetter == 'n') {
                    symbolOfContinue = false;
                    break;
                } else {
                    System.out.println("please enter correctly");
                }
            }
        }
        this.score += eachRoundScore;
    return eachRoundScore;
    }
    public int getScore(){
        return this.score;
    }
    private String getName(){
        return this.name;
    }

    private void setScore(int score){
        this.score = score;
    }
}
