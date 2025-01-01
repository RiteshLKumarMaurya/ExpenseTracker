package model.filter;

import java.util.Comparator;

import javax.servlet.http.HttpServlet;

import model.dao.Expense;

public class ExpenseTitleAscComparator extends HttpServlet implements Comparator<Expense> {

	@Override
	public int compare(Expense o1, Expense o2) {
		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}

}

