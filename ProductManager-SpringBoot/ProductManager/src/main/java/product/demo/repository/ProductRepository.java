package product.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import product.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	 @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
	            + " OR p.description LIKE %?1%"
	            + " OR CONCAT(p.categoryid, '') LIKE %?1%")
	    public List<Product> search(String keyword);

}
