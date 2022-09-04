package fr.m2i.smartplannerspring.repositories;

import fr.m2i.smartplannerspring.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
