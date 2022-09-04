package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.Contact;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.repositories.ContactRepository;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserService userService;

    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    public List<Contact> getContactsFromUser(Integer id){
        return contactRepository.findContactByUser_Id(id);
    }

    public Contact getContactById(Integer id){
        return contactRepository.findById(id).isPresent()?contactRepository.findById(id).get():null;
    }

    public Contact getContactByIds(Integer idU,Integer idC){
        return contactRepository.findContactByUserIdAndCollaboratorId(idU,idC);
    }

    public Contact createContact(Integer idU,Integer idC){
        if(this.getContactByIds(idC, idU)==null){
            contactRepository.save(new Contact( userService.getUserById(idC),userService.getUserById(idU)));
        }
        Contact contactU = this.getContactByIds(idU, idC);
        if(contactU!=null){
            return contactU;
        }
        return contactRepository.save(new Contact( userService.getUserById(idU),userService.getUserById(idC)));
    }

    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }

    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }

    public void deleteByIds(Integer idU, Integer idC){
        Contact contactC = this.getContactByIds(idC, idU);
        if(contactC!=null){
            contactRepository.delete(contactC);
        }
        contactRepository.delete(this.getContactByIds(idU,idC));
    }

}
