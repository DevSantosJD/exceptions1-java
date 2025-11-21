package org.example;

import org.example.model.entities.Reservation;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());


            reservation.updateDate(checkin, checkout);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Error in reservatrion: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Error, insert a number valid for reservation");
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}