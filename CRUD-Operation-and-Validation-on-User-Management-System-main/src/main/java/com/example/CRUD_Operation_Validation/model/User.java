package com.example.CRUD_Operation_Validation.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @NotEmpty
    @Column(name = "user_name")
    private String userName;
    @NotEmpty
    @Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-(\\d{4})")
    @Column(name = "user_dateOfBirth")
    private String dateOfBirth;
    @Email(message = "Entered user mail is not valid")
    @Column(name = "user_email")
    private String email;
    @NotEmpty
    @Pattern(message = "First two digits will be the country code and next remaining digits will be number",regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$")
    @Column(name = "user_PhoneNumber")
    private String userPhoneNumber;
    @Column(name = "user_date")
    private String date;
    @Column(name = "user_time")
    private String time;

}
