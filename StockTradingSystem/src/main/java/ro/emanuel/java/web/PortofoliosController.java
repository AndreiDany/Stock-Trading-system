package ro.emanuel.java.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.java.dao.PortofoliosDAO;
import ro.emanuel.java.pojo.Portofolio;
import ro.emanuel.java.pojo.User;

@Controller
public class PortofoliosController {

	@RequestMapping(value = "portofolio.htm", method = RequestMethod.GET)
	public ModelAndView stocksList() throws SQLException {

		if (User.getCurrentUser() == null) {
			new ModelAndView("redirect:/index.jsp");
		}
		ArrayList<Portofolio> portofolios = PortofoliosDAO.getAll();

		ArrayList<PortofolioWithStockDecorator> myPortofolios = new ArrayList<PortofolioWithStockDecorator>();

		// Iterator pattern - traverseaza colectia fara a-i expune reprezentarea
		Iterator<Portofolio> it = portofolios.iterator();

		while (it.hasNext()) {

			Portofolio portofolio = it.next();

			if (portofolio.getUserId() == User.getCurrentUser().getId()) {

				PortofolioWithStockDecorator portofolioWithStock = new PortofolioWithStockDecorator(portofolio);

				myPortofolios.add(portofolioWithStock);
			}
		}

		ModelMap model = new ModelMap();
		model.put("myPortofolios", myPortofolios);

		return new ModelAndView("Portofolio.jsp", "model", model);
	}

	@RequestMapping(value = "sellFromPortfolio.htm")
	public ModelAndView sellFromPortfolio(@RequestParam("id") String id, Model model) throws SQLException {

		PortofoliosDAO.delete(Integer.parseInt(id));
		
		return new ModelAndView("redirect:/portofolio.htm");
	}

}
