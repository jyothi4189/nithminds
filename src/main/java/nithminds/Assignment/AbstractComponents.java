package nithminds.Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AbstractComponents {
	public  FileInputStream readPropertyFile() throws FileNotFoundException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\nithminds\\Assignment\\resources\\global.properties");
				
				
				 return fis;
			}
			public String getUrl(String RequiredURl) throws IOException {
				FileInputStream fis = readPropertyFile();
				Properties p=new Properties();
				p.load(fis);
				return p.getProperty(RequiredURl);
				
			}
			public String getUserName(String RequiredUserName) throws IOException {
				FileInputStream fis = readPropertyFile();
				Properties p=new Properties();
				p.load(fis);
				return p.getProperty(RequiredUserName);
				
			}
			public String getPassWord(String RequiredPassword) throws IOException {
				FileInputStream fis = readPropertyFile();
				Properties p=new Properties();
				p.load(fis);
				return p.getProperty(RequiredPassword);
			}
			public Sheet readExcelFile(String SheetName,String TABName) throws EncryptedDocumentException, IOException {
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\nithminds\\Assignment\\resources\\"+SheetName+".xlsx";
				
				System.out.println(path);
		FileInputStream fis=new FileInputStream(path);
				Workbook wb=WorkbookFactory.create(fis);
				
				Sheet sheet =  wb.getSheet(TABName);
				
			
			return sheet;
			}
			
			public Workbook readExcelWorkBook(String sheetName,String TabName) throws EncryptedDocumentException, IOException {
				String path=System.getProperty("user.dir")+"\\src\\test\\java\\nithminds\\Assignment\\resources\\"+sheetName+".xlsx";
				FileInputStream fis=new FileInputStream(path);
				Workbook wb=WorkbookFactory.create(fis);
				return wb;
				}
				public FileOutputStream writeExcelFile(String sheetName,String TabName) throws FileNotFoundException {
				String path=System.getProperty("user.dir")+"\\src\\test\\java\\nithminds\\Assignment\\resources\\"+sheetName+".xlsx";
				FileOutputStream fos=new FileOutputStream(path);
				return fos;
				}
				
			public int getLastRowWithData(Sheet sheet) {
				int lastRowWithData=-1;
				for(int i=0;i<=sheet.getLastRowNum();i++) {
					Row row=sheet.getRow(i);
					if(row!=null) {
						boolean hasData=false;
						for(Cell cell:row) {
							if(cell.getCellType()!=CellType.BLANK) {
								hasData=true;
								break;
							}
						}
						if(hasData) {
							lastRowWithData=i;
						}
					}
				}
				return lastRowWithData;
							}
						
			public void writeDataBackToExcelSheet(String sheetName,String TabName, int rowIndex, int colIndex, String value,String heading) throws EncryptedDocumentException, IOException {
				Workbook wb = readExcelWorkBook(sheetName,TabName);
				Sheet sheet = wb.getSheet(TabName);
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String currentDate = sdf.format(new Date());
				
			
				Row headerRow = sheet.getRow(0);
				if (headerRow == null) {
				    headerRow = sheet.createRow(0);
				}

				// Ensure the cell in row 0 for the date is created
				Cell dateCell = headerRow.getCell(colIndex);
				if (dateCell == null) {
				    dateCell = headerRow.createCell(colIndex);
				}
				dateCell.setCellValue(currentDate);

				// Ensure the cell in row 1 for the heading is created
				Row headingRow = sheet.getRow(1);
				if (headingRow == null) {
				    headingRow = sheet.createRow(1);
				}
				Cell headingCell = headingRow.getCell(colIndex);
				if (headingCell == null) {
				    headingCell = headingRow.createCell(colIndex);
				}
				headingCell.setCellValue(heading);

				// Ensure the specified row and cell for `value` is created
				Row dataRow = sheet.getRow(rowIndex);
				if (dataRow == null) {
				    dataRow = sheet.createRow(rowIndex);
				}
				Cell dataCell = dataRow.getCell(colIndex);
				if (dataCell == null) {
				    dataCell = dataRow.createCell(colIndex);
				}
				dataCell.setCellValue(value);

				    try (FileOutputStream fos = writeExcelFile(sheetName,TabName)) {
				        wb.write(fos);
				} catch (IOException e) {
				        e.printStackTrace();
				} finally {
				        wb.close();
				}
			}	
			public void writeDataBackToExcelSheet(String sheetName,String TabName, int rowIndex, int colIndex, int value,String heading) throws EncryptedDocumentException, IOException {
				Workbook wb = readExcelWorkBook(sheetName,TabName);
				Sheet sheet = wb.getSheet(TabName);
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String currentDate = sdf.format(new Date());
				
			
				Row headerRow = sheet.getRow(0);
				if (headerRow == null) {
				    headerRow = sheet.createRow(0);
				}

				// Ensure the cell in row 0 for the date is created
				Cell dateCell = headerRow.getCell(colIndex);
				if (dateCell == null) {
				    dateCell = headerRow.createCell(colIndex);
				}
				dateCell.setCellValue(currentDate);

				// Ensure the cell in row 1 for the heading is created
				Row headingRow = sheet.getRow(1);
				if (headingRow == null) {
				    headingRow = sheet.createRow(1);
				}
				Cell headingCell = headingRow.getCell(colIndex);
				if (headingCell == null) {
				    headingCell = headingRow.createCell(colIndex);
				}
				headingCell.setCellValue(heading);

				// Ensure the specified row and cell for `value` is created
				Row dataRow = sheet.getRow(rowIndex);
				if (dataRow == null) {
				    dataRow = sheet.createRow(rowIndex);
				}
				Cell dataCell = dataRow.getCell(colIndex);
				if (dataCell == null) {
				    dataCell = dataRow.createCell(colIndex);
				}
				dataCell.setCellValue(value);

				    try (FileOutputStream fos = writeExcelFile(sheetName,TabName)) {
				        wb.write(fos);
				} catch (IOException e) {
				        e.printStackTrace();
				} finally {
				        wb.close();
				}
			}	
			public List<String> getExcelSheet(String sheetName,String TabName,int firstrow) throws EncryptedDocumentException, IOException {
				Sheet sheet = readExcelFile(sheetName,TabName);
				int rowcount=getLastRowWithData(sheet);
				List<String> allurl=new ArrayList<String>();
				System.out.println(rowcount);
			for(int i=firstrow;i<=rowcount;i++)
				{
					String url = sheet.getRow(i).getCell(0).getStringCellValue();
					System.out.println(url);
					allurl.add(url);
			}
			return allurl;
			}
			public void addEmptyColumn(String sheetName,String TabName,int column,int emptyColumnsToAdd) throws EncryptedDocumentException, IOException {
				//Sheet sheet = readExcelFile(sheetName,TabName);
				Workbook wb = readExcelWorkBook(sheetName,TabName);
				Sheet sheet = wb.getSheet(TabName);
				for(Row rows:sheet) {
					int lastCellIndex = rows.getLastCellNum()-1;
				
				for(int col=lastCellIndex;col>=column;col--) {
				Cell oldCell = rows.getCell(col);
				Cell newCell = rows.createCell(col+emptyColumnsToAdd);
				if(oldCell!=null) {
					copyCell(oldCell,newCell);
				}
				}
				
				for(int col=column;col<column+emptyColumnsToAdd;col++) {
					rows.createCell(col).setBlank();
				}
				}
				  try (FileOutputStream fos = writeExcelFile(sheetName,TabName)) {
				        wb.write(fos);
				} catch (IOException e) {
				        e.printStackTrace();
				} finally {
				        wb.close();
				}
			}
			public void copyCell(Cell oldCell,Cell newCell) {
			CellType type = oldCell.getCellType();
			switch(type) {
			case STRING:newCell.setCellValue(oldCell.getStringCellValue());break;
			case NUMERIC:newCell.setCellValue(oldCell.getNumericCellValue());break;
			case BOOLEAN:newCell.setCellValue(oldCell.getBooleanCellValue());break;
			case FORMULA:newCell.setCellFormula(oldCell.getCellFormula());break;
			default:newCell.setBlank();
				
			}
			}
}
