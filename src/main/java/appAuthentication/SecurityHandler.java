package appAuthentication;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SecurityHandler implements AuthenticationSuccessHandler{

	private String role_admin = "ROLE_ADMIN";
	private String role_user = "ROLE_USER";
	
	private String admin_redirect = "admin";
	private String user_redirect = "user";
	
	public void onAuthenticationSuccess (HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
		
		 Collection<? extends GrantedAuthority> auths = authResult.getAuthorities();
		 
		 for(GrantedAuthority authority: auths) {
			 if(authority.getAuthority().equals(role_admin)) {
				 response.sendRedirect(admin_redirect);
			 }
			 else if(authority.getAuthority().equals(role_user)){
				 response.sendRedirect(user_redirect);
			 }
			 else {
				 System.out.println("there is no such role");
			 }
		 }
	}
}
