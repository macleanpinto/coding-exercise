package com.interview.controller.mapper;

import com.interview.datatransferobject.UserDTO;
import com.interview.datatransferobject.UserDTO.UserDTOBuilder;
import com.interview.domainobject.UserDO;

public class UserMapper
{
    private UserMapper()
    {

    }


    public static UserDO makeUserDO(UserDTO userDTO)
    {
        return new UserDO(userDTO.getUsername(), userDTO.getPassword(), userDTO.getDateOfBirth(), userDTO.getSocialSecNo());
    }


    public static UserDTO makeUserDTO(UserDO userDO)
    {
        UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
            .setId(userDO.getId())
            .setUsername(userDO.getUsername())
            .setPassword(userDO.getPassword())
            .setDateOfBirth(userDO.getDateOfBirth())
            .setSocialSecNo(userDO.getSocialSecNo());

        return userDTOBuilder.createUserDTO();
    }

}
