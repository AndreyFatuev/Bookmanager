package com.andrey.shop.controller;

import com.andrey.shop.model.Client;
import com.andrey.shop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private ClientService clientService;

    @Autowired(required = true)
    @Qualifier(value = "clientService")
    public void setBookService(ClientService bookService) {
        this.clientService = bookService;
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public String listClients(Model model){
        model.addAttribute("book", new Client());
        model.addAttribute("listClients", this.clientService.listClients());
        return "clients";
    }

    @RequestMapping(value = "/clients/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Client client){
        //if (client = null) throw new Or
        if(client.getId() == 0){
            this.clientService.addClient(client);
            return "redirect:/clients";
        }else {
            this.clientService.updateClient(client);
            return "redirect:/clients";
        }
    }

    @RequestMapping("/removeclient/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.clientService.removeClient(id);
        return "redirect:/clients";
    }

    @RequestMapping("editclient/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.clientService.getClientById(id));
        model.addAttribute("listClients", this.clientService.listClients());
        return "clients";
    }

    @RequestMapping("clientdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.clientService.getClientById(id));
        return "clientdata";
    }

}
