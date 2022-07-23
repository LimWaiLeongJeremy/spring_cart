package ssf.homework.shopping.cart.controllor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ssf.homework.shopping.cart.model.Cart;
import ssf.homework.shopping.cart.util.CartUtil;

@Controller
@RequestMapping (path = {"/", "/cart"})

public class CartControllor {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Cart.class);

    @Autowired
    CartUtil util;

    @GetMapping
    public String showCart(Model model) {
        logger.info("getget2");
        model.addAttribute("cart", new Cart());
        return "cart";
    }

    @PostMapping
    public String addToCart(@ModelAttribute Cart cart, Model model) {
        logger.info("PostMapping username: {}", cart.getUsername());
        logger.info("PostMapping item: {}", cart.getItem());
        logger.info("PostMapping price: {}", cart.getPrice());
        util.add(cart, model);
        return "cart";
    }
}
