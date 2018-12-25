package app.servicesImpl;

import app.entities.Role;
import app.repositories.RoleRepository;
import app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(long id) {
        Role role = this.roleRepository.findById(id);
        return role;
    }

    @Override
    public Role findByRoleName(String roleName) {
        Role role = this.roleRepository.findByRole(roleName);
        return role;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = (List<Role>) this.roleRepository.findAll();
        return roles;
    }
}
