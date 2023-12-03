package com.restapi.controller;

import com.restapi.response.common.APIResponse;
import com.restapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class UploadController {

    @Autowired
    private APIResponse apiResponse;
    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createCamping(@RequestParam("photo") MultipartFile photo) {
        String file = storageService.storeFile(photo);

        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(file);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
