package com.lingo4lingo.lingo.security.securityDao;

import com.lingo4lingo.lingo.security.securityModel.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeDaoJpa extends JpaRepository<Privilege, Long> {

    Privilege findPrivilegeByName(String name);

    @Override
    void delete(Privilege privilege);
}
