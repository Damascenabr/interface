package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
		
		System.out.println("Enter the rental details: ");
		System.out.print("Vehicle model: ");
		String model = sc.nextLine();
		
		System.out.print("Withdrawal (dd/MM/yyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
		
		System.out.print("Return (dd/MM/yyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
		
		CarRental cr = new CarRental(start,finish,new Vehicle(model));
		
		System.out.print("Enter the hourly rate: ");
		double pricePerHour = sc.nextDouble();
		
		System.out.print("Enter the price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		rentalService.processInvoice(cr);
		System.out.println();
		
		System.out.println("INVOICE:");
		System.out.println("Basic Payment: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
		System.out.println("Tax: "+ String.format("%.2f",cr.getInvoice().getTax()));
		System.out.println("Total Payment: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));
		
		
		sc.close();

	}

}
