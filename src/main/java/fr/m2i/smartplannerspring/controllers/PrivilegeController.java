package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.Privilege;
import fr.m2i.smartplannerspring.entities.Role;
import fr.m2i.smartplannerspring.services.PrivilegeService;
import fr.m2i.smartplannerspring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privileges")
public class PrivilegeController {

    @Autowired
    PrivilegeService privilegeService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Privilege> getPrivileges(){
        return privilegeService.getPrivileges();
    }


    @GetMapping(
            path = "/privilege/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Privilege getPrivilegeById(@PathVariable("id")Integer id){
        return privilegeService.getPrivilegeById(id);
    }

    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Privilege savePrivilege(@RequestBody Privilege privilege){
        return privilegeService.savePrivilege(privilege);
    }

    @PostMapping(
            path = "/delete/{id}"
    )
    public void deletePrivilegeById(@PathVariable("id")Integer id){
        privilegeService.deleteById(id);
    }





}
