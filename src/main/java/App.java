import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImple;
import com.thoughtworks.iamcoach.pos.dao.ItemDao;
import com.thoughtworks.iamcoach.pos.dao.ItemDaoImple;
import com.thoughtworks.iamcoach.pos.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


public class App {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ItemService itemServiceImple = (ItemService) context.getBean("itemServiceImple");

        Scanner scanner = (Scanner) context.getBean("scanner");
//        Scanner scanner = new Scanner();
        Cart cart = new Cart(scanner, itemServiceImple);

        CategoryService categoryServiceImple = (CategoryServiceImpl) context.getBean("categoryServiceImple");

        Printer printer = new Printer(cart, categoryServiceImple );
        printer.printAllInfo();
    }

}
