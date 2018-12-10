package com.interview.datatransferobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.function.Consumer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class UserDTOValidationTest
{

    private Validator validator;


    @Before
    public void setUp()
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void invalidUsernameUserDTOTest()
    {
        UserDTO userDTO = new UserDTO(1L, "maclean 123", "MACxav1233", "1991-01-15T18:25:43.511Z", "242344569");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        violations.stream().forEach(new Consumer<ConstraintViolation<UserDTO>>()
        {

            @Override
            public void accept(ConstraintViolation<UserDTO> voilation)
            {
                assertEquals("username must be alphanumerical, no spaces", voilation.getMessage());

            }

        });
    }


    @Test
    public void invalidPasswordMissingUpperCaseLetterUserDTOTest()
    {
        UserDTO userDTO = new UserDTO(1L, "maclean123", "xav1233", "1991-01-15T18:25:43.511Z", "242344569");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        violations.stream().forEach(new Consumer<ConstraintViolation<UserDTO>>()
        {

            @Override
            public void accept(ConstraintViolation<UserDTO> voilation)
            {
                assertEquals("Password must contain 1 or more uppercase characters.", voilation.getMessage());

            }

        });
    }


    @Test
    public void invalidPasswordMissingDigitUserDTOTest()
    {
        UserDTO userDTO = new UserDTO(1L, "maclean", "MACxav", "1991-01-15T18:25:43.511Z", "242344569");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        violations.stream().forEach(new Consumer<ConstraintViolation<UserDTO>>()
        {

            @Override
            public void accept(ConstraintViolation<UserDTO> voilation)
            {
                assertEquals("Password must contain 1 or more digit characters.", voilation.getMessage());

            }

        });
    }


    @Test
    public void invalidPasswordMustHaveMinFourCharactersDTOTest()
    {
        UserDTO userDTO = new UserDTO(1L, "maclean", "MAC", "1991-01-15T18:25:43.511Z", "242344569");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        violations.stream().forEach(new Consumer<ConstraintViolation<UserDTO>>()
        {

            @Override
            public void accept(ConstraintViolation<UserDTO> voilation)
            {
                assertEquals("Password must be 4 or more characters in length.,Password must contain 1 or more digit characters.", voilation.getMessage());

            }

        });
    }


    @Test
    public void validUserDTOTest()
    {
        UserDTO userDTO = new UserDTO(1L, "maclean123", "MACxav123", "1991-01-15T18:25:43.511Z", "242344569");
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);
        assertTrue(violations.isEmpty());
    }

}
