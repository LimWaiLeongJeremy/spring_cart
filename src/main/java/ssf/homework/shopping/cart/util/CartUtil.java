package ssf.homework.shopping.cart.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import ssf.homework.shopping.cart.model.Cart;

@Component("cartUtil")
public class CartUtil {
    private static final Logger logger = LoggerFactory.getLogger(CartUtil.class);

    private String dir = "/Users/jeremy/Desktop/practice/ssf/homework/shopping.cart/user";


    public void add(Cart userCart, Model model){
        String dataFilename = (userCart.getUsername() + ".txt");
        File file = new File(dir + "/" + dataFilename);
        try{
            // the true in fileWriter is to put in append mode so it will continue writing lines instead of replace file.
            FileWriter fw = new FileWriter(file , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pr = new PrintWriter(bw);
            pr.append(userCart.getItem()+ " " + 
                        userCart.getQuantity() + 
                        userCart.getPrice() + "\n");
            pr.close();
          
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        model.addAttribute("cart", new Cart(userCart.getUsername(), userCart.getItem(), userCart.getPrice()));
    }

    public void getContactById(Model model, String username) {
        Cart cart = new Cart();
        try {
            String fileName = (username + ".txt");
            Path filePath = new File(dir + fileName).toPath();
            Charset charset = Charset.forName("UTF-8");
            List<String> stringList = Files.readAllLines(filePath, charset);
            // for (int i = 0; i < stringList.size(); i++){
            //     InputStream in = new InputStream(stringList) {
            //     }; 
            //     BufferedReader 
            //     String[] arr = stringList[0].split(" ");
            // }
            cart.setItem(stringList.get(0));
            cart.setPrice(Integer.parseInt(stringList.get(1)));
            cart.setQuantity(Integer.parseInt(stringList.get(1)));
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Contact info not found");
        }

        model.addAttribute("cartArray", cart);
    }
}
