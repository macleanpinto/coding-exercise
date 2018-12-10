package com.interview.service.exclusion;

import org.springframework.stereotype.Service;

@Service
public class DefaultExclusionService implements ExclusionService
{

    // Stubbed service to blacklist all user's with SSN greater than 555555555
    @Override
    public boolean validate(String dob, String ssn)
    {
        return Integer.parseInt(ssn) > 555555555;
    }

}
