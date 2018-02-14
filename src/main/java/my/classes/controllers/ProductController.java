package my.classes.controllers;

import my.classes.model.Category;
import my.classes.model.Product;
import my.classes.service.CategoryService;
import my.classes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    ProductService productService;
    CategoryService categoryService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productData(@PathVariable("id") int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "infoProducts";
    }

    @RequestMapping(value = "/addproduct/", method = RequestMethod.GET)
    public String addProductForm(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", getCategories());
        return "createProduct";
    }

    @RequestMapping(value = "/addproduct/", method = RequestMethod.POST)
    public String addProductSubmit(@ModelAttribute("product") Product product, Model model){
        if(product.getId() == 0){
            productService.addProduct(product);
        } else {
            productService.updateProduct(product);
        }
        return "redirect:/addproduct/";
    }

    @RequestMapping(value = "/updateproduct/{id}", method = RequestMethod.GET)
    public String updateProduct(@PathVariable("id") int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", getCategories());
        return "createProduct";
    }

    @RequestMapping(value = "/deleteproduct/", method = RequestMethod.POST)
    public @ResponseBody void deleteProduct(@RequestParam(value = "id", required = true) int id){
        productService.removeProduct(id);
    }

    private Map<Integer, String> getCategories(){

        Map<Integer, String> categories = new HashMap<>();
        List<Category> categoryList = categoryService.findAll();
        for(Category category : categoryList){
            categories.put(category.getId(), category.getCategoryName());
        }
        return categories;
    }
}
