package co.edu.icesi.sgiv.controller.screens.entity;


import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.dto.type.IdentificationTypeDTO;
import co.edu.icesi.sgiv.repository.entity.ClientRepository;
import co.edu.icesi.sgiv.request.ClientRequest;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.ClientService;
import co.edu.icesi.sgiv.service.abstraction.type.IdentificationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @Autowired
    private final IdentificationTypeService identificationTypeService;

    @PostMapping(value = "/page_client", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<ClientDTO>> pageClient(@RequestBody ClientRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        return ResponseEntity.ok(clientService.findByFilter(request.getIdNum(), request.getBDateLower(),
                                                            request.getBDateUpper(), request.getStatus(), pageable).toList());
    }

    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<Long> countClient() {
        return ResponseEntity.ok(clientService.count());
    }

    @RequestMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO client) {
        client.setCreationDate(LocalDateTime.now());
        try{
            clientService.save(client);
            return ResponseEntity.ok(null);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/idTypes", produces = "application/json")
    public ResponseEntity<List<IdentificationTypeDTO>> idTypesClient() {
        return ResponseEntity.ok(identificationTypeService.findAll());
    }
}
