package com.instrument.repository;

import org.springframework.data.repository.CrudRepository;

import com.instrument.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
