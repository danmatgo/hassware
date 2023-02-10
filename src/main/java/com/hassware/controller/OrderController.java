package com.hassware.controller;

import com.hassware.domain.Order;
import com.hassware.service.OrderService;
import com.hassware.util.pager.PageRender;
import com.hassware.util.report.OrderExcelExporter;
import com.hassware.util.report.OrderPdfExporter;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    // Listing orders
    @GetMapping({"/orders"})
    public String Order(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 10);
        Page<Order> orders = orderService.findAll(pageRequest);
        PageRender<Order> pageRender = new PageRender<>("/orders", orders);

        model.addAttribute("title", "Listado de Pedidos");
        model.addAttribute("orders", orders);
        model.addAttribute("page", pageRender);
        return "orders";
    }

    @GetMapping("/orderform")
    public String ShowOrderForm(Map<String, Object> model) {
        Order order = new Order();
        model.put("order", order);
        model.put("title", "Crear Nuevo Pedido");
        return "orderform";
    }

    // Save an order
    @PostMapping("/orderform")
    public String SaveOrder(@Valid Order order, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Crear Pedido");
            return "orderform";
        }

        orderService.save(order);
        status.setComplete();
        return "redirect:/orders";
    }

    // Edit an order
    @GetMapping("/orderform/{id}")
    public String EditOrder(@PathVariable(value = "id") Integer idorder, Map<String, Object> model) {
        Order order = null;
        if (idorder > 0) {
            order = orderService.findOne(idorder);
            if (order == null) {
                return "redirect:/orders";
            }
        } else {
            return "redirect:/orders";
        }

        model.put("order", order);
        model.put("title", "Editar Pedido");
        return "orderform";
    }

    // Delete order
    @GetMapping("/deleteorder/{id}")
    public String DeleteOrder(@PathVariable(value = "id") Integer idorder) {
        if (idorder > 0) {
            orderService.delete(idorder);
        }
        return "redirect:/orders";
    }

    // Export orders list
    @GetMapping("/order_pdfexport")
    public void OrderPdfExport(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormatter.format(new Date());

        String header = "Content-Disposition";
        String value = "attachment; filename=ListadoPedidos" + currentDate + ".pdf";

        response.setHeader(header, value);

        List<Order> order = orderService.findAll();

        OrderPdfExporter exporter = new OrderPdfExporter(order);
        exporter.export(response);
    }

    // Export orders excel file
    @GetMapping("/order_excelexport")
    public void OrderExcelExport(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormatter.format(new Date());

        String header = "Content-Disposition";
        String value = "attachment; filename=ListadoPedidos_" + currentDate + ".xlsx";

        response.setHeader(header, value);

        List<Order> order = orderService.findAll();

        OrderExcelExporter exporter = new OrderExcelExporter(order);
        exporter.export(response);
    }
}
