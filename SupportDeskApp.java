package ticket.system;
import java.util.Scanner;

/**
 *
 * @author 13059
 */
public class SupportDeskApp {

    /**
     * @param args the command line arguments
     */
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
        
        switch (userSelection){
            case 1 ->ticketmanagement.addTicket(ticketmanagement.getTicket());
            case 2 -> ticketmanagement.processNextTicket();
            case 3 -> ticketmanagement.printTickets();
            case 4 -> ticketmanagement.viewRecentlySolved();
            case 5 ->ticketmanagement.reopenLastResolve() ;
            case 6 ->{ System.out.println("Exiting....");
            break OUTER_LOOP;
            }
            
            default -> System.out.print("Unknown Selection");
            
                
        
        }
        
       }
        
    }
    
}
