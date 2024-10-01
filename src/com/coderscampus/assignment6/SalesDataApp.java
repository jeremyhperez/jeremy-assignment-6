package com.coderscampus.assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalesDataApp {
	public static final String RESET = "\033[0m";
	public static final String GREEN = "\033[32m";
	public static final String RED = "\033[31m";
	public static final String YELLOW = "\033[33m";
	public static final String BLUE = "\033[34m";
	

	public static void main(String[] args) throws IOException {
		//***************************** MODEL 3 *******************************
		List<SalesData> model3Sales = readSalesData("model3.csv");
		
		int sales32017 = model3Sales.stream()
					    .filter(record -> record.date.getYear()== 2017)
					    .mapToInt(record -> record.unitsSold)
					    .sum();
		
		int sales32018 = model3Sales.stream()
			    .filter(record -> record.date.getYear()== 2018)
			    .mapToInt(record -> record.unitsSold)
			    .sum();
		
		int sales32019 = model3Sales.stream()
			    .filter(record -> record.date.getYear()== 2019)
			    .mapToInt(record -> record.unitsSold)
			    .sum();

		SalesData bestMonth3 = model3Sales.stream()
							  .max(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);
		SalesData worstMonth3 = model3Sales.stream()
							  .min(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);			  
		System.out.println(YELLOW + "Model 3 Yearly Sales Report");
		System.out.println("----------------");
		System.out.println("2017 -> " + sales32017);
		System.out.println("2018 -> " + sales32018);
		System.out.println("2019 -> " + sales32019);
		if (bestMonth3 != null) {
			System.out.println("The best month for the Model 3 was: " + bestMonth3.date);
		}
		if (worstMonth3 != null) {
			System.out.println("The worst month for the Model 3 was: " + RED + worstMonth3.date + RESET);
		}
		System.out.println("");
		
		//***************************** MODEL S *******************************
		List<SalesData> modelSSales = readSalesData("modelS.csv");
		
		int salesS2016 = modelSSales.stream()
			    .filter(record -> record.date.getYear()== 2016)
			    .mapToInt(record -> record.unitsSold)
			    .sum();
		
		int salesS2017 = modelSSales.stream()
					    .filter(record -> record.date.getYear()== 2017)
					    .mapToInt(record -> record.unitsSold)
					    .sum();
		
		int salesS2018 = modelSSales.stream()
			    .filter(record -> record.date.getYear()== 2018)
			    .mapToInt(record -> record.unitsSold)
			    .sum();
		
		int salesS2019 = modelSSales.stream()
			    .filter(record -> record.date.getYear()== 2019)
			    .mapToInt(record -> record.unitsSold)
			    .sum();

		SalesData bestMonthS = modelSSales.stream()
							  .max(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);
		SalesData worstMonthS = modelSSales.stream()
							  .min(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);			  
		System.out.println(BLUE + "Model S Yearly Sales Report");
		System.out.println("----------------");
		System.out.println("2016 -> " + salesS2016);
		System.out.println("2017 -> " + salesS2017);
		System.out.println("2018 -> " + salesS2018);
		System.out.println("2019 -> " + salesS2019);
		if (bestMonthS != null) {
			System.out.println("The best month for the Model S was: " + bestMonthS.date);
		}
		if (worstMonthS != null) {
			System.out.println(BLUE + "The worst month for the Model S was: " + RED + worstMonthS.date + RESET);
		}
		System.out.println("");
		
		//***************************** MODEL X *******************************
		List<SalesData> modelXSales = readSalesData("modelX.csv");
		
		int salesX2016 = modelXSales.stream()
			    .filter(record -> record.date.getYear()== 2016)
			    .mapToInt(record -> record.unitsSold)
			    .sum();
		
		int salesX2017 = modelXSales.stream()
					    .filter(record -> record.date.getYear()== 2017)
					    .mapToInt(record -> record.unitsSold)
					    .sum();
		
		int salesX2018 = modelXSales.stream()
			    .filter(record -> record.date.getYear()== 2018)
			    .mapToInt(record -> record.unitsSold)
			    .sum();
		
		int salesX2019 = modelXSales.stream()
			    .filter(record -> record.date.getYear()== 2019)
			    .mapToInt(record -> record.unitsSold)
			    .sum();

		SalesData bestMonthX = modelXSales.stream()
							  .max(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);
		SalesData worstMonthX = modelXSales.stream()
							  .min(Comparator.comparingInt(record -> record.unitsSold))
							  .orElse(null);			  
		System.out.println(GREEN + "Model X Yearly Sales Report");
		System.out.println("----------------");
		System.out.println("2016 -> " + salesX2016);
		System.out.println("2017 -> " + salesX2017);
		System.out.println("2018 -> " + salesX2018);
		System.out.println("2019 -> " + salesX2019);
		if (bestMonthX != null) {
			System.out.println("The best month for the Model X was: " + bestMonthX.date);
		}
		if (worstMonthX != null) {
			System.out.println("The worst month for the Model X was: " + RED + worstMonthX.date + RESET);
		}
	}
	
	//***************************** Read Data Method *******************************
	public static List<SalesData> readSalesData(String filePath) throws IOException {
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM-yy");
		List<SalesData> salesRecords = Files.lines(Paths.get(filePath)).skip(1).map(line -> {
			String[] data = line.split(",");
			YearMonth date = YearMonth.parse(data[0], inputFormatter);
			int sales = Integer.parseInt(data[1]);
			return new SalesData(date, sales);
		}).collect(Collectors.toList());

		return salesRecords;

	}
}
