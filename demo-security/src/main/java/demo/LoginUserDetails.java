package demo;

import org.springframework.security.core.authority.AuthorityUtils;

public class LoginUserDetails extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = -3568885757010981354L;

	public LoginUserDetails(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
	}
}
