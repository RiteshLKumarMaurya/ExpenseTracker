package model.filter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.dao.Expense;
import model.dao.FetchAllExpense;
import session.SessionManagement;

public class FilterExpense {

	static Comparator<Expense> ctr;

	static List<Expense> expenses;
	static FetchAllExpense fetcher;
	static String userName;
	static String password;

	public static void filter(String filter_value, HttpServletRequest req) {
		userName = SessionManagement.getUsername(req);
		password = SessionManagement.getPassword(req);
		fetcher = new FetchAllExpense();
		expenses = fetcher.getAllExpenses(userName, password,false);

		if (filter_value.equals("date-asc")) {
			ctr=new ExpenseDateAscComparator();
			Collections.sort(expenses,ctr);
		}
		
		else if (filter_value.equals("date-desc")) {
			ctr=new ExpenseDateDescComparator();
			Collections.sort(expenses,ctr);

		} else if (filter_value.equals("amount-desc")) {
			ctr=new ExpenseAmountDescComparator();
			Collections.sort(expenses,ctr);
			
		} else if (filter_value.equals("amount-asc")) {
			ctr=new ExpenseAmountAscComparator();
			Collections.sort(expenses,ctr);
			
		} else if (filter_value.equals("title-desc")) {
			ctr=new ExpenseTitleDescComparator();
			Collections.sort(expenses,ctr);
			
		} else if (filter_value.equals("title-asc")) {
			ctr=new ExpenseTitleAscComparator();
			Collections.sort(expenses,ctr);/// only this is not working i do not know why!!!
		}
	}
}
