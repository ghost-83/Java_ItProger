import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    @DisplayName("Проверка создания обьекта с двумя параметрами.")
    public void testUser(){

        User user = new User("javaUser", "user@java.com");
        assertEquals("javaUser", user.getLogin());
        assertEquals("user@java.com", user.getEmail());
    }

    @Nested
    @DisplayName("Проверка установки занчений.")
    class Form{

        @Test
        @DisplayName("Установка email.")
        public void testSetEmail(){
            User user = new User();
            assertThrows(Error.class, () -> user.setEmail("java.java.com"));
        }

        @Test
        @DisplayName("Установка логина.")
        public void testSetLogin(){
            User user = new User();
            assertThrows(Error.class, () -> user.setLogin("java"));
        }

    }
}
