import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardSpaceTest extends Main {

    @Test
    public void testEmptyConstructor() {
        main.java.BoardSpace space = new main.java.BoardSpace();
        assertNotNull(space);
    }
}