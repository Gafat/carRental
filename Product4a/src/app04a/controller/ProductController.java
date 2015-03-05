package app04a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app04a.domain.Product;
import app04a.service.ProductService;

@Controller
public class ProductController {
 
	@Autowired
	ProductService productService;
 	
    @RequestMapping(value={"/","/product"}, method = RequestMethod.GET)
    public String inputProduct(Product product) {
         return "ProductForm";
    }

    @RequestMapping(value="/product", method = RequestMethod.POST)
    public String saveProduct(Product product ) {
    	
    	productService.save(product);
    	
        return "ProductDetails";
    }
    
    
    @RequestMapping(value="/listproducts", method = RequestMethod.GET)
    public String listProducts(Product product, Model model ) {
    	
    	
		List<Product> list = productService.getAll();
		model.addAttribute("products",  list);
    	
        return "ListProducts";
    }
    
    
    
}
