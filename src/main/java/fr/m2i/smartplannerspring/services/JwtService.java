package fr.m2i.smartplannerspring.services;


import fr.m2i.smartplannerspring.dtos.UserDto;
import fr.m2i.smartplannerspring.entities.User;
import fr.m2i.smartplannerspring.models.JwtResponse;
import fr.m2i.smartplannerspring.utils.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


    private JwtUtil jwtUtil = new JwtUtil();


    public JwtResponse createJwtToken(User user) throws Exception {
        String newGeneratedToken = jwtUtil.generateToken(user);
        return new JwtResponse(new UserDto(user), newGeneratedToken);
    }



//    private Set getAuthority(Utilisateur user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//        });
//        return authorities;
//    }


}
