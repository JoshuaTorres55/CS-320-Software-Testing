/**
 * ContactService.java
 * 
 * Author: Joshua Torres
 * Date: July 19, 2025
 * 
 * In-memory management of Contact objects.
 * Supports adding, deleting, and updating per contactId.
 */
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact with ID " + id + " already exists.");
        }
        contacts.put(id, contact);
    }

    public void deleteContact(String id) {
        if (!contacts.containsKey(id)) {
            throw new IllegalArgumentException("No contact found with ID " + id + ".");
        }
        contacts.remove(id);
    }

    public void updateFirstName(String id, String firstName) {
        get(id).setFirstName(firstName);
    }

    public void updateLastName(String id, String lastName) {
        get(id).setLastName(lastName);
    }

    public void updatePhone(String id, String phone) {
        get(id).setPhone(phone);
    }

    public void updateAddress(String id, String address) {
        get(id).setAddress(address);
    }

    private Contact get(String id) {
        Contact c = contacts.get(id);
        if (c == null) {
            throw new IllegalArgumentException("No contact found with ID " + id + ".");
        }
        return c;
    }
}
