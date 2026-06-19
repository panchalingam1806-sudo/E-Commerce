package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    public FileInputStream fi;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;

    String path;

    public ExcelUtility(String path) {
        this.path = path;
    }
    
//    public ExcelUtility(String path) throws IOException {
//
//        this.path = path;
//
//        fi = new FileInputStream(path);
//        workbook = new XSSFWorkbook(fi);
//
//        // DEBUG: print all sheet names
//        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
//            System.out.println("Sheet available: " + workbook.getSheetName(i));
//        }
//        System.out.println("Excel file path: " + path);
//    }

    // OPEN WORKBOOK ONLY ONCE PER METHOD SAFELY
    private void loadWorkbook() throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
    }

    public int getRowCount(String sheetname) throws IOException {

        loadWorkbook();

        sheet = workbook.getSheet(sheetname);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetname);
        }

        int rowcount = sheet.getLastRowNum();

        workbook.close();
        fi.close();

        return rowcount;
    }

    public int getCellCount(String sheetname, int rownum) throws IOException {

        loadWorkbook();

        sheet = workbook.getSheet(sheetname);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetname);
        }

        XSSFRow row = sheet.getRow(rownum);

        if (row == null) {
            throw new RuntimeException("Row not found: " + rownum);
        }

        int cellcount = row.getLastCellNum();

        workbook.close();
        fi.close();

        return cellcount;
    }

    public String getCellData(String sheetname, int rownum, int colnum) throws IOException {

        loadWorkbook();

        sheet = workbook.getSheet(sheetname);

        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetname);
        }

        XSSFRow row = sheet.getRow(rownum);

        if (row == null) {
            return "";
        }

        XSSFCell cell = row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();

        String data = "";

        if (cell != null) {
            data = formatter.formatCellValue(cell);
        }

        workbook.close();
        fi.close();

        return data;
    }
}