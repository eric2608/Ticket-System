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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SupportDesk {
    private Queue<Ticket> activeTickets;
    private Stack<Ticket> resolvedTickets;

    public SupportDesk() {
        activeTickets = new LinkedList<>();
        resolvedTickets = new Stack<>();
    }

    public void addTicket(Ticket t) {
        activeTickets.add(t);
    }

    public void processNextTicket() {
        if (activeTickets.isEmpty()) {
            System.out.println("No active tickets to process.");
            return;
        }
        Ticket t = activeTickets.remove();
        resolvedTickets.push(t);
        System.out.println("Ticket resolved: " + t);
    }

    public void viewAllActiveTickets() {
        if (activeTickets.isEmpty()) {
            System.out.println("No active tickets.");
            return;
        }
        System.out.println("Active tickets:");
        for (Ticket t : activeTickets) {
            System.out.println(t);
        }
    }

    public void viewRecentResolved() {
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets yet.");
            return;
        }
        System.out.println("Recently resolved tickets:");

        // show top 3 or however many are available -- Eric (10/29)
        int count = Math.min(3, resolvedTickets.size());
        for (int i = resolvedTickets.size() - 1; i >= resolvedTickets.size() - count; i--) {
            System.out.println(resolvedTickets.get(i));
        }
    }

    // take a double look to be sure; it passed my tests -- Ian (10/29)
    // polished it -- Adam (10/30)
    public void reopenLastResolved() {
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets to reopen.");
            return;
        }
        Ticket t = resolvedTickets.pop();
        activeTickets.add(t);
        System.out.println("Ticket reopened: " + t);
    }
}
