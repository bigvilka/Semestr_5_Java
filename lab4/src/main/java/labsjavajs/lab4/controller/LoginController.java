package labsjavajs.lab4.controller;

import javax.validation.Valid;

import com.google.common.hash.Hashing;
import labsjavajs.lab4.User;
import labsjavajs.lab4.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class LoginController<bindingResult> {

		@Autowired
		private UserService userService;

		@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
		public ModelAndView login(){
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("login");
				return modelAndView;
		}

		@RequestMapping(value={"/", "/login"}, method = RequestMethod.POST)
		public ModelAndView validation(@Valid String name, @Valid String password){
				ModelAndView modelAndView = new ModelAndView();
				User user = userService.findUserByName(name);
				if (user == null){
						modelAndView.setViewName("login");
				}
				else {
						if (!user.getPass().equals(password)){
								modelAndView.setViewName("login");
						}
						else {
								modelAndView = new ModelAndView("redirect:/list");
						}
				}
				return modelAndView;
		}


		@RequestMapping(value="/signup", method = RequestMethod.GET)
		public ModelAndView registration(){
				ModelAndView modelAndView = new ModelAndView();
				User user = new User();
				modelAndView.addObject("user", user);
				modelAndView.setViewName("signup");
				return modelAndView;
		}

		@RequestMapping(value = "/signup", method = RequestMethod.POST)
		public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
				ModelAndView modelAndView = new ModelAndView();
				User userExists = userService.findUserByName(user.getName());
				if (userExists != null) {
						bindingResult
										.rejectValue("name", "error.user",
														"There is already a user registered with the name provided");
				}
				if (bindingResult.hasErrors()) {
						modelAndView.setViewName("signup");
				} else {
						long curTime = System.currentTimeMillis();
						String pass = user.getPass();
						String hash = Hashing.sha256().hashString(pass + Long.toString(curTime), StandardCharsets.UTF_8).toString();
						user.setHash(hash);
						userService.saveUser(user);
						modelAndView.addObject("successMessage", "User has been registered successfully");
						modelAndView.addObject("user", new User());
						modelAndView.setViewName("signup");

				}
				return modelAndView;
		}

		@RequestMapping(value="/list", method = RequestMethod.GET)
		public ModelAndView home(){
				ModelAndView modelAndView = new ModelAndView();
				List<User> users = userService.findAll();
				String allusers = "";
				int i = 1;
				for (User u: users){
						allusers =  allusers + i + ") " + u.getName() + " (" + u.getHash() + ")" + "</br>";
						i++;
				}
				modelAndView.addObject("listofusers", "List of all registered users </br> " + allusers);
				modelAndView.addObject("adminMessage","Content Available Only for authorized users </br>");
				modelAndView.setViewName("list");
				return modelAndView;
		}



}