package app.models.bindingModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BloodDonatorLoginModel {

    private String username;
    private String password;

    public BloodDonatorLoginModel() {
    }
    @NotNull
    @Size(min = 5, max = 50, message = "Потребителското име трябва да съдържа от 5 до 50 символа!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @NotNull
    @Size(min = 5, max = 40, message = "Паролата трябва да съдържа от 5 до 40 символа!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
