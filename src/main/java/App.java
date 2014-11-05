import com.thoughtworks.iamcoach.pos.dao.CategoryDao;
import com.thoughtworks.iamcoach.pos.dao.CategoryDaoImple;
import com.thoughtworks.iamcoach.pos.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


public class App {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        ItemService itemServiceImple = new ItemServiceImple();
        Scanner scanner = new Scanner();
        Cart cart = new Cart(scanner, itemServiceImple);

        SimpleJdbcTemplate simpleJdbcTemplate = (SimpleJdbcTemplate)context.getBean("simpleJdbcTemplate");
        CategoryDao categoryDaoImple = new CategoryDaoImple(simpleJdbcTemplate);
        CategoryService categoryServiceImple = new CategoryServiceImpl(categoryDaoImple);
        Printer printer = new Printer(cart, categoryServiceImple );
        printer.printAllInfo();
    }

}
