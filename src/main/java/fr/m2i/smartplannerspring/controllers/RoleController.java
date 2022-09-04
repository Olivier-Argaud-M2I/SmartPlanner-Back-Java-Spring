package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.Role;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.services.RoleService;
import fr.m2i.smartplannerspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;


    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Role> getRoles(){
        return roleService.getRoles();
    }


    @GetMapping(
            path = "/role/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Role getRoleById(@PathVariable("id")Integer id){
        return roleService.getRoleById(id);
    }

    @PostMapping(
            path = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Role saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }

    @PostMapping(
            path = "/delete/{id}"
    )
    public void deleteRoleById(@PathVariable("id")Integer id){
        roleService.deleteById(id);
    }





}
