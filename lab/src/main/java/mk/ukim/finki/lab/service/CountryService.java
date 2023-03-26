package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> save(Country country);

}
