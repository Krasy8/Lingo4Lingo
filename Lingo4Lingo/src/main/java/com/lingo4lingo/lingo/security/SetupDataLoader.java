package com.lingo4lingo.lingo.security;

import com.lingo4lingo.lingo.security.securityDao.PrivilegeDaoJpa;
import com.lingo4lingo.lingo.security.securityDao.RoleDaoJpa;
import com.lingo4lingo.lingo.security.securityModel.Privilege;
import com.lingo4lingo.lingo.security.securityModel.Role;
import com.lingo4lingo.lingo.user.User;
import com.lingo4lingo.lingo.dao.UserDaoJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private final UserDaoJpa userDaoJpa;

    private final RoleDaoJpa roleDaoJpa;

    private final PrivilegeDaoJpa privilegeDaoJpa;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SetupDataLoader(
            UserDaoJpa userDaoJpa,
            RoleDaoJpa roleDaoJpa,
            PrivilegeDaoJpa privilegeDaoJpa,
            PasswordEncoder passwordEncoder
    ) {

        this.userDaoJpa = userDaoJpa;
        this.roleDaoJpa = roleDaoJpa;
        this.privilegeDaoJpa = privilegeDaoJpa;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        // creating initial privileges
        final Privilege adminRead = createPrivilegeIfNotFound("ADMIN_READ");
        final Privilege adminWrite = createPrivilegeIfNotFound("ADMIN_WRITE");
        final Privilege userRead = createPrivilegeIfNotFound("USER_READ");
        final Privilege userWrite = createPrivilegeIfNotFound("USER_WRITE");
        final Privilege viewerRead = createPrivilegeIfNotFound("VIEWER_READ");

        // creating initial roles
        final Collection<Privilege> adminPrivileges = Arrays.asList(adminRead, adminWrite);
        final Collection<Privilege> userPrivileges = Arrays.asList(userRead, userWrite);
        final Role defaultAdminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        // creating initial user (admin)
        createDefaultAdminIfNotFound(new ArrayList<>(Arrays.asList(defaultAdminRole)));
        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(final String privilegeName) {
        Privilege privilege = privilegeDaoJpa.findPrivilegeByName(privilegeName);
        if (privilege == null) {
            privilege = new Privilege(privilegeName);
            privilegeDaoJpa.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(final String roleName, final Collection<Privilege> privileges) {
        Role role = roleDaoJpa.findRoleByName(roleName);
        if (role == null) {
            role = new Role(roleName, privileges);
            roleDaoJpa.save(role);
        }
        return role;
    }

    @Transactional
    void createDefaultAdminIfNotFound(final Collection<Role> roles) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 0, 1);
        Date birthDate = calendar.getTime();

        User defaultAdmin = userDaoJpa.findByEmail("admin@test.com");
        if (defaultAdmin == null) {
            defaultAdmin = new User();
            defaultAdmin.setLogin("admin");
            defaultAdmin.setPassword(passwordEncoder.encode("adminPassword"));
            defaultAdmin.setEmail("admin@test.com");
            defaultAdmin.setGender(User.Gender.valueOf("MALE"));
            defaultAdmin.setDateOfBirth(birthDate);
            defaultAdmin.setCountryOfResidence("United Kingdom");
            defaultAdmin.setCityOfResidence("London");
            defaultAdmin.setLanguageNative1("Polish");
            defaultAdmin.setLanguageSpoken1("English");
            defaultAdmin.setLanguageToLearn("Spanish");
            defaultAdmin.setEnabled(true);
        }
        defaultAdmin.setRoles(roles);
        defaultAdmin.setTokenExpired(false);
        userDaoJpa.save(defaultAdmin);
    }
}
