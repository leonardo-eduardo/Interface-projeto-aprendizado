package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	
	private OnlinePaymentService onlinePaymentService;
		
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		for(int i = 1; i <= months; i++) {
			//valor da parcela
			Double fullQuota = onlinePaymentService.payment(contract.getTotalValue()/months,i);
			
			//Data do vencimento da parcela
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(contract.getDate());		
			calendar.add(Calendar.MONTH, i);
			Date dueDate = calendar.getTime();
			
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
		
		
		
	}
}
