package dto;

import lombok.Data;

@Data
public class User {
    private String firstname;
    private String lastname;
    private String pass;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String phoneNumber;
}
