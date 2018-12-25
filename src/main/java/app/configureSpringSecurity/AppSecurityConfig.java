package app.configureSpringSecurity;

import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/blood-donation-center", "/blood-donors",
                        "/blood-groups", "/blood-recipients", "/blood-testing",
                        "/blood-transfusion", "/", "/blood-donator-register",
                        "/blood-donation-center-register", "/unauthorized").permitAll()
                .antMatchers("/menu-admin", "/change-role").hasRole("ADMIN")
                .antMatchers("/blood-donator-info", "/edit-blood-donator")
                .access("hasRole('ADMIN') or hasRole('BLOOD DONATOR')")
                .antMatchers("/find-blood-donation-center-by-username",
                        "/blood-donation-center-info", "/edit-blood-donation-center",
                        "/find-blood-donator-by-first-name", "/find-blood-donator-by-username",
                        "/find-blood-donator-by-city", "/blood-donator-id",
                        "/add-blood-donation")
                .access("hasRole('ADMIN') or hasRole('BLOOD DONATION CENTER')")
                .and().formLogin().loginPage("/login").permitAll()
                .passwordParameter("password")
                .usernameParameter("username")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(getBCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
