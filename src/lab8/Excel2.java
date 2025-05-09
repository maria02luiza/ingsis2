package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class Excel2 {
    public static void main(String[] args) {
        XSSFWorkbook workbook2 = new XSSFWorkbook();
        XSSFSheet sheet2 = workbook2.createSheet("Grades");

        // 1. Structura de date
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average"});
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        // 2. Stil pentru header (bold + fundal)
        XSSFFont font = workbook2.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("Arial");
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setBold(true);

        XSSFCellStyle styleForHeader = workbook2.createCellStyle();
        styleForHeader.setFont(font);
        styleForHeader.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        styleForHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 3. Stil pentru coloanele G și H (fundal galben)
        XSSFCellStyle yellowCellStyle = workbook2.createCellStyle();
        yellowCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 4. Scrierea datelor în fișier
        int rowNum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row2 = sheet2.createRow(rowNum);
            Object[] objArr = entry.getValue();
            int colNum = 0;
            for (Object obj : objArr) {
                Cell cell2 = row2.createCell(colNum++);
                if (obj instanceof String)
                    cell2.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell2.setCellValue((Integer) obj);

                // Aplică stilul headerului
                if (entry.getKey().equals("1")) {
                    cell2.setCellStyle(styleForHeader);
                }
            }

            // Formule MAX și AVERAGE
            if (!entry.getKey().equals("1")) {
                int currentRow = Integer.parseInt(entry.getKey());
                Cell maxCell = row2.createCell(6);
                maxCell.setCellFormula(String.format("MAX(C%d:F%d)", currentRow, currentRow));
                maxCell.setCellStyle(yellowCellStyle);

                Cell avgCell = row2.createCell(7);
                avgCell.setCellFormula(String.format("AVERAGE(C%d:F%d)", currentRow, currentRow));
                avgCell.setCellStyle(yellowCellStyle);
            }

            rowNum++;
        }

        // Auto-size coloană
        for (int i = 0; i < 8; i++) {
            sheet2.autoSizeColumn(i);
        }

        // 5. Scrierea fișierului
        try {
            FileOutputStream out = new FileOutputStream("output8.xlsx");
            workbook2.write(out);
            out.close();
            workbook2.close();
            System.out.println("Fișierul output8.xlsx a fost creat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
