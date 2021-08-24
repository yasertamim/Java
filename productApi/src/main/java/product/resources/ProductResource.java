package product.resources;


import product.models.Country;
import product.models.Product;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("product")
public class ProductResource {


    @POST
    @Path("/new")
    @Consumes("application/json")
    @Produces("application/json")
    public Product addProduct(final Product product) {
        Product newProduct = product;
        newProduct.setProductId("newaId");
        return newProduct;
    }

    @GET
    @Path("/all")
    @Consumes("application/json")
    @Produces("application/json")
    public List<Product>  getAllProducts(@QueryParam("country") Country countryFilter) {
        Product prod1 = new Product("hh66","bread",50, Country.Germany);
        Product prod2 = new Product("ht86","apple",30, Country.Spain);

        List<Product> lista = new ArrayList<>();
        lista.add(prod1);
        lista.add(prod2);

        if (countryFilter != null) {
            List<Product> filteredList = lista.stream()
                    .filter(prod -> {
                        return prod.getCountry().equals(countryFilter);
                    }).collect(Collectors.toList());
            return filteredList;
        }
        return lista;

    }

    @GET
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Product getProduct(@PathParam("id") String productId) {
        Product prod1 = new Product("hh66","bread",50, Country.Germany);
        Product prod2 = new Product("ht86","apple",30, Country.Spain);

        List<Product> lista = new ArrayList<>();
        lista.add(prod1);
        lista.add(prod2);

        try {
            if (productId != null) {
                Optional<Product> filteredProduct = lista.stream()
                        .filter(prod -> {
                            return prod.getProductId().equals(productId);
                        }).findFirst();
                return filteredProduct.orElseThrow(() -> new NotFoundException("Product with id= " + productId + " not present"));
            }
            throw new NotFoundException("Product with is null");
        } catch (NotFoundException e) {
            throw new NotFoundException("Product with id= " + productId + " not found", e);
        }
    }

}
