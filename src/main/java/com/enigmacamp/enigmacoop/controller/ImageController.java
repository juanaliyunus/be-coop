package com.enigmacamp.enigmacoop.controller;

import com.enigmacamp.enigmacoop.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/image")
public class ImageController {
    private final ImageService imageService;
    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> downloadImageProduct(@PathVariable(name = "imageId") String id) {
        Resource resource = imageService.getById(id);
        String headerValue = String.format("attachment; filename=%s", resource.getFilename());
        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
