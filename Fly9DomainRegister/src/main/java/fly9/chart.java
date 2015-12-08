package fly9;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PiePlot;
import java.awt.Color; 

public class chart {  
        
	public void createChart(String path) throws Exception{ 
		
      /* Read Excel and the Chart Data */
      FileInputStream chart_file_input = new FileInputStream(new File(path));
      /* Read chart data from XLSX Workbook */
      XSSFWorkbook my_workbook = new XSSFWorkbook(chart_file_input);
      /* Read worksheet that has pie chart input data information */
      XSSFSheet my_sheet = my_workbook.getSheetAt(0);
      /* Create JFreeChart object that will hold the Pie Chart Data */
      DefaultPieDataset my_pie_chart_data = new DefaultPieDataset();
   
      /* Loop through worksheet data and populate Pie Chart Dataset */
      String[] chart_label= new String[20];
      Number chart_data=0;  
                
      for(int j=2; j<=3; j++)
      {
         Row t= my_sheet.getRow(j);
         Cell ce = t.getCell(1);
         Cell ce1 = t.getCell(2);
         chart_label[j]=ce.getStringCellValue();
      
         chart_data=ce1.getNumericCellValue();
         /* Add data to the data set */          
         my_pie_chart_data.setValue(chart_label[j],chart_data);
      }      
      /* Create a logical chart object with the chart data collected */
      JFreeChart myPieChart=ChartFactory.createPieChart("Fly9 Test Results",my_pie_chart_data,true,true,false);
      
      // Change color of chart
      PiePlot plot = (PiePlot) myPieChart.getPlot();
      if(chart_label[3].equalsIgnoreCase("Fail"))
    	  plot.setSectionPaint(chart_label[3], Color.RED);
  
      if(chart_label[2].equalsIgnoreCase("Pass"))
    	 plot.setSectionPaint(chart_label[2], Color.GREEN);
      
      /* Specify the height and width of the Pie Chart */
      int width=450; /* Width of the chart */
      int height=350; /* Height of the chart */
      float quality=1; /* Quality factor */
      /* Write chart as JPG to Output Stream */
      ByteArrayOutputStream chart_out = new ByteArrayOutputStream();          
      ChartUtilities.writeChartAsJPEG(chart_out,quality,myPieChart,width,height);
      /* Add picture to workbook */
      int my_picture_id = my_workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_JPEG);                
      /* Close the output stream */
      chart_out.close();
      /* Create the drawing container */
      XSSFDrawing drawing = my_sheet.createDrawingPatriarch();
      /* Create an anchor point */
      ClientAnchor my_anchor = new XSSFClientAnchor();
      /* Define top left corner, and we can resize picture suitable from there */
      my_anchor.setCol1(4);
      my_anchor.setRow1(5);
      /* Invoke createPicture and pass the anchor point and ID */
      XSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
      /* Call resize method, which resizes the image */
      my_picture.resize();
      /* Close the FileInputStream */
      chart_file_input.close();               
      /* Write Pie Chart back to the XLSX file */
      FileOutputStream out = new FileOutputStream(new File(path));
      my_workbook.write(out);
      out.close();            
     }
}