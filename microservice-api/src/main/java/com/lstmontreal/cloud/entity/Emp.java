package com.lstmontreal.cloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true)
public class Emp {
	private Long empno;
	private String lastName;
	private Long deptNo;
	private String dbname;
	public Emp(String name) {
		this.lastName = name;
	}
}
