package pl.coderslab.controller.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CartController {

    private final static Logger logger = LoggerFactory.getLogger(CartController.class);

    private Cart cart;
    private ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

/*    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }*/

    @GetMapping("/addtocart")
    @ResponseBody
    public String addToCart(@RequestParam("id") long id, @RequestParam("quantity") int quantity) {
        logger.debug("running add to cart with given params, id: {}, quantity: {}", id, quantity);
        if(cart.hasProductWithId(id)) {
            logger.debug("there is already product with given id, updating");
            cart.updateQuantity(id, quantity);
            return "quantityUpdated";
        }
        Product product = productDao.getProductById(id);
        CartItem cartItem = new CartItem(quantity, product);
        logger.debug("This is new product in cart, adding new cart item: {}", cartItem);
        cart.addToCart(cartItem);
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String showCart() {
        StringBuilder sb = new StringBuilder();
        sb.append("W koszyku jest: ")
                .append(cart.getCartItems().size())
                .append(" pozycji. \n");
        sb.append("W koszyku jest: ")
                .append(cart.totalQuantity())
                .append(" produktów. \n");
        sb.append("Wartosc koszyka to: ")
                .append(cart.totalAmount())
                .append(" .\n");

        return sb.toString();
    }

}
