package fr.m2i.smartplannerspring.services;

import fr.m2i.smartplannerspring.entities.CalendarPrivilege;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.repositories.CalendarPrivilegeRepository;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarPrivilegeService {

    @Autowired
    CalendarPrivilegeRepository calendarPrivilegeRepository;

    public List<CalendarPrivilege> getCalendarPrivileges(){
        return calendarPrivilegeRepository.findAll();
    }

    public CalendarPrivilege getCalendarPrivilegeById(Integer id){
        return calendarPrivilegeRepository.findById(id).isPresent()?calendarPrivilegeRepository.findById(id).get():null;
    }

    public CalendarPrivilege saveCalendarPrivilege(CalendarPrivilege calendarPrivilege){
        return calendarPrivilegeRepository.save(calendarPrivilege);
    }

    public void deleteCalendarPrivilege(CalendarPrivilege calendarPrivilege){
        calendarPrivilegeRepository.delete(calendarPrivilege);
    }

    public void deleteById(Integer id){
        calendarPrivilegeRepository.deleteById(id);
    }

}
