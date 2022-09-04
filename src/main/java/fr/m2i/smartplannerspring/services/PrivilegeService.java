package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.Privilege;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.repositories.PrivilegeRepository;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    public List<Privilege> getPrivileges(){
        return privilegeRepository.findAll();
    }

    public Privilege getPrivilegeById(Integer id){
        return privilegeRepository.findById(id).isPresent()?privilegeRepository.findById(id).get():null;
    }

    public Privilege savePrivilege(Privilege privilege){
        return privilegeRepository.save(privilege);
    }

    public void deletePrivilege(Privilege privilege){
        privilegeRepository.delete(privilege);
    }

    public void deleteById(Integer id){
        privilegeRepository.deleteById(id);
    }

}
