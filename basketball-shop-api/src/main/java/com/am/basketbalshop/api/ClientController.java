package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.ClientDto;
import com.am.basketballshop.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping(value = "/")
    ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @GetMapping(value = "/{clientId}")
    ClientDto getClient(@PathVariable String clientId) {
        return clientService.getClient(clientId);
    }

    @PutMapping(value = "/{clientId}")
    ClientDto updateClient(@PathVariable String clientId, @RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientId, clientDto);
    }

    @DeleteMapping(value = "/{clientId}")
    void deleteClient(@PathVariable String clientId) {
        clientService.deleteClient(clientId);
    }
}
