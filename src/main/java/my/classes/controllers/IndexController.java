package my.classes.controllers;

import my.classes.model.Product;
import my.classes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        List<Product> products = productService.productsList();
        /*for(Product product : products){
            System.out.println(product);
        }*/
        model.addAttribute("products",products);
        return "products";
    }
}
