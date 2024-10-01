package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesDataApp {

	public static void main(String[] args) throws IOException {
		List<SalesData> model3Sales = new ArrayList<>();
		List<SalesData> modelSSales = new ArrayList<>();
		List<SalesData> modelXSales = new ArrayList<>();

		model3LoadData(model3Sales);
		modelSLoadData(modelSSales);
		modelXLoadData(modelXSales);
	}

	private static void modelXLoadData(List<SalesData> model3Sales) throws FileNotFoundException, IOException {
		BufferedReader modelXReader = new BufferedReader(new FileReader("modelX.csv"));
		String line;
		modelXReader.readLine();
		while ((line = modelXReader.readLine()) != null) {
			String[] data = line.split(",");
			String date = data[0];
			int unitsSold = Integer.parseInt(data[1]);
			SalesData salesData = new SalesData(date, unitsSold);
			model3Sales.add(salesData);
			modelXReader.close();
		}
	}

	private static void modelSLoadData(List<SalesData> model3Sales) throws FileNotFoundException, IOException {
		BufferedReader modelSReader = new BufferedReader(new FileReader("modelS.csv"));
		String line;
		modelSReader.readLine();
		while ((line = modelSReader.readLine()) != null) {
			String[] data = line.split(",");
			String date = data[0];
			int unitsSold = Integer.parseInt(data[1]);
			SalesData salesData = new SalesData(date, unitsSold);
			model3Sales.add(salesData);
			modelSReader.close();
		}
	}

	private static void model3LoadData(List<SalesData> model3Sales) throws FileNotFoundException, IOException {
		BufferedReader model3Reader = new BufferedReader(new FileReader("model3.csv"));
		String line;
		model3Reader.readLine();
		while ((line = model3Reader.readLine()) != null) {
			String[] data = line.split(",");
			String date = data[0];
			int unitsSold = Integer.parseInt(data[1]);
			SalesData salesData = new SalesData(date, unitsSold);
			model3Sales.add(salesData);
			model3Reader.close();
		}
	}

}
