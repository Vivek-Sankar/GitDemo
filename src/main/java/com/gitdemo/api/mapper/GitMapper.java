package com.gitdemo.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.gitdemo.api.model.Git;
import com.gitdemo.api.model.GitDto;

@Mapper(componentModel = "spring")
public interface GitMapper {
	Git toGit(GitDto gitDto);
	GitDto toGitDto(Git git);
	List<GitDto> toGitDtoList(List<Git> gitList);
}
