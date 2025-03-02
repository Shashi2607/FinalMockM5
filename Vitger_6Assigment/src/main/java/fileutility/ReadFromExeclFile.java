package fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ReadFromExeclFile {

	public static String readExecl(String s, int row, int column) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Vtiger_M5.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		Thread.sleep(2000);
		String data= sheet.getRow(row).getCell(column).toString();
		return data;
	}
}
