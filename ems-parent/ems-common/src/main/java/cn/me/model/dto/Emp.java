package cn.me.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Emp
{
	private String id;

	private String name;

	private String path;

	private String salary;

	private Integer age;
}
