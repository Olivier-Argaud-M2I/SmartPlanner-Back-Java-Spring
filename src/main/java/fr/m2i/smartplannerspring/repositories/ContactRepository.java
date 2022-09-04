package fr.m2i.smartplannerspring.repositories;

import fr.m2i.smartplannerspring.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {


//    @Query(value = "SELECT * FROM contact WHERE user_id = :idU", nativeQuery = true)
//    List<Contact> findContactByUser_Id(Integer idU);

    List<Contact> findContactByUser_Id(Integer id);

    @Query(value = "SELECT * FROM contact WHERE user_id = :idU AND collab_id = :idC", nativeQuery = true)
    Contact findContactByUserIdAndCollaboratorId(Integer idU, Integer idC);


}
