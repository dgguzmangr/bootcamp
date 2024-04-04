package com.pragma.bootcamp.adapters.driving.http.controller;

import com.pragma.bootcamp.adapters.driving.http.dto.request.AddBootcampRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.request.UpdateBootcampRequest;
import com.pragma.bootcamp.adapters.driving.http.dto.response.BootcampResponse;
import com.pragma.bootcamp.adapters.driving.http.mapper.IBootacampRequestMapper;
import com.pragma.bootcamp.adapters.driving.http.mapper.IBootcampResponseMapper;
import com.pragma.bootcamp.domain.api.IBootcampServicePort;
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
@RequestMapping("/api/bootcamp")
@RequiredArgsConstructor
public class BootcampRestControllerAdapter {
    private final IBootcampServicePort bootcampServicePort;
    private final IBootacampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;

    @PostMapping("/")
    public ResponseEntity<Void> addBootcamp(@RequestBody AddBootcampRequest request) {
        bootcampServicePort.saveBootcamp(bootcampRequestMapper.addRequestToBootcamp(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //En postman http://localhost:8090/api/bootcamp/
    }

    @GetMapping("/search/{bootcampName}")
    public ResponseEntity<BootcampResponse> getBootcamp(@PathVariable String bootcampName) {
        return ResponseEntity.ok(bootcampResponseMapper.toBootcampResponse(bootcampServicePort.getBootcamp(bootcampName)));
        //En postman http://localhost:8090/api/bootcamp/search/ALGO
    }

    @GetMapping("/")
    public ResponseEntity<List<BootcampResponse>> getAllBootcamps(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(bootcampResponseMapper.
                toBootcampResponseList(bootcampServicePort.getAllBootcamps(page, size)));
        //En postman http://localhost:8090/api/bootcamp/?page=0&size=10
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
    public ResponseEntity<BootcampResponse> updateBootcamp(@RequestBody UpdateBootcampRequest request) {
        return ResponseEntity.ok(bootcampResponseMapper.toBootcampResponse(
                bootcampServicePort.updateBootcamp(bootcampRequestMapper.updateRequestToBootcamp(request))
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable Long id) {
        bootcampServicePort.deleteBootcamp(id);
        return ResponseEntity.noContent().build();
        //En postman http://localhost:8090/api/bootcamp/1
    }
}
