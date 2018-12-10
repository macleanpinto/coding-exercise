package com.interview.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.interview.dataaccessobject.UserRepository;
import com.interview.domainobject.UserDO;
import com.interview.exception.ConstraintsViolationException;
import com.interview.exception.UserBlacklistedException;
import com.interview.service.exclusion.ExclusionService;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic.
 * <p/>
 */
@Service
public class DefaultUserService implements UserService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

    private final ExclusionService exclusionService;

    private final UserRepository userRepository;


    @Autowired
    public DefaultUserService(final UserRepository userRepository, final ExclusionService exclusionService)
    {
        this.userRepository = userRepository;
        this.exclusionService = exclusionService;
    }


    /**
     * Registration Service
     *
     * @param UserDO
     * @throws ConstraintsViolationException
     *             if a user already exists with the given username
     * @throws UserBlacklistedException
     *             if a user is blacklisted
     */
    @Override
    public UserDO register(UserDO userDO) throws ConstraintsViolationException, UserBlacklistedException
    {
        boolean isUserBlacklisted = this.exclusionService.validate(userDO.getDateOfBirth(), userDO.getSocialSecNo());
        if (isUserBlacklisted)
        {

            LOG.warn("User is blacklisted: {}", userDO);
            throw new UserBlacklistedException("User is black listed");

        }
        UserDO user;
        try
        {
            user = userRepository.save(userDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while registration: {}", userDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return user;
    }

}
