import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.adapters.persistence.repository.imp.BookRepositoryImpl;
import org.chitalkin.ru.adapters.persistence.storage.BookDao;
import org.chitalkin.ru.adapters.persistence.storage.impl.BookDaoImpl;
import org.chitalkin.ru.adapters.ui.management.UIShopConsoleManagement;
import org.chitalkin.ru.adapters.ui.management.impl.UIShopConsoleManagementImpl;
import org.chitalkin.ru.adapters.ui.mapper.OutputBookDtoMapper;
import org.chitalkin.ru.adapters.ui.menu.UIShopConsoleMenu;
import org.chitalkin.ru.adapters.ui.menu.impl.UIShopConsoleMenuImpl;
import org.chitalkin.ru.adapters.ui.input.UIShopConsoleMenuInput;
import org.chitalkin.ru.adapters.ui.input.impl.UIShopConsoleMenuInputImpl;
import org.chitalkin.ru.adapters.ui.validator.UIShopConsoleMenuInputValidator;
import org.chitalkin.ru.adapters.ui.validator.impl.UIShopConsoleMenuInputValidatorImpl;
import org.chitalkin.ru.core.mapper.BookMapper;
import org.chitalkin.ru.core.service.BookService;
import org.chitalkin.ru.core.service.impl.BookServiceImpl;

public class Application {

    public static void main(String[] args) {
        BookDao storage = new BookDaoImpl();
        BookRepository bookRepository = new BookRepositoryImpl(storage);
        BookMapper bookMapper = new BookMapper();
        BookService bookService = new BookServiceImpl(bookRepository, bookMapper);
        OutputBookDtoMapper outputBookDtoMapper = new OutputBookDtoMapper();
        UIShopConsoleManagement management = new UIShopConsoleManagementImpl(bookService, outputBookDtoMapper);
        UIShopConsoleMenuInput uiShopConsoleMenuInput = new UIShopConsoleMenuInputImpl();
        UIShopConsoleMenuInputValidator validator = new UIShopConsoleMenuInputValidatorImpl(uiShopConsoleMenuInput);
        UIShopConsoleMenu menu = new UIShopConsoleMenuImpl(management, validator);
        menu.show();
    }
}
