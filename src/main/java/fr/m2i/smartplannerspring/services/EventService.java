package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.Event;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.repositories.EventRepository;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(Integer id){
        return eventRepository.findById(id).isPresent()?eventRepository.findById(id).get():null;
    }

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }

    public void deleteEvent(Event event){
        eventRepository.delete(event);
    }

    public void deleteById(Integer id){
        eventRepository.deleteById(id);
    }

}
