package com.coderscampus.assignment6;

import java.time.YearMonth;

public class SalesData {
	YearMonth date;
	int unitsSold;

	public SalesData(YearMonth date, int unitsSold) {
		super();
		this.date = date;
		this.unitsSold = unitsSold;
	}

	public YearMonth getDate() {
		return date;
	}

//	public void setDate(YearMonth date) {
//		this.date = date;
//	}

	public int getUnitsSold() {
		return unitsSold;
	}

//	public void setUnitsSold(int unitsSold) {
//		this.unitsSold = unitsSold;
//	}

}
