package com.andrey.shop.controller;

import com.andrey.shop.model.Product;
import com.andrey.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setBookService(ProductService bookService) {
        this.productService = bookService;
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public String listProducts(Model model){
        model.addAttribute("book", new Product());
        model.addAttribute("listProducts", this.productService.listClients());
        return "product";
    }


    @RequestMapping("/removeproduct/{articul}")
    public String removeBook(@PathVariable("articul") int id){
        this.productService.removeClient(id);
        return "redirect:/product";
    }

    @RequestMapping("editproduct/{articul}")
    public String editBook(@PathVariable("articul") int id, Model model){
        model.addAttribute("book", this.productService.getClientById(id));
        model.addAttribute("listProducts", this.productService.listClients());
        return "product";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Product product){
            this.productService.addClient(product);
            this.productService.updateClient(product);
        return "redirect:/product";
    }
}
