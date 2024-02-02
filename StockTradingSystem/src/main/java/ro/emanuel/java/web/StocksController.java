package ro.emanuel.java.web;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.java.dao.StockDAO;
import ro.emanuel.java.pojo.Stock;
import ro.emanuel.java.pojo.User;

//Facade - Acest controller ofera o interfata simpla pentru lucru cu stock-uri
@Controller
public class StocksController {

	@RequestMapping(value = "stocksList.htm", method = RequestMethod.GET)
	public ModelAndView stocksList() throws SQLException {

		ArrayList<Stock> stocks = StockDAO.getAll();

		ModelMap model = new ModelMap();
		model.put("stocks", stocks);

		return new ModelAndView("Stocks.jsp", "model", model);
	}

	@RequestMapping(value = "addToPortfolio.htm")
	public ModelAndView addToPortfolio(@RequestParam("id") String id, @RequestParam("quantity") String quantity, Model model)
			throws SQLException {

		if (User.getCurrentUser() != null) {
			AddToPortofolioTemplateMethod addToPortofolioMethods = new AddToPortofolioMethods();

			addToPortofolioMethods.addToPortfolio(id, quantity);
		}

		// Pentru a afisa lista de stock-uri curenta
		return new ModelAndView("redirect:/stocksList.htm");
	}

}
