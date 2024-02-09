package StrAlign_Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {

    private static FileInputStream fi;
    private static FileOutputStream fo;
    private static XSSFWorkbook wb;
    private static XSSFSheet ws;
    private static XSSFRow row;
    private static XSSFCell cell;

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            int rowcount = ws.getLastRowNum();
            return rowcount;
        } finally {
            closeResources();
        }
    }

    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            row = ws.getRow(rownum);
            int cellcount = row.getLastCellNum();
            return cellcount;
        } finally {
            closeResources();
        }
    }

    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            row = ws.getRow(rownum);
            cell = row.getCell(colnum);

            if (cell != null) {
                DataFormatter formatter = new DataFormatter();
                String cellData = formatter.formatCellValue(cell);
                return cellData;
            } else {
                return ""; // Cell is empty or not found
            }
        } finally {
            closeResources();
        }
    }

    public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
        try {
            fi = new FileInputStream(xlfile);
            wb = new XSSFWorkbook(fi);
            ws = wb.getSheet(xlsheet);
            row = ws.getRow(rownum);
            cell = row.createCell(colnum);
            cell.setCellValue(data);

            fo = new FileOutputStream(xlfile);
            wb.write(fo);
        } 	finally {
            closeResources();
        }
    }

    public static void closeResources() {
        try {
            if (fi != null) {
                fi.close();
            }
            if (fo != null) {
                fo.close();
            }
            if (wb != null) {
                wb.close();
            }
        } 	catch (IOException e) {
            e.printStackTrace();
        }
    }
}
