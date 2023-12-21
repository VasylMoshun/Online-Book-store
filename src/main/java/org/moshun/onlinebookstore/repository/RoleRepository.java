package org.moshun.onlinebookstore.repository;

import org.moshun.onlinebookstore.model.Role;
import org.moshun.onlinebookstore.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
