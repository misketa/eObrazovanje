package com.eObrazovanje.eObrazovanje.repository;


import com.eObrazovanje.eObrazovanje.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
