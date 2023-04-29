package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.repository.CountryRepository;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}
