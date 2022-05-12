package bg.tu_varna.sit;

import command_lines.*;
import exceptions.InvalidCommandException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Students Information System.");
        System.out.println("Please Enter command:");
        while(true){
            try {
                System.out.print(">");
                String userInput = scanner.nextLine();
                String[] splittedInput = userInput.split("[ ]+");

                String commandName = splittedInput[0];
                Object[] commandArgs = new String[splittedInput.length-1];
                System.arraycopy(splittedInput,1,commandArgs,0,commandArgs.length);

                Command command = CommandFactory.getCommand(commandName);

                if(command!=null){
                    command.execute(commandArgs);
                }
                else {
                   throw new InvalidCommandException();
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
