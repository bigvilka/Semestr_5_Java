package labsjavajs.lab4;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "USERs2")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "user_id")
		private Integer id;

		@Column(name = "password")
		@Length(min = 5, message = "*Your password must have at least 5 characters")
		@NotEmpty(message = "*Please provide your password")
		private String password;

		@Column(name = "pass")
		private String pass;

		@Column(name = "name")
		@NotEmpty(message = "*Please provide your name")
		private String name;

		@Column(name = "hash")
		private String hash;


		public String getPassword() {
				return password;
		}

		public String getHash() {
				return hash;
		}

		public void setPassword(String password) {
				this.password = password;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public void setHash(String hash) {
				this.hash = hash;
		}

		public String getPass() {
				return pass;
		}

		public void setPass(String pass) {
				this.pass = pass;
		}
}
