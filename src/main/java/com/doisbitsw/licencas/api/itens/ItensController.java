package com.doisbitsw.licencas.api.itens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/itens")
public class ItensController {
    @Autowired
    private ItensService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ItensDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ItensDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getCarrosByCode(@PathVariable("code") String code) {
        List<ItensDTO> carros = service.getCarrosByCode(code);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/escola/{escola}")
    public ResponseEntity getCarrosByEscola(@PathVariable("escola") Long escola) {
        List<ItensDTO> carros = service.getCarrosByEscola(escola);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/cart")
    public long getCart() {
        return service.getCart();
    }




    @PostMapping

    public ResponseEntity post(@RequestBody Itens itens) {

        ItensDTO c = service.insert(itens);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @GetMapping("/ultimoid")
    public long getUltimoId() {
        return service.getUltimoId();
    }


    @GetMapping("/temcart/{escola}")
    public long getTemCart(@PathVariable("escola") Long escola) {
        return service.getTemCart(escola);
    }

    @GetMapping("/temcart1/{escola}")
    public long getTemCart1(@PathVariable("escola") Long escola) {
        return service.getTemCart1(escola);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCId(@PathVariable("id") Long id) {
        List<ItensDTO> carros = service.getId(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Itens itens) {
        itens.setId(id);
        ItensDTO c = service.update(itens, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
