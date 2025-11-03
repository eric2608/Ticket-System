package ticket.system;
import java.util.Scanner;

public class SupportDeskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userSelection ;
        
         
        System.out.println("Welcome to the Ticket System ");
        System.out.println("This is a modern interface for ticket management");
        
        SupportDesk ticketmanagement = new SupportDesk();
        
        OUTER_LOOP:
        while(true){  
        
        userSelection = scanner.nextInt();
        
        /*
                  1. Add new support ticket 
                  2. Process next ticket
                  3. View all active tickets
                  4. View recently resolved tickets
                  5. Reopen last resolved ticket
                  6. Exit
        */
            
            System.out.println("1. Add new support ticket");
            System.out.println("2. Process next ticket");
            System.out.println("3. View all active tickets");
            System.out.println("4. View recently resolved tickets");
            System.out.println("5. Reopen last resolved ticket");
            System.out.println("6. Exit");
            System.out.println("Enter selection");
        }
        
        switch (userSelection){
            case 1 ->ticketmanagement.addTicket(ticketmanagement.getTicket());
            case 2 -> ticketmanagement.processNextTicket();
            case 3 -> ticketmanagement.printTickets();
            case 4 -> ticketmanagement.viewRecentResolved();
            case 5 ->ticketmanagement.reopenLastResolve() ;
            case 6 ->{ System.out.println("Exiting....");
            break OUTER_LOOP;
            }
            
            default -> System.out.print("Unknown Selection");
            
        }
        
       }
        
    }
}
