package com.tacademy.ecommerce.common;

import javax.servlet.ServletContext;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.ServletContextAware;

import com.tacademy.ecommerce.domain.User;

public class BaseController implements ServletContextAware {

  @Getter
  @Setter
  private ServletContext servletContext;

  public User getCurrentUser() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    if (ctx.getAuthentication() == null)
      throw new AccessDeniedException("User not found in security session.");
    Authentication auth = ctx.getAuthentication();
    AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
    User currentUser = null;
    boolean signupUser = resolver.isAnonymous(auth);
    if (auth != null && !signupUser) {
      currentUser = getCurrentUser(auth);
    }
    return currentUser;
  }

  private static User getCurrentUser(Authentication auth) {
    User currentUser = null;
    if (auth.getPrincipal() instanceof User) {
      currentUser = (User) auth.getPrincipal();
    } else if (auth.getDetails() instanceof UserDetails) {
      currentUser = (User) auth.getDetails();
    } else {
      throw new AccessDeniedException("User not properly authenticated.");
    }
    return currentUser;
  }

}
