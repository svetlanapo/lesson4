package ru.spo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.spo.domain.Product;
import ru.spo.repository.ProductRepository;
import ru.spo.service.ProductServise;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

   private ProductServise productServise;

    public ProductController(){}

    public ProductController(ProductServise productServise) {
        this.productServise = productServise;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        List<Product> productList = productServise.getAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @RequestMapping("/new")
    public String newCustomerForm(Map<String, Object> model) {
        Product product = new Product();
        model.put("product", product);
        return "new_product";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Product product) {
        productServise.save(product);
        return "redirect:/";
    }

}
