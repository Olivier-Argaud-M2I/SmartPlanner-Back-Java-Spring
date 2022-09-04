package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.Role;
import fr.m2i.smartplannerspring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id){
        return roleRepository.findById(id).isPresent()?roleRepository.findById(id).get():null;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRole(Role role){
        roleRepository.delete(role);
    }

    public void deleteById(Integer id){
        roleRepository.deleteById(id);
    }

}
