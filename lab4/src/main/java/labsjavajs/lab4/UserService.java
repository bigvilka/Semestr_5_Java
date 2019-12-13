package labsjavajs.lab4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("userService")
public class UserService {

		private UserRep userRep;
		private BCryptPasswordEncoder bCryptPasswordEncoder;

		@Autowired
		public UserService(UserRep userRep,
											 BCryptPasswordEncoder bCryptPasswordEncoder) {
				this.userRep = userRep;
				this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		}

		public List<User> findAll(){
				return userRep.findAll();
		}
		public User findUserByName(String name) {
				return userRep.findByName(name);
		}

		public User findUserByHash(String hash){
				return userRep.findByHash(hash);
		}

		public void saveUser(User user) {
				user.setPass(user.getPassword());
				user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
				userRep.save(user);
		}

}