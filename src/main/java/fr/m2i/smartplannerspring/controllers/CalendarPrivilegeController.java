package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.CalendarPrivilege;
import fr.m2i.smartplannerspring.services.CalendarPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendarPrivileges")
public class CalendarPrivilegeController {

    @Autowired
    CalendarPrivilegeService  calendarPrivilegeService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CalendarPrivilege> getCalendarPrivileges(){
        return calendarPrivilegeService.getCalendarPrivileges();
    }


    @GetMapping(
            path = "/privilege/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CalendarPrivilege getCalendarPrivileges(@PathVariable("id")Integer id){
        return calendarPrivilegeService.getCalendarPrivilegeById(id);
    }

    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public CalendarPrivilege saveCalendarPrivilege(@RequestBody CalendarPrivilege calendarPrivilege){
        return calendarPrivilegeService.saveCalendarPrivilege(calendarPrivilege);
    }

    @PostMapping(
            path = "/delete/{id}"
    )
    public void deleteCalendarPrivilegeById(@PathVariable("id")Integer id){
        calendarPrivilegeService.deleteById(id);
    }





}
