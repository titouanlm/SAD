package com.example.finalexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.finalexam.model.Product;
import com.example.finalexam.model.Quantity;
import com.example.finalexam.repository.ProductRepo;
import com.example.finalexam.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRep;
	
	@RequestMapping(path = "/productsList" , method=RequestMethod.GET)
	public ModelAndView listProducts(Model model) {
		
		ModelAndView mv = new ModelAndView("buyProducts.jsp");
		List<Product> products = productService.findAllProducts();
		mv.addObject("products" , products);
		model.addAttribute("quantity", new Quantity());
		return mv;
	}
	
	
	@RequestMapping(value = { "/buyProducts" }, method = RequestMethod.POST)
    public String addDonutRecipee(@ModelAttribute("quantity") Quantity quantity, @RequestParam(value = "id", defaultValue = "") int id) {
  
    	int q = Integer.valueOf(quantity.getQuantity());
    	
    	
    	Product p = productRep.findProductForWrite(id);
    	
    	if(q <= p.getStock()) {
    		p.setStock(p.getStock()-q);
    		productRep.save(p);
    	}
    	        // Redirect to Confirmation page.
        return "redirect:/productsList";
    }
}
