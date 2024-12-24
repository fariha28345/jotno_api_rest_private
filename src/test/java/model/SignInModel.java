package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInModel {
    private String userType;
    private String doctorType;
    private String username;
    private String password;

    public SignInModel(String userType, String doctorType, String username, String password) {
        this.userType = userType;
        this.doctorType = doctorType;
        this.username = username;
        this.password = password;
    }

    public SignInModel() {

    }
}
