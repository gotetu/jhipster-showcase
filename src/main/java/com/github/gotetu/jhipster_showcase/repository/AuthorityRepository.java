package com.github.gotetu.jhipster_showcase.repository;

import com.github.gotetu.jhipster_showcase.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
