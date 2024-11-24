package com.gitdemo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gitdemo.api.model.Git;

@Repository
public interface GitRepository extends JpaRepository<Git, Integer> {
	
}
