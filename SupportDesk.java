package ticket.system;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class SupportDesk {
       Queue<Ticket> unsolvedTickets = new LinkedList<>();
       Stack<Ticket> solvedIssues = new Stack<>();
       static int idGenerator = 0;
       
       /*
           • addTicket(Ticket t) → adds a new ticket to the queue.
           • processNextTicket() → removes the next ticket from the queue and pushes it onto the stack.
           • viewAllActiveTickets() → displays all tickets currently in the queue.
           • viewRecentResolved() → shows the top 3 most recently resolved tickets (if available).
           • reopenLastResolved() → pops a ticket from the stack and puts it back into the queue
       */
       
       public void addTicket(Ticket ticket){
       
                this.unsolvedTickets.add(ticket);
       }
       
       public Ticket getTicket(){
             Scanner scanner = new Scanner(System.in);
             var id =idGenerator++;
             String name;
             String issue;
            
             System.out.println("Insert the name");
             name = scanner.next();
             
             
             System.out.println("Insert the issue ");
             issue = scanner.next();
             
             
             
             return new Ticket(id,name,issue);
       }
       
       public void processNextTicket(){
              
            Ticket next = unsolvedTickets.poll(); 
   
             solvedIssues.push(next);
       
           
       }
       
       public void viewAllActiveTickets() {
              if (unsolvedTickets.isEmpty()) {
                  System.out.println(" No active tickets.");
             return;
          }
        for (Ticket ticket : unsolvedTickets) {
            System.out.println("--------- " + ticket.name + " --------");
            System.out.println("ID:"+ticket.id+"--------");
            System.out.println("Issue: " + ticket.issue);
            System.out.println("Priority: " + ticket.priority);
            System.out.println("----------------------------");
        }
    }
        
          public void reopenLastResolve(){
              
            Ticket peek = solvedIssues.peek(); 
   
             unsolvedTickets.add(peek);
       
             solvedIssues.removeElementAt(0);
           
       }
       
       public void pop(){
                System.out.println("---------"+solvedIssues.pop()+" --------");
       }

       public void viewRecentResolved() {
        if (solvedIssues.isEmpty()) {
            System.out.println("No resolved tickets yet.");
            return;
        }
        int count = Math.min(3, solvedIssues.size());
              
        for (int i = 0; i < count; i++) {
            Ticket t = solvedIssues.get(solvedIssues.size() - 1 - i);
            System.out.println("#" + (i + 1) + " (most recent): " + t.name + " | " + t.issue + " | priority " + t.priority);
        }
        }
       
      public void printTickets(){
      
               for (Ticket ticket : unsolvedTickets){
               
                       System.out.println(ticket.issue);
                       System.out.println("---------------------------------------------");
                    
               }
       
      }
}
