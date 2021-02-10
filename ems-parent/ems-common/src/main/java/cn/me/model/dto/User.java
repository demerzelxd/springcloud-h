package cn.me.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User
{
	private String id;

	private String username;

	private String realname;

	private String password;

	private String sex;

	private String status;

	private Date registerTime;
}
