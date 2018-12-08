package com.interview.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interview.domainobject.UserDO;

/**
 * Database Access Object for user table.
 * <p/>
 */
@Repository
public interface UserRepository extends CrudRepository<UserDO, Long>
{

}
