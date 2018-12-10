package com.interview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.controller.mapper.UserMapper;
import com.interview.datatransferobject.UserDTO;
import com.interview.domainobject.UserDO;
import com.interview.exception.ConstraintsViolationException;
import com.interview.exception.UserBlacklistedException;
import com.interview.service.user.UserService;

/**
 * All operations with User will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/user")
public class UserController
{

    private final UserService userService;


    @Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO register(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException, UserBlacklistedException
    {
        UserDO userDO = UserMapper.makeUserDO(userDTO);
        return UserMapper.makeUserDTO(userService.register(userDO));
    }

}
