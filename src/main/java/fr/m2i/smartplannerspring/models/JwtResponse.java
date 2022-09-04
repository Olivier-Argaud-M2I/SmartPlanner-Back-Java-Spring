package fr.m2i.smartplannerspring.models;


import fr.m2i.smartplannerspring.dtos.UserDto;

public class JwtResponse {

    private UserDto user;
    private String jwToken;

    public JwtResponse(UserDto user, String jwToken) {
        this.user = user;
        this.jwToken = jwToken;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getJwToken() {
        return jwToken;
    }

    public void setJwToken(String jwToken) {
        this.jwToken = jwToken;
    }
}
