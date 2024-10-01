package com.coderscampus.assignment6;

import java.util.Objects;

public class SalesData {
	String date;
	int unitsSold;

	public SalesData(String date, int unitsSold) {
		this.date = date;
		this.unitsSold = unitsSold;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(date, unitsSold);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		SalesData other = (SalesData) obj;
//		return Objects.equals(date, other.date) && unitsSold == other.unitsSold;
//	}
}
