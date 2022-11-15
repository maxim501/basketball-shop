package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.ClientDto;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.security.Client;
import com.am.basketballshop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientDto createClient(ClientDto clientDto) {
        Client client = new Client();
        setClient(client, clientDto);

        Client saveClient = clientRepository.save(client);
        return convertClientToResponse(saveClient);
    }

    public ClientDto getClient(String clientId) {
        Optional<Client> clientById = clientRepository.findById(clientId);
        Client client = clientById.orElseThrow(() -> {
            throw new NotFoundException("Not found client by id = " + clientId);
        });

        return convertClientToResponse(client);
    }

    public ClientDto updateClient(String clientId, ClientDto clientDto) {
        Optional<Client> clientById = clientRepository.findById(clientId);
        Client client = clientById.orElseThrow(() -> {
            throw new NotFoundException("Not found client by id = " + clientId);
        });
        setClient(client, clientDto);

        Client updateClient = clientRepository.save(client);

        return convertClientToResponse(updateClient);
    }

    public void deleteClient(String clientId) {
        Optional<Client> clientById = clientRepository.findById(clientId);
        Client client = clientById.orElseThrow(() -> {
            throw new NotFoundException("Not found client by id = " + clientId);
        });
        clientRepository.delete(client);
    }

    public void setClient(Client client, ClientDto clientDto) {
        client.setLogin(clientDto.getLogin());
        client.setPassword(clientDto.getPassword());
        client.setEmail(clientDto.getEmail());
        client.setName(clientDto.getName());
        client.setAdmin(clientDto.getAdmin());
    }

    public ClientDto convertClientToResponse(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .login(client.getLogin())
                .password(client.getPassword())
                .email(client.getEmail())
                .name(client.getName())
                .admin(client.getAdmin())
                .build();
    }
}
