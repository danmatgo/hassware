package com.hassware.util.report;

import com.hassware.domain.Product;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ProductPdfExporter {

    private List<Product> productList;

    public ProductPdfExporter(List<Product> productList) {
        super();
        this.productList = productList;
    }

    // Header settings
    private void headerWriter(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.GREEN.darker().darker().darker());
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Id Product", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nombre", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Precio", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Existencias", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Modificado por", font));
        table.addCell(cell);
    }

    // Table settings
    private void datatableWriter(PdfPTable table) {
        for (Product product : productList) {
            table.addCell(String.valueOf(product.getIdproduct()));
            table.addCell(product.getName());
            table.addCell(String.valueOf(product.getStock()));
            table.addCell(String.valueOf(product.getPrice()));
            table.addCell(product.getManagedby());
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

        Paragraph title = new Paragraph("Lista de Productos", font);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(15);
        table.setWidths(new float[]{1.8f, 3.5f, 1.5f, 1.8f, 2f});
        table.setWidthPercentage(110);

        headerWriter(table);
        datatableWriter(table);

        document.add(table);
        document.close();
    }
}
