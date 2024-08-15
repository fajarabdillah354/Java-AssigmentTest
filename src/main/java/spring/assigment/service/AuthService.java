package spring.assigment.service;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class AuthService {

    public void logout() {
        SecurityContextHolder.clearContext();
    }


}
