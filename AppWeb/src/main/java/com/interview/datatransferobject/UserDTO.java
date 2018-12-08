package com.interview.datatransferobject;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO
{

    @JsonIgnore
    private Long id;

    @NotNull(message = "username can not be null!")
    private String username;

    @NotNull(message = "password can not be null!")
    private String password;

    @NotNull(message = "date can not be null!")
    private Date dateOfBirth;

    @NotNull(message = "social security number can not be null!")
    private String socialSecNo;


    @JsonProperty
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


    private UserDTO()
    {}


    public UserDTO(Long id, String username, String password, Date dateOfBirth, String socialSecNo)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.socialSecNo = socialSecNo;
    }


    public static UserDTOBuilder newBuilder()
    {
        return new UserDTOBuilder();
    }

    public static class UserDTOBuilder
    {

        private Long id;

        private String username;

        private String password;

        private Date dateOfBirth;

        private String socialSecNo;


        public UserDTO createUserDTO()
        {
            return new UserDTO(id, username, password, dateOfBirth, socialSecNo);
        }


        public UserDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public UserDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public UserDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }


        public UserDTOBuilder setDateOfBirth(Date dateOfBirth)
        {
            this.dateOfBirth = dateOfBirth;
            return this;
        }


        public UserDTOBuilder setSocialSecNo(String socialSecNo)
        {
            this.socialSecNo = socialSecNo;
            return this;
        }

    }
}
