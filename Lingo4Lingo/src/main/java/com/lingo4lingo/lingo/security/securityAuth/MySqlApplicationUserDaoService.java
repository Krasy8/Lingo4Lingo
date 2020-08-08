package com.lingo4lingo.lingo.security.securityAuth;

import com.lingo4lingo.lingo.dao.UserDaoJpa;
import com.lingo4lingo.lingo.security.securityModel.Privilege;
import com.lingo4lingo.lingo.security.securityModel.Role;
import com.lingo4lingo.lingo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlApplicationUserDaoService implements ApplicationUserDao {

    private final UserDaoJpa userDaoJpa;

    @Autowired
    public MySqlApplicationUserDaoService(UserDaoJpa userDaoJpa) {
        this.userDaoJpa = userDaoJpa;
    }

    @Override
    public ApplicationUser selectApplicationUserByLogin(String login) {
        try {
            final User user = userDaoJpa.findByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException(
                        "Nice try, buddy but I can't find anybody with the login: " + login + " here... Please try again."
                );
            }
            return new ApplicationUser(
                    user.getLogin(),
                    user.getPassword(),
                    getAuthorities(user.getRoles()),
                    true,
                    true,
                    true,
                    user.isEnabled()

            );
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
