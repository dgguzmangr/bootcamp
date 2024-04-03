package com.pragma.bootcamp.adapters.driving.http.controller;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddTechCapRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateTechCapRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.response.TechCapResponse;
import com.pragma.bootcamp.adapters.driving.http.mapper.ITechCapRequestMapper;
import com.pragma.bootcamp.adapters.driving.http.mapper.ITechCapResponseMapper;
import com.pragma.bootcamp.domain.api.ITechCapServicePort;
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
@RequestMapping("/api/techcap")
@RequiredArgsConstructor
public class TechCapRestControllerAdapter {
    private final ITechCapServicePort techCapServicePort;
    private final ITechCapRequestMapper techCapRequestMapper;
    private final ITechCapResponseMapper techCapResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addTechCap(@RequestBody AddTechCapRequest request) {
        techCapServicePort.saveTechCap(techCapRequestMapper.addRequestToTechCap(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //En postman http://localhost:8090/api/techcap/
    }

    @GetMapping("/search/{techcapName}")
    public ResponseEntity<TechCapResponse> getTechCap(@PathVariable String techCapName) {
        return ResponseEntity.ok(techCapResponseMapper.toTechCapResponse(techCapServicePort.getTechCap(techCapName)));
        //En postman http://localhost:8090/api/techcap/search/Ejemplo
    }

    @GetMapping("/")
    public ResponseEntity<List<TechCapResponse>> getAllTechCapabilities(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(techCapResponseMapper.
                toTechCapResponseList(techCapServicePort.getAllTechCapabilities(page, size)));
        //En postman http://localhost:8090/api/techcap/?page=0&size=10
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
    public ResponseEntity<TechCapResponse> updateTechCap(@RequestBody UpdateTechCapRequest request) {
        return ResponseEntity.ok(techCapResponseMapper.toTechCapResponse(
                techCapServicePort.updateTechCap(techCapRequestMapper.updateRequestToTechCap(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechCap(@PathVariable Long id) {
        techCapServicePort.deleteTechCap(id);
        return ResponseEntity.noContent().build();
        //En postman http://localhost:8090/api/techcap/1
    }
}
