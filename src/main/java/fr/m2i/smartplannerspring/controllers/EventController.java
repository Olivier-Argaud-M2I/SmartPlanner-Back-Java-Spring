package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.Event;
import fr.m2i.smartplannerspring.entities.Privilege;
import fr.m2i.smartplannerspring.services.EventService;
import fr.m2i.smartplannerspring.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Event> getEvents(){
        return eventService.getEvents();
    }


    @GetMapping(
            path = "/event/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Event getEventById(@PathVariable("id")Integer id){
        return eventService.getEventById(id);
    }

    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Event saveEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @PostMapping(
            path = "/delete/{id}"
    )
    public void deleteEventById(@PathVariable("id")Integer id){
        eventService.deleteById(id);
    }





}
