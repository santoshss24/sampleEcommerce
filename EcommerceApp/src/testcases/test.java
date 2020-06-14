package testcases;

import libraries.GenericExcelLib;
import libraries.IAutoConstants;

public class test implements IAutoConstants 
{
	public static void main(String[] args) {
		
		Object[][] arr=GenericExcelLib.getDataFromExcelFile(EXCEL_PATH,"TC001");
		for (Object[] obj : arr) {
			for (Object o : obj) {
			System.out.println(o);
			}
		}
	}
	

}
