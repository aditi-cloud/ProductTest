package com.itvedant.product.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.product.dao.AddProductDAO;
import com.itvedant.product.dao.UpdateproductDAO;
import com.itvedant.product.entity.product;
import com.itvedant.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public product createProduct(AddProductDAO addProductDAO) {
		product p = new product();
		
		p.setName(addProductDAO.getName());
		p.setPrice(addProductDAO.getPrice());
		p.setQuantity(addProductDAO.getQuantity());
		
		return productRepository.save(p);

		
	}
	
	public List<product> readAllProduct(){
		List<product> p=new ArrayList<product>();
		p =this.productRepository.findAll();
		return p;
		
}

	public product readProductByProduct(Integer id) {
		product p=new product();
		p=this.productRepository.findById(id).orElse(null);
		return p;
		
	}
	
	public product updateproduct(Integer id,UpdateproductDAO updateproductDAO) {
		
		product p=new product();
		
		p =this.readProductByProduct(id);
		
		if(updateproductDAO.getName()!=null) {
			p.setName(updateproductDAO.getName());
		}
		if(updateproductDAO.getPrice()!=null) {
			p.setPrice(updateproductDAO.getPrice());
		}
		if(updateproductDAO.getQuantity()!=null) {
			p.setQuantity(updateproductDAO.getQuantity());
		}
		this.productRepository.save(p);
		return p;
	}
	
	public String deleteProduct(Integer id) {
		product p=new product();
		p=this.readProductByProduct(id);
		this.productRepository.delete(p);
		return "Product Data deleted";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
