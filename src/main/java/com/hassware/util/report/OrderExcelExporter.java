package com.hassware.util.report;

import com.hassware.domain.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OrderExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Order> orderList;
    public OrderExcelExporter(List<Order> orderList) {
        this.orderList = orderList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Pedidos");
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
        cell.setCellValue("Id Order");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("Fecha");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Cliente");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Product");
        cell.setCellStyle(style);

        cell = row.createCell(4);
        cell.setCellValue("Cantidad (Cajas)");
        cell.setCellStyle(style);

        cell = row.createCell(5);
        cell.setCellValue("Costo Total");
        cell.setCellStyle(style);

        cell = row.createCell(6);
        cell.setCellValue("Encargado");
        cell.setCellStyle(style);
    }

    // Cells settings
    private void datatableWriter() {
        int rowNumber = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for(Order order : orderList) {
            Row row = sheet.createRow(rowNumber ++);

            Cell cell = row.createCell(0);
            cell.setCellValue(order.getIdorder());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(order.getDate().toString());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(order.getCustomer());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(order.getProduct());
            sheet.autoSizeColumn(3);
            cell.setCellStyle(style);

            cell = row.createCell(4);
            cell.setCellValue(order.getQuantity());
            sheet.autoSizeColumn(4);
            cell.setCellStyle(style);

            cell = row.createCell(5);
            cell.setCellValue(order.getTotal());
            sheet.autoSizeColumn(5);
            cell.setCellStyle(style);

            cell = row.createCell(6);
            cell.setCellValue(order.getCreatedby());
            sheet.autoSizeColumn(6);
            cell.setCellStyle(style);

        }
    }

    // Export settings
    public void export(HttpServletResponse response) throws IOException {
        headerWriter();
        datatableWriter();

        ServletOutputStream outPutStream = response.getOutputStream();
        workbook.write(outPutStream);

        workbook.close();
        outPutStream.close();
    }
}
