import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");


        System.out.print(" Enter room number : ");
        int number = sc.nextInt();
        System.out.print(" Check-in date (dd/mm/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print(" Check-out date (dd/mm/yyyy): ");
        Date checkout = sdf.parse(sc.next());
        
        if(!checkout.after(checkin)){
            System.out.println("Error in reservation: chck-out date must be after check-in date ");
        }else{
            Reservation reservation = new Reservation( number, checkin, checkout);
            System.out.println("Reservation: " + reservation);


            System.out.println();

            System.out.print("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkout = sdf.parse(sc.next());

            String error = reservation.updateDates(checkin, checkout);
                if(error != null){
                    System.out.println("Error in reserevation: " + error);
                }
                else{
                    System.out.println("Reservation: " + reservation);
                }            
          

        }

        








        sc.close();


    }
}
