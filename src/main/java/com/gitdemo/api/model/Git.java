package com.gitdemo.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Git {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String command;
	private String example;
	private String description;
	
	@Override
	public String toString() {
		return "Git{ "
				+ "id = "+this.id+"\n"
				+"name = "+this.name+"\n"
				+"command = "+this.command+"\n"
				+"description = "+this.description
				+ " }";
	}
}
