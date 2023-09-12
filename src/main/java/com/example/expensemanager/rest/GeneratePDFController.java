package com.example.expensemanager.rest;

import com.example.expensemanager.entity.Transaction;
import com.example.expensemanager.repos.ITransactionService;
import com.example.expensemanager.service.report_pdf.GeneratePDFReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/api/report")
public class GeneratePDFController {

    private ITransactionService transactionService;

    @Autowired
    public GeneratePDFController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/month={month}&&year={year}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> monthlyReport(@PathVariable int month, @PathVariable int year) {
        List<Transaction> transactionList = (List<Transaction>) transactionService.findAll();
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if(transaction.getDate().getMonthValue() == month && transaction.getDate().getYear() == year) {
                result.add(transaction);
            }
        }

        ByteArrayInputStream bis = GeneratePDFReport.monthlyReport(result);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));

    }

}
