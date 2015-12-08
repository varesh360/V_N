package fly9;

import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;;

public class ExcelReportGenerator {

	public void generateExcelReport(String destFileName) throws Exception
	{
		// Get xml file location
		String path = getFilePath();
		File xmlFile = new File(path +"/target/surefire-reports/testng-results.xml");
		chart c = new chart();
		countGenerator count = new countGenerator();
		for(int i=0; i<30;i++)
		{	
			if(xmlFile.exists())
			{
				System.out.println("Results file found");
				break;
			}
		}
		
		// Create a new instance of xml file
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = fact.newDocumentBuilder();
		Document doc = build.parse(xmlFile);
		doc.getDocumentElement().normalize();
		
		// Create a workbook
		XSSFWorkbook book = new XSSFWorkbook();
		// Create Sheet Results
		XSSFSheet sheet1= book.createSheet("Results");
		// Create Style for Pass Fail color
		XSSFCellStyle fail = book.createCellStyle();
		XSSFCellStyle pass = book.createCellStyle();
		int f = 0;
		int g=0;
		// Get test node
		NodeList test_list = doc.getElementsByTagName("test");
		for(int i=0; i<test_list.getLength();i++)
		{
			int r=0;
			Node test_node =test_list.item(i);
			String test_name= ((Element)test_node).getAttribute("name");
			// Create sheet two
			XSSFSheet sheet= book.createSheet(test_name);
			NodeList class_list =((Element)test_node).getElementsByTagName("class");
			XSSFRow row =null;
			// Start loop with total execution classes
			for(int j=0; j<class_list.getLength(); j++)
			{
				Node class_node = class_list.item(j);
				// Test method node
				NodeList test_method_list= ((Element)class_node).getElementsByTagName("test-method");
				Node test_method_node = test_method_list.item(1);
				// Get method name
				String test_method_name= ((Element)test_method_node).getAttribute("name");
				// Get method status
				String test_method_status= ((Element)test_method_node).getAttribute("status");
				// Get method time
				String test_method_time= ((Element)test_method_node).getAttribute("duration-ms");

				// Store the total count of Pass and Fail tests
				if(test_method_status.contains("PASS"))
					f=f+1;
				if(test_method_status.contains("FAIL"))
					g=g+1;	
				
				// Set Background color of Pass and Fail
				fail.setFillForegroundColor(HSSFColor.RED.index);
				pass.setFillForegroundColor(HSSFColor.BRIGHT_GREEN.index);
				fail.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				fail.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				pass.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
				pass.setBorderBottom(XSSFCellStyle.BORDER_THIN);
				
				// Create Header for Tests
				XSSFRow headerRow = sheet.createRow(0);
				XSSFCell headerCel= headerRow.createCell(0);
				headerCel.setCellValue("Test Name");
				count.createStyle("Header", book, headerCel);
				
				XSSFCell headerCel1= headerRow.createCell(1);
				headerCel1.setCellValue("Result");
				count.createStyle("Header", book, headerCel1);
				
				XSSFCell headerCel2= headerRow.createCell(2);
				headerCel2.setCellValue("Exception message");
				count.createStyle("Header", book, headerCel2);
				
				XSSFCell headerCel3= headerRow.createCell(3);
				headerCel3.setCellValue("Test Duration");
				count.createStyle("Header", book, headerCel3);
				
				// Create Row
				r=r+1;
				row = sheet.createRow(r);

				// Create Cell and set method name in cell values
				XSSFCell cel_name= row.createCell(0);
				cel_name.setCellValue(test_method_name);
				count.createStyle("", book, cel_name);
				
				// Create Cell and set method status in cell values
				XSSFCell cel_status= row.createCell(1);
				cel_status.setCellValue(test_method_status);
				
				// Create Cell and set method time in cell values
				XSSFCell cel_time= row.createCell(3);
				cel_time.setCellValue(test_method_time);
				count.createStyle("", book, cel_time);
				
				// Set style for Pass and Fail
				if("fail".equalsIgnoreCase(test_method_status))
				{
					cel_status.setCellStyle(fail);			
				}
				else
				{
					cel_status.setCellStyle(pass);
				}
				
				// Get the exception for Fail cases
				XSSFCell cel_exp;
				String exp_msg;
				cel_exp =row.createCell(2);
				count.createStyle("", book, cel_exp);
				if("fail".equalsIgnoreCase(test_method_status))
				{
					NodeList exp_list= ((Element)test_method_node).getElementsByTagName("exception");
					Node exp_node = exp_list.item(0);
					exp_msg = ((Element)exp_node).getAttribute("class");
					cel_exp.setCellValue(exp_msg);
					
				}	
			}
			
			// Auto Size the columns
			for(int columnIndex = 0; columnIndex < 10; columnIndex++) {
				sheet.autoSizeColumn(columnIndex);
			}
		}
		
		String filePath = path + "/report/" +destFileName;
		new countGenerator().createResultsCountAndStyle(f, g, sheet1, book);
		FileOutputStream fout= new FileOutputStream(path + "/report/" +destFileName);
		book.write(fout);
		c.createChart(filePath);
		fout.close();
		System.out.println("Report Generated");		 
	}

	public static void main(String[] args) throws Exception
	{
		new ExcelReportGenerator().generateExcelReport("TestResults.xlsx");
	}
	
	//Get file path
	public String getFilePath() 
	{
		String filepath = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		filepath = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return filepath;
	}
		

}
