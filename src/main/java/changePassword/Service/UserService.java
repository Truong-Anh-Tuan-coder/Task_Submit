package changePassword.Service;

import org.springframework.data.jpa.repository.Query;

public interface UserService {
	void Save(String password);
}
