package com.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User is black listed.")
public class UserBlacklistedException extends Exception
{
    static final long serialVersionUID = -3387516993334229948L;


    public UserBlacklistedException(String message)
    {
        super(message);
    }

}
