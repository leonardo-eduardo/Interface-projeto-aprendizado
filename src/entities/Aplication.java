package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import services.ContractService;
import services.PaypalService;

public class Aplication {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Enter contract data");
		 System.out.println("");
		 
		 System.out.print("Enter contract number:");
		 Integer number = sc.nextInt();
		 
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 System.out.print("Enter contract date(dd/MM/yyyy)");
		 Date date = formato.parse(sc.next());
		 
		 System.out.print("Enter contract value: ");
		 Double contractValue = sc.nextDouble();
		 
		 Contract contract = new Contract(number, date, contractValue);
		 
		 System.out.print("Enter with number of installments:");
		 Integer months = sc.nextInt();
		 
		 ContractService cs = new ContractService(new PaypalService());
		 
		 cs.processContract(contract, months);
		 
		 System.out.println("");
		 System.out.println("Vencimento  -  Valor");
		 
		 for(Installment y : contract.getInstallments()) {
			 System.out.println(y.toString());
		 }
			
	

	}
}
