package services;

public class PaypalService implements OnlinePaymentService {

	Double taxpermounth = 0.01;
	Double taxinterest = 0.02;
	
	@Override
	public Double payment(Double amount, Integer months) {
		Double j = amount*taxpermounth*months;
		Double m = amount + j;		
		return m += m*taxinterest;
	}
}
