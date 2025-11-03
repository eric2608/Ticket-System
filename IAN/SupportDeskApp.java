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


import java.util.Scanner;

public class SupportDeskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupportDesk desk = new SupportDesk();

        System.out.println("Welcome to MDC Tech Support Ticket System");

        while (true) {
            System.out.println("\n1. Add new support ticket");
            System.out.println("2. Process next ticket");
            System.out.println("3. View all active tickets");
            System.out.println("4. View recently resolved tickets");
            System.out.println("5. Reopen last resolved ticket");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            // check if input is a valid number
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    // add new ticket
                    System.out.print("Enter ticket ID: ");
                    String idStr = scanner.nextLine();
                    int id;
                    try {
                        id = Integer.parseInt(idStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Must be a number.");
                        break;
                    }

                    System.out.print("Enter requester name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter issue: ");
                    String issue = scanner.nextLine();

                    System.out.print("Enter priority (Low/Medium/High): ");
                    String priority = scanner.nextLine();

                    // validate priority
                    if (!priority.equalsIgnoreCase("Low") &&
                            !priority.equalsIgnoreCase("Medium") &&
                            !priority.equalsIgnoreCase("High")) {
                        System.out.println("Invalid priority. Must be Low, Medium, or High.");
                        break;
                    }

                    Ticket ticket = new Ticket(id, name, issue, priority);
                    desk.addTicket(ticket);
                    System.out.println("Ticket added successfully!");
                    break;

                case 2:
                    // process next ticket
                    System.out.println("Processing next ticket...");
                    desk.processNextTicket();
                    break;

                case 3:
                    // view all active tickets
                    desk.viewAllActiveTickets();
                    break;

                case 4:
                    // view recently resolved
                    desk.viewRecentResolved();
                    break;

                case 5:
                    // reopen last resolved
                    desk.reopenLastResolved();
                    break;

                case 6:
                    // exit
                    System.out.println("Thank you for using MDC Tech Support Ticket System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}
