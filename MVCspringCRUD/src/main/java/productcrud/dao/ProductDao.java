package productcrud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrud.model.Product;

/*1st thing we need is springMVC create obj of this class on its own, so -> @Component*/
@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// create product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);

	}

	// get all product
	public List<Product> getProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	//get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
	
	//delete all
	@Transactional
	public List<Product> dltProduct(){
		List<Product> dp = this.hibernateTemplate.loadAll(Product.class);
		return dp;
		
	}
		
	
	
	
	

}
