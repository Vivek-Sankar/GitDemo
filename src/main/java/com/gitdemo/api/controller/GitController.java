package com.gitdemo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitdemo.api.model.Git;
import com.gitdemo.api.model.GitDto;
import com.gitdemo.api.service.GitService;

@RestController
@RequestMapping("/git")
public class GitController {
	
	@Autowired
	GitService gitService;
	
	@GetMapping("/getAllGit")
	public ResponseEntity<List<GitDto>> getAllGit(){
		return gitService.getAllGit();
	}
	//I wanted to add a view in UI which will get the Git command details from  the user and then pass it to create method.
	
	@PostMapping("/create")
	public ResponseEntity<GitDto> createGit(@RequestBody GitDto gitDto){
		return gitService.createGit(gitDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteGit(@PathVariable Integer id){
		return gitService.deleteGit(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<GitDto> updateGit(@PathVariable Integer id, @RequestBody GitDto gitDto){
		return gitService.updateGit(id, gitDto);
	}
	
}
