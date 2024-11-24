package com.gitdemo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitDto {
	//private Integer id;
	private String name;
	private String command;
	private String example;
	private String description;
	
//	@Override
//	public String toString() {
//		return "{ "
//				+ "id = "+this.id+"\n"
//				+"name = "+this.name+"\n"
//				+"command = "+this.command+"\n"
//				+"description = "+this.description
//				+ " }";
//	}
}
