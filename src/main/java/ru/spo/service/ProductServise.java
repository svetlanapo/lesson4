package ru.spo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spo.domain.Product;
import ru.spo.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductServise {

    ProductRepository productRepo;

    public ProductServise(){}

    public ProductServise(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }


    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public void save(Product product){
        productRepo.save(product);
    }

    public void delete(Product product){
        productRepo.delete(product);
    }

}
