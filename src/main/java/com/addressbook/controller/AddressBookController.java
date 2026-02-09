package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // Get all addresses
    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllAddresses() {
        List<AddressBookDTO> addresses = addressBookService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    // Get address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressById(@PathVariable Long id) {
        return addressBookService.getAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new address
    @PostMapping
    public ResponseEntity<AddressBookDTO> createAddress(@RequestBody AddressBookDTO addressDTO) {
        AddressBookDTO createdAddress = addressBookService.createAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    // Update existing address
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateAddress(
            @PathVariable Long id,
            @RequestBody AddressBookDTO addressDTO) {
        return addressBookService.updateAddress(id, addressDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (addressBookService.deleteAddress(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search addresses by name
    @GetMapping("/search")
    public ResponseEntity<List<AddressBookDTO>> searchByName(@RequestParam String name) {
        List<AddressBookDTO> addresses = addressBookService.searchByName(name);
        return ResponseEntity.ok(addresses);
    }

    // Get addresses by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<AddressBookDTO>> getAddressesByCity(@PathVariable String city) {
        List<AddressBookDTO> addresses = addressBookService.getAddressesByCity(city);
        return ResponseEntity.ok(addresses);
    }
}

