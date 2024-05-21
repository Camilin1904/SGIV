package co.edu.icesi.sgiv.controller.screens.entity;


import co.edu.icesi.sgiv.controller.screens.entity.requests.ClientRequest;
import co.edu.icesi.sgiv.domain.entity.Client;
import co.edu.icesi.sgiv.dto.entity.ClientDTO;
import co.edu.icesi.sgiv.service.abstraction.entity.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ClientController {

    @Autowired
    private final ClientService clientService;

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


}
