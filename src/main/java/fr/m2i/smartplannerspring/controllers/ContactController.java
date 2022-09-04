package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.Contact;
import fr.m2i.smartplannerspring.entities.Event;
import fr.m2i.smartplannerspring.services.ContactService;
import fr.m2i.smartplannerspring.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Contact> getContacts(){
        return contactService.getContacts();
    }


    @GetMapping(
            path = "/user/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Contact> getContactsFromUser(@PathVariable("id") Integer id){
        return contactService.getContactsFromUser(id);
    }



    @GetMapping(
            path = "/contact/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Contact getContactById(@PathVariable("id")Integer id){
        return contactService.getContactById(id);
    }

    @GetMapping(
            path = "/contact/{idU}/{idC}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Contact getContactByIds(@PathVariable("idU")Integer idU,@PathVariable("idC")Integer idC){
        return contactService.getContactByIds(idU,idC);
    }

    @PostMapping(
            path = "/create/{idU}/{idC}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Contact createContactByIds(@PathVariable("idU")Integer idU,@PathVariable("idC")Integer idC){
        return contactService.createContact(idU,idC);
    }


    @PostMapping(
            path = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @PostMapping(
            path = "/delete/{idU}/{idC}"
    )
    public void deleteContactById(@PathVariable("idU")Integer idU,@PathVariable("idC")Integer idC){
        contactService.deleteByIds( idU,idC);
    }





}
