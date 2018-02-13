package my.classes.controllers;

import my.classes.model.Category;
import my.classes.model.Product;
import my.classes.service.CategoryService;
import my.classes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("category",category);
        model.addAttribute("categoryName", category.getCategoryName());
        return "categoryProducts";
    }

    /*@RequestMapping(value = "/category", method = RequestMethod.GET)
    public String categoriesList(){
        List<Category> categories = categoryService.findAll();
    }*/
    @ModelAttribute("categories")
    public Map<Integer, String> getCategories(){
        Map<Integer, String> categories = new HashMap<>();
        List<Category> categoryList = categoryService.findAll();
        for(Category category : categoryList){
            categories.put(category.getId(), category.getCategoryName());
        }
        return categories;
    }

}
