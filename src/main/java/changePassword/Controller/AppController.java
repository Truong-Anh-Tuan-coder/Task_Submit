package changePassword.Controller;

import changePassword.DTO.RequestDTO.UserRequestDTO;
import changePassword.Service.UserService;
import changePassword.ultimate.PasswordChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}
