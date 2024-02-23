package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.domain.Role;

@Repository(value = "repository_role")
public interface RoleRepository extends JpaRepository<Role, Long> {

}
