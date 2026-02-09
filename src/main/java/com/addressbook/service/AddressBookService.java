package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.Address;
import com.addressbook.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressBookService {

    @Autowired
    private AddressRepository addressRepository;

    // Convert Entity to DTO
    private AddressBookDTO convertToDTO(Address address) {
        return new AddressBookDTO(
                address.getId(),
                address.getName(),
                address.getPhone(),
                address.getEmail(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getCountry()
        );
    }

    // Convert DTO to Entity
    private Address convertToEntity(AddressBookDTO dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setName(dto.getName());
        address.setPhone(dto.getPhone());
        address.setEmail(dto.getEmail());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        address.setCountry(dto.getCountry());
        return address;
    }

    // Get all addresses
    public List<AddressBookDTO> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get address by ID
    public Optional<AddressBookDTO> getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Create new address
    public AddressBookDTO createAddress(AddressBookDTO addressDTO) {
        Address address = convertToEntity(addressDTO);
        Address savedAddress = addressRepository.save(address);
        return convertToDTO(savedAddress);
    }

    // Update existing address
    public Optional<AddressBookDTO> updateAddress(Long id, AddressBookDTO addressDTO) {
        return addressRepository.findById(id)
                .map(existingAddress -> {
                    existingAddress.setName(addressDTO.getName());
                    existingAddress.setPhone(addressDTO.getPhone());
                    existingAddress.setEmail(addressDTO.getEmail());
                    existingAddress.setStreet(addressDTO.getStreet());
                    existingAddress.setCity(addressDTO.getCity());
                    existingAddress.setState(addressDTO.getState());
                    existingAddress.setZipCode(addressDTO.getZipCode());
                    existingAddress.setCountry(addressDTO.getCountry());
                    Address updatedAddress = addressRepository.save(existingAddress);
                    return convertToDTO(updatedAddress);
                });
    }

    // Delete address
    public boolean deleteAddress(Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Search addresses by name
    public List<AddressBookDTO> searchByName(String name) {
        return addressRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get addresses by city
    public List<AddressBookDTO> getAddressesByCity(String city) {
        return addressRepository.findByCity(city)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}

