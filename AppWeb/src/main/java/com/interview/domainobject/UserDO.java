package com.interview.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.interview.validation.ValidPassword;

@Entity
@Table(
    name = "user",
    uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"}))
public class UserDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "username can not be null!")
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "password can not be null!")
    @ValidPassword
    private String password;

    @Column(nullable = false)
    @NotNull(message = "date can not be null!")
    private String dateOfBirth;

    @Column(nullable = false)
    @NotNull(message = "social security number can not be null!")
    @Size(min = 9, max = 9, message = "SSN must be 9 a digit number")
    @Pattern(regexp = "[\\d]{9}", message = "SSN must be 9 a digit number")
    private String socialSecNo;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateUpdated = ZonedDateTime.now();

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();


    public UserDO(String username, String password, String dateOfBirth, String socialSecNo)
    {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.socialSecNo = socialSecNo;
    }


    private UserDO()
    {

    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }


    public String getDateOfBirth()
    {
        return dateOfBirth;
    }


    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }


    public String getSocialSecNo()
    {
        return socialSecNo;
    }


    public void setSocialSecNo(String socialSecNo)
    {
        this.socialSecNo = socialSecNo;
    }

}
