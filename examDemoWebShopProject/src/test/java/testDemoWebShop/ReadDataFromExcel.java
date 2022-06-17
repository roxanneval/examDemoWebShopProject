package testDemoWebShop;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demoWebShopClasses.ReadExcel;
import demoWebShopClasses.Utilities;

public class ReadDataFromExcel {
	
	ReadExcel rExcel = new ReadExcel();
	Utilities uts = new Utilities();

	String outputDirectory = uts.getDataConfigPropeties("OutputDir");
	String outputfile = outputDirectory + "outputfile.txt";
	
	@BeforeTest
	public void setup() {
		uts.resetOutputFile(outputfile);
	}
		
		@Test(dataProvider="Estimate Shipping")
		public void BrandQuantitySting(String country, String state, int zipCode) {
			System.out.println(country + " " + state + " " + zipCode);
			boolean bool = true;
			
			String result;
			if(bool) {
				result = "It's true";
			}else {
				result = "It's a fail";
			}
			String content = country + ","+ state +","+ "," + result;
			
			try {
				
				Files.write(Paths.get(outputfile), (content + System.lineSeparator()).getBytes(),
						StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			}catch (IOException e) {
				System.out.println("the error is " + e.getMessage());
			}
		}
		@DataProvider(name = "Estimate Shipping")
		public Object[][] getDataFromExcel(){
			String excelDirectory = rExcel.getDataConfigPropeties("excelDataDir");
			Object[][] errObj = rExcel.getExcelData(excelDirectory +"Estimate Shipping", "Sheet1");
			return errObj;
		}
}
