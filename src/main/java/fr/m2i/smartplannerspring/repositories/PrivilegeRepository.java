package fr.m2i.smartplannerspring.repositories;

import fr.m2i.smartplannerspring.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Integer> {
}
