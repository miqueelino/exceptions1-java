import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

    try {
        System.out.print(" Enter room number : ");
        int number = sc.nextInt();
        System.out.print(" Check-in date (dd/mm/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print(" Check-out date (dd/mm/yyyy): ");
        Date checkout = sdf.parse(sc.next());
        
      
        Reservation reservation = new Reservation( number, checkin, checkout);
        System.out.println("Reservation: " + reservation);


        System.out.println();
        System.out.print("Enter data to update the reservation: ");
        System.out.print("Check-in date (dd/mm/yyyy): ");
        checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        checkout = sdf.parse(sc.next());

        reservation.updateDates(checkin, checkout);
        System.out.println("Reservation: " + reservation);
     }
     catch(ParseException e){
        System.out.println("Invalid date format ");
     }
     catch(DomainExceptions e){
        System.out.println("Error in reservation " + e.getMessage());
     }
     catch(RuntimeException e){
        System.out.println("Unexpected error");
     }
        sc.close();


    }
}
