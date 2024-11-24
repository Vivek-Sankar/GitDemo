package com.gitdemo.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.gitdemo.api.model.GitDto;

public interface GitService{
	ResponseEntity<List<GitDto>> getAllGit();

	ResponseEntity<GitDto> createGit(GitDto gitDto);

	ResponseEntity<String> deleteGit(Integer id);

	ResponseEntity<GitDto> updateGit(Integer id, GitDto gitDto);
}
