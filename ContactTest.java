/**
 * ContactTest.java
 * 
 * Author: Joshua Torres
 * Date: July 19, 2025
 * 
 * JUnit 5 tests for Contact class, covering all field requirements.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void createValidContact() {
        Contact c = new Contact("ID123", "Alice", "Brown", "0123456789", "123 Main St");
        assertEquals("ID123", c.getContactId());
        assertEquals("Alice", c.getFirstName());
        assertEquals("Brown", c.getLastName());
        assertEquals("0123456789", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void contactIdNullOrTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "A", "B", "0123456789", "Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ABCDEFGHIJK", "A", "B", "0123456789", "Addr"));
    }

    @Test
    void firstNameNullOrTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", null, "B", "0123456789", "Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "LongFirstName", "B", "0123456789", "Addr"));
    }

    @Test
    void lastNameNullOrTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", null, "0123456789", "Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", "LongLastName", "0123456789", "Addr"));
    }

    @Test
    void phoneNullOrInvalidThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", "B", null, "Addr"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", "B", "12345", "Addr"));
    }

    @Test
    void addressNullOrTooLongThrows() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", "B", "0123456789", null));
        String longAddr = "1234567890 1234567890 1234567890 X";
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "A", "B", "0123456789", longAddr));
    }

    @Test
    void settersEnforceConstraints() {
        Contact c = new Contact("ID1", "A", "B", "0000000000", "Addr");
        // valid updates
        c.setFirstName("Jane");
        c.setLastName("Doe");
        c.setPhone("1234567890");
        c.setAddress("200 Elm Street");
        // invalid updates
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("TooLongFirstName"));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("TooLongLastName"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("bad"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890 1234567890 1234567890 XYZ"));
    }
}
