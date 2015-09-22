package demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

  private PasswordEncoder passwordEncoder;

  @Autowired
  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  public String encodePassword(String rawPassword) {
    return passwordEncoder.encode(rawPassword);
  }

  public boolean isMatchedPassword(String paramPassword, String originalPassword) {
    if (passwordEncoder.matches(paramPassword, originalPassword)) {
      return true;
    }
    return false;
  }

}
