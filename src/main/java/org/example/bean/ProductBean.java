package org.example.bean;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Component
@Scope("session")
public class ProductBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductService productService;

    private List<Product> products;
    private Product product;


    public void onlLoad() {
        products = productService.getAllProducts();
    }

    public String saveProduct() {
        String navigationResult = "";
        Product resulProduct= productService.saveProduct(product);
        if(resulProduct !=null) {
            navigationResult = "productList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "createProduct.xhtml?faces-redirect=true";
        }
        return navigationResult;
    }

    public String editProduct(Long productId) {
        System.out.println("editProduct() : Product Id: " + productId);
        /* Setting The Particular Student Details In Session */
        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Product resulProduct= productService.getProductById(productId);
        if(resulProduct != null) {
            sessionMapObj.put("editRecordObj", resulProduct);
        }
        return "/editProduct.xhtml?faces-redirect=true";
    }

    public String updateProduct(Product product) {
        Product resulProduct= productService.updateProduct(product);
        return "/productList.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Long productId) {
        System.out.println("deleteProduct() : Product Id: " + productId);
        productService.deleteProduct(productId);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        if (product == null) {
            product = new Product();
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}