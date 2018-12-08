package com.interview.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.dataaccessobject.UserRepository;
import com.interview.domainobject.UserDO;
import com.interview.exception.ConstraintsViolationException;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some car specific things.
 * <p/>
 */
@Service
public class DefaultUserService implements UserService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);
    @Autowired
    private UserRepository userRepository;


    /**
     * Creates a new User.
     *
     * @param UserDO
     * @throws ConstraintsViolationException
     *             if a user already exists with the given username
     */
    @Override
    public UserDO create(UserDO userDO) throws ConstraintsViolationException
    {
        UserDO user;
        try
        {
            user = userRepository.save(userDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a user: {}", userDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return user;
    }

}
