import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        System.out.println(" Number Guessing Game");
        Scanner scan=new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println("Hello " + name + " Welcome to the Number Guessing Game");
        Game myGame=new Game();
        boolean playGame=true;
        int userNumber;

        while(playGame==true) {
            userNumber=myGame.takeUserInput();
            boolean myBool=myGame.isCorrectNumber(userNumber);
            if(myBool==true) {
                System.out.print("Guessed in ");
                myGame.getNumberOfGuesses();
                System.out.print(" Guesses");
                System.out.println("");
                playGame=false;
                break;
            }
            else {
                playGame=true;
            }
        }
    }
}

class Game {
    private int computerNumber;
    private int numberOfGuesses=0;
    Scanner sc=new Scanner(System.in);

    Random rn=new Random();
    
    public Game() {
        computerNumber=rn.nextInt(101);
    }
    public int takeUserInput() {
        System.out.println("Guess the number between (1-100) : ");
        int userNumber=sc.nextInt();
        return userNumber;
    }
    public boolean isCorrectNumber(int myNum) {
        int flag=0;
        if(myNum<=100 && myNum>=0) {
            setNumberOfGuesses();
            if(myNum==computerNumber) {
                System.out.println("You guessed it right. The number is "+myNum);
                flag=1;
                sc.close();
            }
            else if(myNum<computerNumber) {
                System.out.println("Your guess is less than the actual number");
            }
            else if(myNum>computerNumber) {
                System.out.println("Your guess is greater than the actual number");
            }
        }
        else {
            System.out.println("Please enter in range 0-100");
        }
        if(flag==1) {
            return true;
        }
        else {
            return false;
        }
    }
    public void setNumberOfGuesses() {
        numberOfGuesses++;
    }
    public void getNumberOfGuesses() {
        System.out.print(numberOfGuesses);
    }
}