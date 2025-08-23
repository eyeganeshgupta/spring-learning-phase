package io.spring.controller;

import io.spring.dto.ContactDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final Map<Long, ContactDTO> contactStore = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping("/submit")
    public ResponseEntity<?> submitForm(@Valid @RequestBody ContactDTO contact) {
        long id = idGenerator.getAndIncrement();
        contactStore.put(id, contact);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Contact message received",
                "id", id,
                "contact", contact
        ));
    }

    @PostMapping("/bulk-submit")
    public ResponseEntity<?> bulkSubmit(@Valid @RequestBody List<ContactDTO> contacts) {

        if (contacts == null || contacts.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "Contact list cannot be empty"
            ));
        }

        if (contacts.size() > 5) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                    "error", "You can submit a maximum of 5 contacts at a time",
                    "submittedCount", contacts.size()
            ));
        }

        List<Map<String, Object>> savedContacts = new ArrayList<>();

        for (ContactDTO contact : contacts) {
            long id = idGenerator.getAndIncrement();
            contactStore.put(id, contact);

            savedContacts.add(Map.of(
                    "id", id,
                    "contact", contact
            ));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "Bulk contact submission successful",
                "count", savedContacts.size(),
                "contacts", savedContacts
        ));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllContacts() {
        List<Map<String, Object>> contacts = new ArrayList<>();
        contactStore.forEach((id, contact) -> {
            Map<String, Object> entry = new LinkedHashMap<>();
            entry.put("id", id);
            entry.put("contact", contact);
            contacts.add(entry);
        });
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id) {
        ContactDTO contact = contactStore.get(id);
        if (contact == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Contact not found"));
        }
        return ResponseEntity.ok(Map.of("id", id, "contact", contact));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchByName(@RequestParam String name) {
        List<Map<String, Object>> matches = new ArrayList<>();

        contactStore.forEach((id, contact) -> {
            if (contact.getName() != null && contact.getName().toLowerCase().contains(name.toLowerCase())) {
                matches.add(Map.of("id", id, "contact", contact));
            }
        });

        return ResponseEntity.ok(matches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContact(@PathVariable Long id, @Valid @RequestBody ContactDTO updatedContact) {
        if (!contactStore.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Contact not found"));
        }
        contactStore.put(id, updatedContact);
        return ResponseEntity.ok(Map.of("message", "Contact updated", "id", id, "contact", updatedContact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        ContactDTO removed = contactStore.remove(id);
        if (removed == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Contact not found"));
        }
        return ResponseEntity.ok(Map.of("message", "Contact deleted", "id", id));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllContacts() {
        int count = contactStore.size();
        contactStore.clear();
        return ResponseEntity.ok(Map.of("message", "All contacts deleted", "deletedCount", count));
    }

}
