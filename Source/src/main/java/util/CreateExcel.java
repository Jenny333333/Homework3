package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.Vw_record;

public class CreateExcel {

	public static void main(String[] args) {
		//CreateExcel.createExcelFile("Record.xls","戰績");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<Vw_record> records =new ArrayList<>();
		 Vw_record r1 = new Vw_record();
	        r1.setGame("購物小能手");
	        r1.setLevel("高級");
	        r1.setStar(11);
	        r1.setStartTime(LocalDateTime.parse("2025-09-19 02:05:00", formatter));
	        r1.setEndTime(LocalDateTime.parse("2025-09-19 02:11:00", formatter));
	        r1.setDuration(360);  
	        records.add(r1);
		CreateExcel.insertValue("Record.xls", "戰績", records);
	}
	public static void createExcelFile(String excelFilename, String sheetName) 
	{
		try {
			FileOutputStream excelFile=new FileOutputStream(excelFilename); 
			HSSFWorkbook excelBook=new HSSFWorkbook();  
			HSSFSheet sheet=excelBook.createSheet(sheetName);  
			
			HSSFRow row=sheet.createRow(0);
			row.createCell(0).setCellValue("遊戲名稱");
			row.createCell(1).setCellValue("等級");
			row.createCell(2).setCellValue("星星");
			row.createCell(3).setCellValue("開始時間");
			row.createCell(4).setCellValue("結束時間");
			row.createCell(5).setCellValue("遊戲時間(秒)");
			
			excelBook.write(excelFile);  
			excelFile.flush();  
			excelFile.close(); 
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
}		
	
	
		public static void insertValue(String fileName,String sheetName,List<Vw_record> records)
		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			try {
				FileInputStream fis=new FileInputStream(fileName);  
				HSSFWorkbook excelBook=new HSSFWorkbook(fis);   
				HSSFSheet sheet=excelBook.getSheet(sheetName);  
				int startRow = sheet.getPhysicalNumberOfRows();
				
				
		
				for (int i = 0; i < records.size(); i++) {
		            Vw_record vw_record = records.get(i);
		            HSSFRow row = sheet.createRow(startRow + i);
		            row.createCell(0).setCellValue(vw_record.getGame());
		            row.createCell(1).setCellValue(vw_record.getLevel());
		            row.createCell(2).setCellValue(vw_record.getStar());
		            row.createCell(3).setCellValue(vw_record.getStartTime().format(formatter));
		            row.createCell(4).setCellValue(vw_record.getEndTime().format(formatter));
		            row.createCell(5).setCellValue(vw_record.getDuration());
		        }

		        try (FileOutputStream fos = new FileOutputStream(fileName)) {
		            excelBook.write(fos);
		        }

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		public static List<Vw_record> readFromExcel(String fileName, String sheetName) {
		    List<Vw_record> records = new ArrayList<>();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		    
		    try (FileInputStream fis = new FileInputStream(fileName)) {
		        HSSFWorkbook workbook = new HSSFWorkbook(fis);
		        HSSFSheet sheet = workbook.getSheet(sheetName);
		        int rowCount = sheet.getPhysicalNumberOfRows();
		        
		        for (int i = 1; i < rowCount; i++) { 
		            HSSFRow row = sheet.getRow(i);
		            if (row == null) continue;

		            String game = row.getCell(0).getStringCellValue();
		            String level = row.getCell(1).getStringCellValue();
		            int star = (int) row.getCell(2).getNumericCellValue();
		            String startStr = row.getCell(3).getStringCellValue();
		            String endStr = row.getCell(4).getStringCellValue();
		            int duration = (int) row.getCell(5).getNumericCellValue();

		            Vw_record record = new Vw_record();
		            record.setGame(game);
		            record.setLevel(level);
		            record.setStar(star);
		            record.setStartTime(LocalDateTime.parse(startStr, formatter));
		            record.setEndTime(LocalDateTime.parse(endStr, formatter));
		            record.setDuration(duration);

		            records.add(record);
		        }
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    
		    return records;
		}

		
		public static void exportToNewExcel(List<Vw_record> records) {
	        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	        String fileName = "Record_" + timestamp + ".xls";
	        
	        try (HSSFWorkbook workbook = new HSSFWorkbook();
	             FileOutputStream out = new FileOutputStream(new File(fileName))) {

	            HSSFSheet sheet = workbook.createSheet("戰績");
	            HSSFRow header = sheet.createRow(0);
	            header.createCell(0).setCellValue("遊戲名稱");
	            header.createCell(1).setCellValue("等級");
	            header.createCell(2).setCellValue("星星");
	            header.createCell(3).setCellValue("開始時間");
	            header.createCell(4).setCellValue("結束時間");
	            header.createCell(5).setCellValue("遊戲時間(秒)");

	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	            for (int i = 0; i < records.size(); i++) {
	                Vw_record rec = records.get(i);
	                HSSFRow row = sheet.createRow(i + 1);
	                row.createCell(0).setCellValue(rec.getGame());
	                row.createCell(1).setCellValue(rec.getLevel());
	                row.createCell(2).setCellValue(rec.getStar());
	                row.createCell(3).setCellValue(rec.getStartTime().format(formatter));
	                row.createCell(4).setCellValue(rec.getEndTime().format(formatter));
	                row.createCell(5).setCellValue(rec.getDuration());
	            }

	            workbook.write(out);
	            JOptionPane.showMessageDialog(null, "匯出成功！已建立檔案：" + fileName);

	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "匯出失敗：" + e.getMessage());
	        }
	    }
}

