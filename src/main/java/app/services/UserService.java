package app.services;

import app.entities.Role;
import app.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User findUser(String username, String password);

    User findByUsername(String username);

    void setRole(Role role, long userId);
}
