import java.util.Random;
import java.util.Scanner;

public class Computer {
    int score = 0;

    public int computerFunction(Human human, Random random){
        int thisRoundScore = 0;
        boolean ifContinue = true;
//     if(human.score >= 50 && this.score < 50){
//         ifContinue = false;
//     }else{
//         ifContinue = true;
//     }
     while(ifContinue){

         int value = random.nextInt(6) + 1;
         if(value == 6){
             System.out.println("the value is: "+ value );
             thisRoundScore = 0;
             return 0;
         }else{
             thisRoundScore += value;
             System.out.println("the value is: "+ value );
         }

         int randomValue = random.nextInt(8) + 1;
         if(randomValue > 5){
             ifContinue = false;
         }


     }
     this.score += thisRoundScore;
     return thisRoundScore;
    }


    public int getScore(){
        return this.score;
    }
}
