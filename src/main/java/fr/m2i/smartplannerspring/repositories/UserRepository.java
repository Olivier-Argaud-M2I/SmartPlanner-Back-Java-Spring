package fr.m2i.smartplannerspring.repositories;

import fr.m2i.smartplannerspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUserName(String username);

}
