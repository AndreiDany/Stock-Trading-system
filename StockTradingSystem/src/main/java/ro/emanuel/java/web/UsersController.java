package ro.emanuel.java.web;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.java.dao.UsersDAO;
import ro.emanuel.java.pojo.User;

@Controller
public class UsersController {

	@RequestMapping(value = "prepareLogin.htm")
	public ModelAndView prepareLogin(Model model) throws SQLException {

		User user = new User();

		model.addAttribute("user", user);

		return new ModelAndView("LoginForm.jsp", "model", model);
	}

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public ModelAndView autentificare(@ModelAttribute("user") User user, Model model, BindingResult result)
			throws SQLException {

		if (UsersDAO.getByEmail(user.getEmail()) != null) {

			if (UsersDAO.getByEmail(user.getEmail()).getPassword().equals(user.getPassword())) {
				User.setCurrentUser(UsersDAO.getByEmail(user.getEmail()));
			} else {
				return prepareLogin(model);
			}

		} else {
			return prepareRegister(model);
		}

		return new ModelAndView("index.jsp");
	}

	@RequestMapping(value = "prepareRegister.htm")
	public ModelAndView prepareRegister(Model model) throws SQLException {

		User user = new User();

		model.addAttribute("user", user);

		return new ModelAndView("RegisterForm.jsp", "model", model);
	}

	@RequestMapping(value = "register.htm", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user, Model model, BindingResult result)
			throws SQLException {

		UsersDAO.create(user);

		return new ModelAndView("index.jsp");
	}
}
