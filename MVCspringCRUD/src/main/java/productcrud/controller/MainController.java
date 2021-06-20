package productcrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrud.dao.ProductDao;
import productcrud.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model model) {
		// this step comes after data appears in console and here we get the
		// product and then add in model to show in index page, also used
		// expression lang in index page
		List<Product> products = productDao.getProducts();
		model.addAttribute("products", products);

		return "index";
	}

	@RequestMapping("/addform")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Prod");
		return "add_form";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handlePro(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");

		return redirectView;

	}

	// delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteHandler(@PathVariable("productId") int productId, HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");

		return redirectView;

	}

	// update handler now
	@RequestMapping("/update/{productId}")
	public String updateHandler(@PathVariable("productId") int pid, Model model) {
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "updateform";
	}

	// handle add product form
	/*
	 * @RequestMapping(value="/handle-product", method= RequestMethod.POST) public
	 * RedirectView handleProd(@ModelAttribute Product product, HttpServletRequest
	 * request) { System.out.println(product); RedirectView redirectView = new
	 * RedirectView(); redirectView.setUrl(request.getContextPath() +"/"); return
	 * redirectView; }
	 */

	/*
	 * @RequestMapping(value="/handle-product", method=RequestMethod.POST) public
	 * String showProduct(@ModelAttribute Product product, Model model) {
	 * System.out.println("this is handle page");
	 * model.getAttribute(product.getName());
	 * model.getAttribute(product.getPrice()); return "handle-product";
	 * 
	 * }
	 */

}
