package app.servicesImpl;

import app.entities.Role;
import app.entities.User;
import app.repositories.UserRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser(String username, String password) {
        User user = this.userRepository.findUser(username, password);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Such user not exists");
        }
        return toUser(user);
    }

    private UserDetails toUser(User user) {
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().getRole())
                .build();
    }


    public User findByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        return user;
    }

    @Override
    public void setRole(Role role, long userId) {
        this.userRepository.setRole(role, userId);
    }


}
