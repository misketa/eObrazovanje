package com.eObrazovanje.eObrazovanje.repository;

import com.eObrazovanje.eObrazovanje.model.role.Role;
import com.eObrazovanje.eObrazovanje.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
