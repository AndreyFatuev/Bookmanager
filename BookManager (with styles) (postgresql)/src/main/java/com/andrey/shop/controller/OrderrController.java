package com.andrey.shop.controller;

import com.andrey.shop.model.Orderr;
import com.andrey.shop.service.OrderrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderrController {
    private OrderrService orderrService;

    @Autowired(required = true)
    @Qualifier(value = "orderrService")
    public void setBookService(OrderrService bookService) {
        this.orderrService = bookService;
    }

    @RequestMapping(value = "orderr", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("book", new Orderr());
        model.addAttribute("listBooks", this.orderrService.listClients());
        return "orderr";
    }


    @RequestMapping(value = "/orderr/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Orderr client){
            this.orderrService.addClient(client);
            this.orderrService.updateClient(client);
        return "redirect:/orderr";
    }

    @RequestMapping("/removeorderr/{id_orderr}")
    public String removeBook(@PathVariable("id_orderr") int id){
        this.orderrService.removeClient(id);
        return "redirect:/orderr";
    }

    @RequestMapping("editorderr/{id_orderr}")
    public String editBook(@PathVariable("id_orderr") int id, Model model){
        model.addAttribute("book", this.orderrService.getClientById(id));
        model.addAttribute("listBooks", this.orderrService.listClients());
        return "orderr";
    }


}
