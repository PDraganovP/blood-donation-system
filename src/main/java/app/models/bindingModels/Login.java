package app.models.bindingModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
    private String username;
    private String password;

    public Login() {
    }
    @Size(min=5,max=50,message = "Потребителското име трябва да е между 5 и 50 символа")
    @NotNull()
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Size(min=5,max=25,message = "Паролата трябва да е между 5 и 25 символа")
    @NotNull()
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
