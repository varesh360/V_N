package utils;

import java.io.IOException;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class countGenerator {

	public void createResultsCountAndStyle(int passCount, int failCount, XSSFSheet sheet, XSSFWorkbook book) throws IOException 
	{	
		// Create a Row for Test Count text
		XSSFRow row = sheet.createRow(1);
		XSSFCell testCount= row.createCell(1);
		XSSFCell testCount1= row.createCell(2);
		testCount.setCellValue("Test Count");
		// Merge the two columns
		sheet.addMergedRegion(new CellRangeAddress(1,1,1,2));
		
		// Apply style to Test Result text
		createStyle("Header",book, testCount);
		createStyle("Header",book, testCount1);
		
		// Create row for Pass and apply style
		XSSFRow row1 = sheet.createRow(2);
		XSSFCell pass= row1.createCell(1);
		pass.setCellValue("Pass");
		createStyle("",book, pass);
		
		// Create row for Fail and apply style
		XSSFRow row2 = sheet.createRow(3);
		XSSFCell fail= row2.createCell(1);
		fail.setCellValue("Fail");
		createStyle("",book, fail);
		
		// Create row for Pass and Fail count and apply style
		XSSFCell countPass =row1.createCell(2);
		XSSFCell countFail =row2.createCell(2);
		countPass.setCellValue(passCount);
		createStyle("",book, countPass);
		countFail.setCellValue(failCount);
		createStyle("",book, countFail);
		
		System.out.println("Count Generated");		 
	}
	
	public void createStyle(String style, XSSFWorkbook book, XSSFCell cel)
	{
		if(style.equals("Header"))
		{
			// Create Border for Cells
			XSSFCellStyle my_style = book.createCellStyle();
			XSSFFont Font= book.createFont();
			Font.setBold(true);
			my_style.setFont(Font);
			my_style.setAlignment(HorizontalAlignment.CENTER);
			// Add Color and border
			my_style.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
			my_style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
			my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
			
			// Apply style to text
			cel.setCellStyle(my_style);
		}
		
		else
		{
			// Create Border for Cells
			XSSFCellStyle my_style = book.createCellStyle();
			my_style.setAlignment(HorizontalAlignment.CENTER);	
			my_style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			my_style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			my_style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			my_style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
					
			// Apply style to text
			cel.setCellStyle(my_style);
		}
		
	}
}
