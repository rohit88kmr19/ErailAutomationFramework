package erailOrange.com.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public static void writeToExcel(String filePath, String sheetName, List<String> data) {
        Workbook workbook;
        Sheet sheet;

        try {
            // Check if the file already exists
            if (Files.exists(Paths.get("src/main/resources/stations.xlsx"))) {
                workbook = WorkbookFactory.create(Files.newInputStream(Paths.get("src/main/resources/stations.xlsx")));
            } else {
                workbook = new XSSFWorkbook();
            }

            // Get or create the sheet
            if (workbook.getSheet(sheetName) != null) {
                sheet = workbook.getSheet("Stations");
            } else {
                sheet = workbook.createSheet("Stations1");
            }

            // Write data to the sheet
            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0); // Write to the first column
                cell.setCellValue(data.get(i));
            }

            // Save the file
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/stations.xlsx")) {
                workbook.write(fos);
            }

            workbook.close();
            System.out.println("Data successfully written to Excel file!");

        } catch (IOException e) {
            throw new RuntimeException("Error writing to Excel file: " + e.getMessage(), e);
        }
    }

public static List<String> readFromExcel(String filePath, String sheetName) {
    List<String> data = new ArrayList<>();
    try (FileInputStream fis = new FileInputStream("src/main/resources/ExpectedStations.xlsx");
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheet("Expected");
        if (sheet == null) throw new RuntimeException("Sheet not found!");

        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Read data from the first column
            if (cell != null) {
                data.add(cell.getStringCellValue());
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error reading from Excel file: " + e.getMessage(), e);
    }
    return data;
}
}