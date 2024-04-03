package com.pragma.bootcamp.adapters.driving.http.controller;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateTechnologyRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.bootcamp.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.pragma.bootcamp.adapters.driving.http.mapper.ITechnologyResponseMapper;
import com.pragma.bootcamp.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTechnology(@RequestBody AddTechnologyRequest request) {
        technologyServicePort.saveTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //En postman http://localhost:8090/api/technology/
    }

    @GetMapping("/search/{technologyName}")
    public ResponseEntity<TechnologyResponse> getTechnology(@PathVariable String technologyName) {
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(technologyServicePort.getTechnology(technologyName)));
        //En postman http://localhost:8090/api/technology/search/Angular
    }

    @GetMapping("/")
    public ResponseEntity<List<TechnologyResponse>> getAllTechnologies(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(technologyResponseMapper.
                toTechnologyResponseList(technologyServicePort.getAllTechnologies(page, size)));
        //En postman http://localhost:8090/api/technology/?page=0&size=10
    }

    /*
    @GetMapping("/supplier/{supplierName}")
    public ResponseEntity<List<ProductResponse>> getAllProductsBySupplier(@RequestParam Integer page,
                                                                          @RequestParam Integer size,
                                                                          @PathVariable String supplierName) {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponseList(productServicePort.getAllProductsBySupplier(supplierName, page, size)));
    }

    @GetMapping("/soldout")
    public ResponseEntity<List<ProductResponse>> getAllSoldOut(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(productResponseMapper.
                toProductResponseList(productServicePort.getAllSoldOutProducts(page, size)));
    }
    */

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponse> updateTechnology(@RequestBody UpdateTechnologyRequest request) {
        return ResponseEntity.ok(technologyResponseMapper.toTechnologyResponse(
                technologyServicePort.updateTechnology(technologyRequestMapper.updateRequestToTechnology(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        technologyServicePort.deleteTechnology(id);
        return ResponseEntity.noContent().build();
        //En postman http://localhost:8090/api/technology/1
    }
}
