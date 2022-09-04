package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).isPresent()?userRepository.findById(id).get():null;
    }

//    public User getUserByName(String username){
//        return userRepository.findByUserName(username);
//    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}
