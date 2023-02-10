package com.hassware.util.report;

import com.hassware.domain.Order;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class OrderPdfExporter {

    private List<Order> orderList;

    public OrderPdfExporter(List<Order> orderList) {
        super();
        this.orderList = orderList;
    }

    // Header settings
    private void headerWriter(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.GREEN.darker().darker().darker());
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Id Pedido", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Fecha", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cliente", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Product", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cantidad (Cajas)", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Costo Total", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Encargado", font));
        table.addCell(cell);
    }

    // Table settings
    private void datatableWriter(PdfPTable table) {
        for (Order order : orderList) {
            table.addCell(String.valueOf(order.getIdorder()));
            table.addCell(order.getDate().toString());
            table.addCell(order.getCustomer());
            table.addCell(order.getProduct());
            table.addCell(String.valueOf(order.getQuantity()));
            table.addCell(String.valueOf(order.getTotal()));
            table.addCell(order.getCreatedby());
        }
    }

    // Export settings
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
        font.setSize(18);

        Paragraph title = new Paragraph("Lista de Pedidos", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{1.5f, 2f, 2.5f, 4.5f, 1.8f, 2f, 2.5f});
        table.setWidthPercentage(110);

        headerWriter(table);
        datatableWriter(table);

        document.add(table);
        document.close();
    }
}
