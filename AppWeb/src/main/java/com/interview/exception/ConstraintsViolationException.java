package com.interview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "user has been already registered.")
public class ConstraintsViolationException extends Exception
{

    static final long serialVersionUID = -3387516993224229948L;


    public ConstraintsViolationException(String message)
    {
        super(message);
    }

}
