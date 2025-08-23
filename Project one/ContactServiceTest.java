/**
 * ContactServiceTest.java
 * 
 * Author: Joshua Torres
 * Date: July 19, 2025
 * 
 * JUnit 5 tests for ContactService: add, delete, update.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("C1", "John", "Doe", "1112223333", "42 Galaxy Way");
        service.addContact(contact);
    }

    @Test
    void addUniqueContactSucceeds() {
        service.addContact(new Contact("C2", "Jane", "Roe", "9998887777", "100 Star Rd"));
    }

    @Test
    void addDuplicateIdThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(new Contact("C1", "Jake", "Smith", "0001112222", "500 Moon Blvd")));
    }

    @Test
    void deleteExistingContactSucceeds() {
        service.deleteContact("C1");
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteContact("C1"));
    }

    @Test
    void deleteNonexistentThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteContact("UNKNOWN"));
    }

    @Test
    void updateFirstNameSucceeds() {
        service.updateFirstName("C1", "Alice");
        assertEquals("Alice", contact.getFirstName());
    }

    @Test
    void updateLastNameSucceeds() {
        service.updateLastName("C1", "Wonder");
        assertEquals("Wonder", contact.getLastName());
    }

    @Test
    void updatePhoneSucceeds() {
        service.updatePhone("C1", "2223334444");
        assertEquals("2223334444", contact.getPhone());
    }

    @Test
    void updateAddressSucceeds() {
        service.updateAddress("C1", "123 Space Lane");
        assertEquals("123 Space Lane", contact.getAddress());
    }

    @Test
    void updateInvalidPhoneThrows() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("C1", "short"));
    }

    @Test
    void updateNonexistentContactThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("X","Name"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName ("X","Name"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone    ("X","1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress  ("X","Addr"));
    }
}
