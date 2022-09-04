package fr.m2i.smartplannerspring.controllers;


import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.models.JwtRequest;
import fr.m2i.smartplannerspring.models.JwtResponse;
import fr.m2i.smartplannerspring.repositories.UserRepository;
import fr.m2i.smartplannerspring.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;

    @PostMapping(
            path = "/log",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public JwtResponse login(@RequestBody JwtRequest jwtRequest){

        try{
            User user1 = userRepository.findByUserName(jwtRequest.getUserName());
            if(jwtRequest.getPassword().equals(user1.getPassword())){

//                return new UserDto(user1);
                return jwtService.createJwtToken(user1);
            }
            return null;
        }
        catch (Exception e){
            return null;
        }

    }
}
