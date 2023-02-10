package com.hassware.util.report;

import com.hassware.domain.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Product> productList;

    public ProductExcelExporter(List<Product> productList) {
        this.productList = productList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Productos");
    }

    // Header settings
    private void headerWriter() {
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("Id Pedido");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Nombre");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Existencias (Cajas)");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Precio");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Modificado por");
        cell.setCellStyle(style);
    }

    // Cells Settings
    private void datableWriter() {
        int rowNumber = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Product product : productList) {
            Row row = sheet.createRow(rowNumber++);

            Cell cell = row.createCell(0);
            cell.setCellValue(product.getIdproduct());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(product.getName());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);


            cell = row.createCell(2);
            cell.setCellValue(product.getStock());
            sheet.autoSizeColumn(4);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(product.getPrice());
            sheet.autoSizeColumn(5);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(product.getManagedby());
            sheet.autoSizeColumn(6);
            cell.setCellStyle(style);

        }
    }

    // Export settings
    public void export(HttpServletResponse response) throws IOException {
        headerWriter();
        datableWriter();

        ServletOutputStream outPutStream = response.getOutputStream();
        workbook.write(outPutStream);

        workbook.close();
        outPutStream.close();
    }

}
