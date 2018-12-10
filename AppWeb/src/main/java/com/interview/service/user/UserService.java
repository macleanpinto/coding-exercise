package com.interview.service.user;

import com.interview.domainobject.UserDO;
import com.interview.exception.ConstraintsViolationException;
import com.interview.exception.UserBlacklistedException;

public interface UserService
{

    UserDO register(UserDO userDO) throws ConstraintsViolationException, UserBlacklistedException;

}
