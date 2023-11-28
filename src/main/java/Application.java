import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.adapters.persistence.repository.imp.BookRepositoryImpl;
import org.chitalkin.ru.adapters.persistence.storage.BookStorage;
import org.chitalkin.ru.adapters.persistence.storage.impl.BookStorageImpl;
import org.chitalkin.ru.adapters.ui.management.UIShopManagement;
import org.chitalkin.ru.adapters.ui.management.impl.UIShopManagementImpl;
import org.chitalkin.ru.adapters.ui.mapper.OutputBookDtoMapper;
import org.chitalkin.ru.adapters.ui.menu.UIShopMenu;
import org.chitalkin.ru.adapters.ui.menu.impl.UIShopMenuImpl;
import org.chitalkin.ru.adapters.ui.input.UIShopMenuInput;
import org.chitalkin.ru.adapters.ui.input.impl.UIShopMenuInputImpl;
import org.chitalkin.ru.adapters.ui.validator.UIShopMenuInputValidator;
import org.chitalkin.ru.adapters.ui.validator.impl.UIShopMenuInputValidatorImpl;
import org.chitalkin.ru.core.mapper.BookDtoMapper;
import org.chitalkin.ru.core.service.BookService;
import org.chitalkin.ru.core.service.impl.BookServiceImpl;

public class Application {

    public static void main(String[] args) {
        BookStorage storage = new BookStorageImpl();
        BookRepository bookRepository = new BookRepositoryImpl(storage);
        BookDtoMapper bookDtoMapper = new BookDtoMapper();
        BookService bookService = new BookServiceImpl(bookRepository, bookDtoMapper);
        OutputBookDtoMapper outputBookDtoMapper = new OutputBookDtoMapper();
        UIShopManagement management = new UIShopManagementImpl(bookService, outputBookDtoMapper);
        UIShopMenuInput uiShopMenuInput = new UIShopMenuInputImpl();
        UIShopMenuInputValidator validator = new UIShopMenuInputValidatorImpl(uiShopMenuInput);
        UIShopMenu menu = new UIShopMenuImpl(management, validator);
        menu.show();
    }
}
