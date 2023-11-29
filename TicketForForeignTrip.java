package changepondSeasonTicket;

import java.util.*;

public class TicketForForeignTrip {
    static Queue<String> confirmTicket = new LinkedList<String>();
    static Queue<String> waitingListTicket = new LinkedList<String>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> bookedNames = new HashSet<>(); // Set to keep track of booked names
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ashok");
        employees.add("Pradeep");
        employees.add("Vicky");
        employees.add("Bala");
        employees.add("Shreyas");
        employees.add("Shami");
        employees.add("Ruthuraj");
        employees.add("Dhoni");
        employees.add("Bravo");
        employees.add("Mcclleuum");
        employees.add("Yuvi");
        employees.add("ABD");
        employees.add("Mukesh");
        employees.add("Muthu");
        employees.add("Anandhu");

        for (; ; ) {
            try {
                System.out.print("\n\t\tWelcome to Changepond foreign Trip Ticket Status");
                System.out.print("\n\t\t\t\t1.Book Ticket ");
                System.out.print("\n\t\t\t\t2.Confirm Ticket ");
                System.out.print("\n\t\t\t\t3.Waiting Ticket ");
                System.out.print("\n\t\t\t\t4.Cancel Ticket ");
                System.out.print("\n\t\t\t\t5.Exit ");

                System.out.print("\nEnter your Choice : ");

                int choice;
                try {
                    choice = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine(); // Clear the invalid input from the scanner
                    continue;
                }

                if (choice == 1) {
                    try {
                        System.out.print("Enter your Name : ");
                        String name = input.next();
                        if (employees.contains(name)) {
                            if (!bookedNames.contains(name)) {
                                if (confirmTicket.size() < 10) {
                                    System.out.print("Hi " + name + " your ticket is confirmed");
                                    confirmTicket.offer(name);
                                    bookedNames.add(name);
                                } else {
                                    System.out.print("Hi " + name + " your ticket is in Waiting");
                                    waitingListTicket.offer(name);
                                    bookedNames.add(name);
                                }
                            } else {
                                System.out.println("Ticket for " + name + " has already been booked.");
                            }
                        } else {
                            System.out.println("Invalid name. Please enter a valid name.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid name.");
                        input.next(); // Clear the invalid input from the scanner
                    }

                } else if (choice == 2) {
                    try {
                        Iterator<String> iterator = confirmTicket.iterator();
                        if (confirmTicket.size() >= 1) {
                            int i = 1;
                            System.out.print("\nTicket No\t Names\n");
                            while (iterator.hasNext()) {
                                String element = iterator.next();
                                System.out.println("\n   " + i + "\t\t" + element);
                                i++;
                            }
                        } else {
                            System.out.println("No confirmed tickets available.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (choice == 3) {
                    try {
                        Iterator<String> iterator = waitingListTicket.iterator();
                        if (waitingListTicket.size() >= 1) {
                            System.out.print("\n\tNames\n");
                            while (iterator.hasNext()) {
                                String element = iterator.next();
                                System.out.println("\n\t" + element);
                            }
                        } else {
                            System.out.println("No One in waiting list.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (choice == 4) {
                    try {
                        System.out.print("Enter your Name to Cancel the ticket : ");
                        String name = input.next();
                        if (confirmTicket.contains(name)) {
                            confirmTicket.remove(name);
                            bookedNames.remove(name);
                            System.out.println("Ticket for " + name + " has been canceled.");
                            if (confirmTicket.size() <= 10 && !waitingListTicket.isEmpty()) {
                                confirmTicket.offer(waitingListTicket.poll());
                            }
                        } else {
                            System.out.println("Invalid name or ticket not found. Please enter a valid name.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid name.");
                        input.next(); // Clear the invalid input from the scanner
                    }
                } else if (choice == 5) {
                    System.out.print("\n\t\t\t\tThank You");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid number between 1 and 5.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
