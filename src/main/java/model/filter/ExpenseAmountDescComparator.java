package model.filter;

import java.util.Comparator;

import javax.servlet.http.HttpServlet;

import model.dao.Expense;

public class ExpenseAmountDescComparator extends HttpServlet implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		double a1 = o1.getAmount(), a2 = o2.getAmount();
		if (a1 > a2) {
			return -1;
		} else if (a2 > a1) {
			return 1;
		} else {
			return 0;
		}

	}

}

