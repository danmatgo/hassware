package com.hassware.controller;

import com.hassware.domain.Product;
import com.hassware.service.ProductService;
import com.hassware.util.pager.PageRender;
import com.hassware.util.report.ProductExcelExporter;
import com.hassware.util.report.ProductPdfExporter;
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
public class ProductController {

    @Autowired
    ProductService productService;

    // Listing products
    @GetMapping({"/products"})
    public String Product(@RequestParam(name = "page",defaultValue = "0") int page, Model model){
        Pageable pageRequest = PageRequest.of(page, 10);
        Page<Product> products = productService.findAll(pageRequest);
        PageRender<Product> pageRender = new PageRender<>("/product", products);

        model.addAttribute("title", "Listado de Productos");
        model.addAttribute("products", products);
        model.addAttribute("page", pageRender);
        return "products";
    }

    @GetMapping("/productform")
    public String showProductForm(Map<String,Object> model) {
        Product product = new Product();
        model.put("product", product);
        model.put("title", "Crear Nuevo Producto");
        return "productform";
    }

    // Save a product
    @PostMapping("/productform")
    public String saveProduct(@Valid Product product, BindingResult result, Model model, SessionStatus status){
        if (result.hasErrors()){
            model.addAttribute("title", "Crear Producto");
            return "productform";
        }

        productService.save(product);
        status.setComplete();
        return "redirect:/producst";
    }

    // Edit a product
    @GetMapping("/productform/{id}")
    public String editProduct(@PathVariable(value = "id") Integer idproduct, Map<String, Object> model) {
        Product product = null;
        if(idproduct > 0) {
            product = productService.findOne(idproduct);
            if(product == null) {
                return "redirect:/products";
            }
        }
        else {
            return "redirect:/products";
        }

        model.put("product", product);
        model.put("title", "Editar Producto");
        return "productform";
    }

    // Delete product
    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") Integer idproduct) {
        if(idproduct > 0) {
            productService.delete(idproduct);
        }
        return "redirect:/products";
    }

    // Export products list
    @GetMapping("/product_pdfexport")
    public void productPdfExport(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormatter.format(new Date());

        String header = "Content-Disposition";
        String value = "attachment; filename=ListadoProductos" + currentDate + ".pdf";

        response.setHeader(header, value);

        List<Product> product = productService.findAll();

        ProductPdfExporter exporter = new ProductPdfExporter(product);
        exporter.export(response);
    }

    // Export products excel file
    @GetMapping("/product_excelexport")
    public void productExcelExport(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormatter.format(new Date());

        String header = "Content-Disposition";
        String value = "attachment; filename=ListadoProductos" + currentDate + ".xlsx";

        response.setHeader(header, value);

        List<Product> product = productService.findAll();

        ProductExcelExporter exporter = new ProductExcelExporter(product);
        exporter.export(response);
    }
}
