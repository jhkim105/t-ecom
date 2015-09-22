package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.User;
import demo.service.UserManager;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Long id) {
		return userManager.get(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User add(User user) {
		return userManager.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		userManager.delete(id);
	}

}
