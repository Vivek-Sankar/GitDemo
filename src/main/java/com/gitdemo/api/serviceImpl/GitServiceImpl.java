package com.gitdemo.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gitdemo.api.exceptions.GitExceptions;
import com.gitdemo.api.mapper.GitMapper;
import com.gitdemo.api.model.Git;
import com.gitdemo.api.model.GitDto;
import com.gitdemo.api.repository.GitRepository;
import com.gitdemo.api.service.GitService;

@Service
public class GitServiceImpl implements GitService {
	
	@Autowired
	GitRepository gitRepository;
	
	@Autowired
	GitMapper gitMapper;
	
	@Override
	public ResponseEntity<List<GitDto>> getAllGit(){
		List<Git> gitList = gitRepository.findAll();
		return new ResponseEntity<List<GitDto>>(gitMapper.toGitDtoList(gitList), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<GitDto> createGit(GitDto gitDto) {
		Git git = gitMapper.toGit(gitDto);
		Git gitReturnVal = gitRepository.save(git);
		GitDto gitDtoResponse = gitMapper.toGitDto(gitReturnVal);
		return new ResponseEntity<GitDto>(gitDtoResponse,HttpStatus.CREATED);
		//Below, The same code in a single line
		//return new ResponseEntity<GitDto> (gitMapper.toGitDto(gitRepository.save(gitMapper.toGit(gitDto))),HttpStatus.CREATED);
		
	}

	@Override
	public ResponseEntity<String> deleteGit(Integer id) {
		Git git = gitRepository.findById(id).orElseThrow(()->new GitExceptions("There's no such Git data found for id: "+id, HttpStatus.NOT_FOUND));
		if(git!=null) {
			gitRepository.deleteById(id);
			return new ResponseEntity<String>("Succesfully deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Issue with delete opration",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<GitDto> updateGit(Integer id, GitDto gitDto) {
		Git git = gitRepository.findById(id).orElseThrow(()->new GitExceptions("No Git data found for id : "+id, HttpStatus.NOT_FOUND));
		if(git!=null) {
			git.setCommand(gitDto.getCommand());
			git.setDescription(gitDto.getDescription());
			git.setExample(gitDto.getExample());
			git.setName(gitDto.getName());
			return new ResponseEntity<GitDto>(gitMapper.toGitDto(gitRepository.save(git)),HttpStatus.OK);
		}
		return null;
	}
}