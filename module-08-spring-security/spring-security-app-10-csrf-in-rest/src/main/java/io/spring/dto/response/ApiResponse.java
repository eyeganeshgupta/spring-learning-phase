package io.spring.dto.response;

import io.spring.dto.ContactDTO;

public class ApiResponse {

    private String message;
    private ContactDTO contact;

    public ApiResponse() {

    }

    public ApiResponse(String message, ContactDTO contact) {
        this.message = message;
        this.contact = contact;
    }

    public String getMessage() {
        return message;
    }

    public ContactDTO getContact() {
        return contact;
    }
}
