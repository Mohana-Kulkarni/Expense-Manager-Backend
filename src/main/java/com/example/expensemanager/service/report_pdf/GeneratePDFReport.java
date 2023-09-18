package com.example.expensemanager.service.report_pdf;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.example.expensemanager.entity.Transaction;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;


public class GeneratePDFReport {

    LoggerContext context = new LoggerContext();
    Logger logger = context.getLogger("GeneratePDF.class");
    public static ByteArrayInputStream monthlyReport(List<Transaction> transactionList) {
        Document document = new Document();
        ByteArrayOutputStream out =  new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph paragraph = new Paragraph("Monthly Report", fontHeader);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            Stream.of("ID", "Title", "Amount", "Category", "Date").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                headFont.setColor(Color.WHITE);
                header.setBackgroundColor(Color.BLACK);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setPadding(10);
                header.setBorderWidth(2);
                header.setBorderColor(Color.WHITE);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            int i = 0;
            int total = 0;
            for (Transaction transaction : transactionList) {
                PdfPCell idCell = new PdfPCell(new Phrase(Integer.toString(++i)));
                idCell.setPadding(6);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell titleCell = new PdfPCell(new Phrase(transaction.getName()));
                titleCell.setPadding(6);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(titleCell);

                total += transaction.getAmount();
                PdfPCell amountCell = new PdfPCell(new Phrase(Integer.toString(transaction.getAmount())));
                amountCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                amountCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                amountCell.setPadding(6);
                table.addCell(amountCell);

                PdfPCell categoryCell = new PdfPCell(new Phrase(transaction.getCategory().getName()));
                categoryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                categoryCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                categoryCell.setPadding(6);
                table.addCell(categoryCell);

                PdfPCell dateCell = new PdfPCell(new Phrase(transaction.getDate().toString()));
                dateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                dateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                dateCell.setPadding(6);
                table.addCell(dateCell);
            }
            document.add(table);
            Font totalFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 16);
            Paragraph paragraph1 = new Paragraph("Total : " + Integer.toString(total), totalFont);
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            paragraph1.setSpacingBefore(20);
            paragraph1.setIndentationLeft(50);


            document.add(paragraph1);


            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
