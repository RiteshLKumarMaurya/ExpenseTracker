package model.filter;

import java.sql.Timestamp;
import java.util.Comparator;

import javax.servlet.http.HttpServlet;

import model.dao.Expense;

public class ExpenseDateAscComparator extends HttpServlet implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		Timestamp a1 = o1.getDate(), a2 = o2.getDate();
		return a1.compareTo(a2);
	}

}
