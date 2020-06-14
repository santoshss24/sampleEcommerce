package libraries;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class GenericExcelLib 
{
	public static String getValuefromExcel(String path,String sheetName,int r,int c)
	{
		String value="";
		try {
			FileInputStream fin=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fin);
			value = wb.getSheet(sheetName).getRow(r).getCell(c).getStringCellValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return value;
	}

	public static Object[][] getDataFromExcelFile(String path,String sheetName)
	{
		Object [][] arr=null;
		try {
			FileInputStream fin=new FileInputStream(path);
			Workbook wb=WorkbookFactory.create(fin);
			int rows = wb.getSheet(sheetName).getPhysicalNumberOfRows();
			 arr=new Object[rows][3];
			for (int i = 0; i <rows ; i++) 
			{	
				int cells = wb.getSheet(sheetName).getRow(i).getPhysicalNumberOfCells();
				for (int j = 0; j < cells; j++) 
				{
					
					arr[i][j]=wb.getSheet(sheetName).getRow(i).getCell(j).toString();                                        			
				}
			}
			
		} catch (Exception e) {
				Reporter.log("Not able to read data",true);
			}
		return arr;
	}

}






//try {
//System.out.print(wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue());
//} catch (Exception e) {
//System.out.print((int)wb.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue());		
//}