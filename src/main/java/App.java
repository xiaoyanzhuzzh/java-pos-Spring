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
        SimpleJdbcTemplate simpleJdbcTemplate = (SimpleJdbcTemplate)context.getBean("simpleJdbcTemplate");

        ItemDao itemDaoImple = new ItemDaoImple(simpleJdbcTemplate);
        ItemService itemServiceImple = new ItemServiceImple(itemDaoImple);
        Scanner scanner = new Scanner();
        Cart cart = new Cart(scanner, itemServiceImple);

        CategoryDao categoryDaoImple = new CategoryDaoImple(simpleJdbcTemplate);
        CategoryService categoryServiceImple = new CategoryServiceImpl(categoryDaoImple);
        Printer printer = new Printer(cart, categoryServiceImple );
        printer.printAllInfo();
    }

}
