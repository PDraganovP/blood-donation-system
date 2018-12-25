package app.services;

import app.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    Role findById(long id);

    Role findByRoleName(String roleName);

    List<Role> findAll();
}
