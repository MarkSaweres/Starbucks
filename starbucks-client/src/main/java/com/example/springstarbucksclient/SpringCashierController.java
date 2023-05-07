package com.example.springstarbucksclient;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.List;

import com.example.springstarbucksclient.model.CashierOrder;
import com.example.springstarbucksclient.model.Command;
import com.example.springstarbucksclient.service.SpringCashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class SpringCashierController {

    @Autowired
    private SpringCashierService springCashierService;

    @GetMapping
    public String getAction( @ModelAttribute("command") Command command,
                             Model model, HttpSession session) {

        String message = "" ;

        command.setRegister( "5012349" ) ;
        message = "Starbucks Reserved Order" + "\n\n" +
                "Register: " + command.getRegister() + "\n" +
                "Status:   " + "Ready for New Order"+ "\n" ;

        String server_ip = "" ;
        String host_name = "" ;
        try {
            InetAddress ip = InetAddress.getLocalHost() ;
            server_ip = ip.getHostAddress() ;
            host_name = ip.getHostName() ;
        } catch (Exception e) { }

        model.addAttribute( "message", message ) ;
        model.addAttribute( "server",  host_name + "/" + server_ip ) ;

        String selectedStore = (String) session.getAttribute("store");
        if (selectedStore != null) {
            command.setStores(selectedStore);
        }

        return "starbucks" ;
    }

/*
    @GetMapping("/login")
    public String login() {
        return "login";
    }
*/

    @PostMapping
    public String postAction(@Valid @ModelAttribute("command") Command command,
                             @RequestParam(value = "action", required = true) String action,
                             Errors errors, Model model, HttpServletRequest request) {

        String message = "";

        log.info("Action: " + action);
        command.setRegister(command.getStores());
        log.info("Command: " + command);

        // Process Post Action
        if (action.equals("Place Order")) {
            message = springCashierService.placeOrder(command);
        } else if (action.equals("Get Order")) {
            message = springCashierService.getOrder(command.getRegister());
        } else if (action.equals("Clear Order")) {
            message = springCashierService.clearOrder(command);
            // Delete the latest order from the database
            // TODO: build this via REST

/*            List<CashierOrder> orders = orderService.getAllOrders();
            if (!orders.isEmpty()) {
                // TODO: build this via REST
                orderService.deleteOrder(orders.get(orders.size() - 1).getId());
            }*/
            message = "Starbucks Reserved Order" + "\n\n" +
                    "Register: " + command.getRegister() + "\n" +
                    "Status:   " + "Ready for New Order" + "\n";
        }
        command.setMessage(message);

        String server_ip = "";
        String host_name = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            server_ip = ip.getHostAddress();
            host_name = ip.getHostName();
        } catch (Exception e) {
        }

        model.addAttribute("message", message);
        model.addAttribute("server", host_name + "/" + server_ip);

        return "starbucks";
    }

    @PostMapping("/selectStore")
    public String selectStore(@RequestParam String store, HttpSession session) {
        session.setAttribute("store", store);
        return "redirect:/";
    }

    public String placeOrder(@ModelAttribute("order") CashierOrder order, HttpSession session) {
        String store = (String) session.getAttribute("store");
        order.setStore(store);
        // TODO: build this via REST
        //orderService.createOrder(order);
        return "redirect:/";
    }
}
