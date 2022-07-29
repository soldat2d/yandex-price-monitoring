package net.da.net.yandextaxipricemonitoring.controller;

import lombok.RequiredArgsConstructor;
import net.da.net.yandextaxipricemonitoring.model.MomentPrice;
import net.da.net.yandextaxipricemonitoring.service.TaxiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class DefaultController {
    private final TaxiService taxiService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getPrice () throws IOException {
        return new ResponseEntity<>(new String(Files.readAllBytes(Paths.get("./src/main/resources/response.json"))), HttpStatus.OK);
    }

    @GetMapping("/prices")
    List<MomentPrice> getAllPrice() {
        return taxiService.getAllPrice();
    }
}
