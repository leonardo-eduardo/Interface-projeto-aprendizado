package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private Date dueDate;
	private Double amount;

	public Installment() {
	}

	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDate() {
		return dueDate;
	}

	public void setDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String toString() {
		return formato.format(dueDate) + "  -  R$ " + String.format("%.2f", amount);
	}

}
