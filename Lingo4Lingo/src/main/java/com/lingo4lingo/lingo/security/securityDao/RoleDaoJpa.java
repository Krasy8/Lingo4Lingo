package com.lingo4lingo.lingo.security.securityDao;

import com.lingo4lingo.lingo.security.securityModel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDaoJpa extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);

    @Override
    void delete(Role role);
}
