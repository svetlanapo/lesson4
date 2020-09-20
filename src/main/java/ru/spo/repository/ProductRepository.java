package ru.spo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spo.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

}
