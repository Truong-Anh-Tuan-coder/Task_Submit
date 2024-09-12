package changePassword.Controller;

import changePassword.DTO.RequestDTO.UserRequestDTO;
import changePassword.Service.UserService;
import changePassword.ultimate.EmailUtil;
import changePassword.ultimate.PasswordChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
	@Autowired
	private UserService userService;
	@PostMapping("/user/password")
	public ResponseEntity changePassword(@RequestParam String password){
		if(PasswordChecker.Check(password)){
			userService.Save(password);
			return ResponseEntity.ok("passed");
		} else
			return ResponseEntity.ok("failed");
	}
	@GetMapping("/user/password")
	public ResponseEntity randomPassword(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encoded  = passwordEncoder.encode("Hello World");
		userService.Save(encoded);
		EmailUtil.sendEmail(encoded);
		return ResponseEntity.ok("check email");
	}
}
