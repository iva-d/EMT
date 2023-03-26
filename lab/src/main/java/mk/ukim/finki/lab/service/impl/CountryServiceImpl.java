package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.repository.CountryRepository;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(this.countryRepository.save(new Country(country.getName(), country.getContinent())));
    }
}
