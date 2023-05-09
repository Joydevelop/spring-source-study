package com.joy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Joy
 */
@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/getUser")
	@ResponseBody
	public String getUser() {
		return "user";
	}
}
