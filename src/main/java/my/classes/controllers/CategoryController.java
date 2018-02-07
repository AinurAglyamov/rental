package my.classes.controllers;

import my.classes.model.Category;
import my.classes.model.Product;
import my.classes.service.CategoryService;
import my.classes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String categoryProducts(@PathVariable("id") int id, Model model){

        Category category = categoryService.findById(id);
        List<Product> products = category.getProducts();
        /*for(Product product : products){
            System.out.println(product);
        }*/

        model.addAttribute("products",products);
        model.addAttribute("categoryName", category.getCategoryName());
        return "categoryProducts";
    }
}
