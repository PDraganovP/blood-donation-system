package app.controllers;

import app.entities.Role;
import app.entities.User;
import app.repositories.BloodDonationCenterRepository;
import app.services.RoleService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BloodDonationCenterRepository bloodDonationCenterRepository;

    @GetMapping("/menu-admin")
    public String getMenuAdmin() {
        return "users/user";
    }


    @PostMapping("/menu-admin")
    public String getMenuAdmin(Model model, String username) {
        User user = this.userService.findByUsername(username);
       /* String roleName = user.getRole().getRole();*/
        if (user == null || user.getRole().getRole() == null) {
            return "users/user";
        }
        model.addAttribute("user", user);
        List<Role> roles = this.roleService.findAll();
        model.addAttribute("roles", roles);

        return "users/user";
    }

    @PostMapping("/change-role")
    public String changeRole(@RequestParam("username") String username, Model model, String role) {
        User user = this.userService.findByUsername(username);
        if (user == null) {
            return "users/user";
        }
        Role newRole = this.roleService.findByRoleName(role);
        this.userService.setRole(newRole, user.getId());
        user.getRole().setRole(role);
        model.addAttribute("user", user);
        List<Role> roles = this.roleService.findAll();
        model.addAttribute("roles", roles);

        return "users/user";
    }

}
