package com.billingapp.BillingApp.billingcontroller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillingController {

    @GetMapping("/")
    public String billingLogic() {
        return "index"; // Render the index.html page
    }

    @PostMapping("/values")
    public String getValues(
            @RequestParam("prices") String prices,
            @RequestParam("quantity") String quantity,
            @RequestParam("gst") String gst,
            Model model) {

        // Parse input values
        double price = Double.parseDouble(prices);
        int qty = Integer.parseInt(quantity);
        double gstPercent = Double.parseDouble(gst);

        // Calculate total amount and GST
        double totalAmount = price * qty;
        double gstRate = (gstPercent / 100) * totalAmount;

        // Add attributes to the model
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("gstRate", gstRate);
        model.addAttribute("grandTotal", totalAmount + gstRate);

        return "index"; // Render the index.html page with updated values
    }
}
