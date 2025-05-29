package com.dnu.edu.ua.test.security;

import com.dnu.edu.ua.test.entities.User;
import com.dnu.edu.ua.test.entities.UserRole;
import com.dnu.edu.ua.test.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class MemberUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                    roleToAuthorities(user.getRole()));
        } else {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
    }
    private Collection<? extends GrantedAuthority> roleToAuthorities(UserRole userRole) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRoleName());
        return Collections.singletonList(authority);
    }
}
