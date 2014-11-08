import com.thoughtworks.iamcoach.pos.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ItemService itemServiceImple = (ItemService) context.getBean("itemServiceImple");

        Scanner scanner = (Scanner) context.getBean("scanner");
        Cart cart = new Cart(scanner, itemServiceImple);

        CategoryService categoryServiceImple = (CategoryServiceImpl) context.getBean("categoryServiceImple");

        Printer printer = new Printer(cart, categoryServiceImple );
        printer.printAllInfo();
    }

}
