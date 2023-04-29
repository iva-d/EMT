package mk.ukim.finki.lab.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryRestController {
    private final CountryService countryService;

    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }
}
