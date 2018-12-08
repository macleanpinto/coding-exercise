package com.interview.domainobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

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
    private String username;

    @Column(nullable = false)
    @NotNull(message = "password can not be null!")
    private String password;

    @Column(nullable = false)
    @NotNull(message = "date can not be null!")
    private Date dateOfBirth;

    @Column(nullable = false)
    @NotNull(message = "social security number can not be null!")
    private String socialSecNo;


    private UserDO()
    {

    }


    public UserDO(String username, String password, Date dateOfBirth, String socialSecNo)
    {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.socialSecNo = socialSecNo;
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


    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }


    public void setDateOfBirth(Date dateOfBirth)
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
