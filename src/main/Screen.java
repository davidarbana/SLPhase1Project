package main;

import main.service.FileManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Screen {

    private final String message = "Welcome to LockedMe.com application!";
    private final String author = "Developed by: David Arbana.";
    private final String invalidInput = "Invalid input!";
    private Scanner sc = new Scanner(System.in);
    private FileManagement fileManagement = new FileManagement();

    private void welcome() { //welcoming message
        System.out.println(message);
        System.out.println(author);
        System.out.println();
    }

    private void mainscreen() { //main menu message
        System.out.println("Main Menu");
        System.out.println("1. Show files");
        System.out.println("2. Show file options");
        System.out.println("3. Quit the application");
    }

    private void optionScreen(){ //option message
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search a file");
        System.out.println("4. Go to Main Menu");
    }

    public void mainMenu() throws InputMismatchException{
        this.welcome();

        loop:while (true) { //infinite loop that will be stopped only by a break statement
            mainscreen();
            String choice = sc.next(); //scanner that lets the user chose the branch
            switch (choice) {
                case "1": {
                    fileManagement.showFiles(); //showing all files
                    break;
                }
                case "2": { //going to second option list
                    this.options();
                    break;
                }
                case "3": { //exiting the application
                    System.out.println("Exiting LockedMe.com!");
                    break loop;
                }
                default: {
                    System.out.println(invalidInput);
                }
            }
        }

    }

    private void options() throws InputMismatchException {  //second screen options
        loop:while (true) { //infinite loop that can be stopped by a break condition
            optionScreen();
            String choice = sc.next();
            try{
            switch (choice) { //switch command for every option
                case "1": { //adding a file
                    System.out.println("Enter the file name that you want to add");
                    String fileName = sc.next();
                    fileManagement.addFile(fileName);
                    break;
                }
                case "2": { //deleting a file
                    System.out.println("Enter the file name you want to delete");
                    String fileName = sc.next();
                    fileManagement.deleteFile(fileName);
                    break;
                }
                case "3": { //searching for a file
                    System.out.println("Enter the file name you want to search");
                    String fileName = sc.next();
                    fileManagement.searchFile(fileName);
                    break;
                }
                case "4": { //going to main menu (Break command)
                    System.out.println("Going back to the Main Menu.\n");
                    break loop;
                }
                default: { //if the input is invalid
                    System.out.println(invalidInput);
                }
            }
        }
            catch(InputMismatchException e){
                System.out.println("Wrong input format!");
            }}
    }

}
