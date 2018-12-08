package com.interview.service.user;

import com.interview.domainobject.UserDO;
import com.interview.exception.ConstraintsViolationException;

public interface UserService
{

    UserDO create(UserDO userDO) throws ConstraintsViolationException;

}
