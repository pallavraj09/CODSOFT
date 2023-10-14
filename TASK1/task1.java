import java.util.Random;
import java.util.Scanner;


class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomNum = new Random();
        char playAgain;
        int round=0;
        int win=0;
        
        do {
            round++;
            int showMe = randomNum.nextInt(100);
            int count = 0;
            while (count < 5) {
                System.out.print("Guess the number (between 0 and 99): ");
                int n = sc.nextInt();
                
                if (n == showMe) {
                    System.out.println("You guessed it correct in " + (count + 1) + " attempts.");
                    win++;
                    break; // Exit the inner loop when the input is correct.
                } else {
                    count++;
                    if (count < 5) {
                        System.out.print("Incorrect guess. You have " + (5 - count) + " attempts left ");
                    
                    if(n>showMe)
                    {
                        System.out.println(":: Please Guess Lower Number ");
                    }
                    else 
                    {   System.out.println(":: Please Guess Higher Number");
                    }
                }}
            }

            if (count == 5) {

                System.out.println("You've used all your attempts :: The Number was "+showMe);
            }

            System.out.print("Do you want to play again? Enter Y/N: ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y'); 
        
        System.out.println("Round played :"+round+" And You Won : "+win );
        sc.close();
        System.out.println("Thanks For Playing !");
    }
}
