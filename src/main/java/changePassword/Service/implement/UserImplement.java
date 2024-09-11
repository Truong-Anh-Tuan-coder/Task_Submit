package changePassword.Service.implement;

import changePassword.Repository.UserRepository;
import changePassword.Service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImplement implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Override
	public void Save(String password) {
		int id = 1;
		userRepo.updatePassword(password, id);
	}
}
