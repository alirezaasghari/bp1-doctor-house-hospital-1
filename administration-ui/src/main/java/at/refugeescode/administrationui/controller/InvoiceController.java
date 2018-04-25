package at.refugeescode.administrationui.controller;

import at.refugeescode.administrationui.model.Invoice;
import at.refugeescode.administrationui.model.LocalInvoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceController {

    @Value("${accountancy.invoices.url}")
    String accountancyInvoicesUrl;
    private RestTemplate restTemplate;
    private DateTimeFormatter formatter;

    public InvoiceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<LocalInvoice> showAllInvoices() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        List<Invoice> invoices = Arrays.asList(restTemplate.getForObject(accountancyInvoicesUrl, Invoice[].class));
        return invoices.stream()
                .map(invoice -> {
                    LocalInvoice localInvoice = new LocalInvoice();
                    localInvoice.setName(invoice.getPatient().getName());
                    localInvoice.setIllness(invoice.getPatient().getIllness());
                    localInvoice.setCost(invoice.getCost().toString() + " $");
                    localInvoice.setTime(formatter.format(invoice.getDateTime()).toString());
                    return localInvoice;
                })
                .collect(Collectors.toList());
    }
}