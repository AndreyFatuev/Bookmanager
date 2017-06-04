package com.andrey.shop.controller;

import com.andrey.shop.model.Orderr_product;
import com.andrey.shop.service.Orderr_productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Orderr_productController {
    private Orderr_productService orderr_productService;

    @Autowired(required = true)
    @Qualifier(value = "orderr_productService")
    public void setBookService(Orderr_productService bookService) {
        this.orderr_productService = bookService;
    }

    @RequestMapping(value = "orderr_products", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Orderr_product());
        model.addAttribute("listBooks", this.orderr_productService.listClients());
        return "orderr_products";
    }

    @RequestMapping(value = "/orderr_products/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Orderr_product client){
        if(client.getId_orderr_product() == 0){
            this.orderr_productService.addClient(client);
        }else {
            this.orderr_productService.updateClient(client);
        }
        return "redirect:/orderr_products";
    }

    @RequestMapping("/remove_orderr_products/{id_orderr_product}")
    public String removeBook(@PathVariable("id_orderr_product") int id){
        this.orderr_productService.removeClient(id);
        return "redirect:/orderr_products";
    }

    @RequestMapping("edit_orderr_products/{id_orderr_product}")
    public String editBook(@PathVariable("id_orderr_product") int id, Model model){
        model.addAttribute("book", this.orderr_productService.getClientById(id));
        model.addAttribute("listBooks", this.orderr_productService.listClients());
        return "orderr_products";
    }

/*    @RequestMapping("clientdata/{id_orderr_product}")
    public String bookData(@PathVariable("id_orderr_product") int id, Model model){
        model.addAttribute("book", this.orderr_productService.getClientById(id));
        return "clientdata";
    }*/
}
