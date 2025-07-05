package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public FileInputStream fil;
	public FileOutputStream fol;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public  ExcelUtility(String path)
	{
		this.path=path;
	}
	
	//counting number of row
	public int getRowCount(String sheetName) throws Exception
	{
		 int rowcount = 0;
		try {
			fil=new FileInputStream(path);
			workbook=new XSSFWorkbook(fil);
			sheet=workbook.getSheet(sheetName);
		   rowcount =sheet.getLastRowNum();
			workbook.close();
			fil.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	//counting number of cell
	public int getCellCount(String sheetName,int rownum)
	{
		int cellcount=0;
		try {
			fil=new FileInputStream(path);
			workbook=new XSSFWorkbook(fil);
			sheet=workbook.getSheet(sheetName);
			cellcount=sheet.getRow(rownum).getLastCellNum();
			workbook.close();
			fil.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cellcount;
	}
	
	//Read data from excelSheet
	public String getCellData(String sheetName,int rownum,int cellnum)
	{
		String data = null;
		try
		{
			 fil=new FileInputStream(path);
			 workbook=new XSSFWorkbook(fil);
			 sheet=workbook.getSheet(sheetName);
			
		    row= sheet.getRow(rownum);
		   cell= row.getCell(cellnum);
		   DataFormatter dataFormatter=new DataFormatter();
		  
		   try {
		   data = dataFormatter.formatCellValue(cell);
		   
		   }
		   catch(Exception e)
		   {
			 data=" ";
		   }
		   workbook.close();
		   fil.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	//set data
	//set cell data
			public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
			{
				File xlfile=new File(path);
				if(!xlfile.exists())
				{
					workbook=new XSSFWorkbook();
					fol =new FileOutputStream(path);
					workbook.write(fol);		
				}
				fil =new FileInputStream(path);
				workbook=new XSSFWorkbook(fil);
				
				if(workbook.getSheetIndex(sheetName)==-1)//if sheet not exist then create new sheet
					workbook.createSheet(sheetName);
				  sheet=workbook.getSheet(sheetName);
				
				if(sheet.getRow(rownum)==null)//if row not exist create new row
					sheet.createRow(rownum);
				row=sheet.getRow(rownum);
				
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				
				fol=new FileOutputStream(path);
				workbook.write(fol);
				workbook.close();
				fil.close();
				fol.close();
				System.out.println("sucess====");
					
			}
}
