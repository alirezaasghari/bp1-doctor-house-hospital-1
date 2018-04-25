package at.refugeescode.administrationui.view;

import at.refugeescode.administrationui.controller.InvoiceController;
import at.refugeescode.administrationui.model.LocalInvoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceViewController {

    private InvoiceController invoiceController;

    public InvoiceViewController(InvoiceController invoiceController) {
        this.invoiceController = invoiceController;
    }

    @ModelAttribute("invoices")
    List<LocalInvoice> showAll() {

        return invoiceController.showAllInvoices();
    }

    @GetMapping
    String page() {
        return "invoices";
    }
}
