/*---------------------------------------------------
Name:  Ian Sanz, Eric Castro Leyva, Adam Martinez
COP 2805C - Java Programming 2
Fall 2025 - W 5:30 PM - 8:50 PM
Assignment # 3
Plagiarism Statement
I certify that this assignment is my own work and that I have not
copied in part or whole or otherwise plagiarized the work of other
students, persons, Generative Pre-trained Generators (GPTs) or any other AI tools.
I understand that students involved in academic dishonesty will face
disciplinary sanctions in accordance with the College's Student Rights
and Responsibilities Handbook (https://www.mdc.edu/rightsandresponsibilities)
----------------------------------------------------------*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class SupportDeskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupportDesk ticketmanagement = new SupportDesk();

        OUTER_LOOP:
        while (true) {
            System.out.println("\nWelcome to the Ticket System");
            System.out.println("This is a modern interface for ticket management");
            System.out.println("-----------------------------------------------");
            System.out.println("1. Add new support ticket");
            System.out.println("2. Process next ticket");
            System.out.println("3. View all active tickets");
            System.out.println("4. View recently resolved tickets");
            System.out.println("5. Reopen last resolved ticket");
            System.out.println("6. Exit");
            System.out.print("Enter selection: ");

            int userSelection;

            try {
                userSelection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number 1-6.");
                scanner.nextLine(); // clear invalid token
                continue;
            }

            switch (userSelection) {
                case 1 -> ticketmanagement.addTicket(ticketmanagement.getTicket());
                case 2 -> ticketmanagement.processNextTicket();
                case 3 -> ticketmanagement.printTickets();
                case 4 -> ticketmanagement.viewRecentResolved();
                case 5 -> ticketmanagement.reopenLastResolve();
                case 6 -> {
                    System.out.println("Exiting....");
                    break OUTER_LOOP;
                }
                default -> System.out.println("Unknown selection. Please choose 1-6.");
            }
        }

        scanner.close();
    }
}
