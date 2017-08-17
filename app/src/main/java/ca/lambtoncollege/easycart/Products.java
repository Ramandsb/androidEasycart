package ca.lambtoncollege.easycart;

/**
 * Created by ramandeepsingh on 2017-08-09.
 */

public class Products {

    int product_id = 0;
    String product_name = "", product_description ="", product_image ="";


    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

}