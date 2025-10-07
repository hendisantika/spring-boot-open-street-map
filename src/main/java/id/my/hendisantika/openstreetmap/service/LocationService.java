package id.my.hendisantika.openstreetmap.service;

import id.my.hendisantika.openstreetmap.model.Location;
import id.my.hendisantika.openstreetmap.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-open-street-map
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/10/25
 * Time: 15.31
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    @PostConstruct
    public void initData() {
        if (locationRepository.count() == 0) {
            log.info("Initializing West Java & Jakarta locations...");

            // Jakarta locations
            locationRepository.save(createLocation("Monas (National Monument)",
                    "-6.1753924", "106.8271528", "Indonesia", "Jakarta's iconic landmark"));
            locationRepository.save(createLocation("Kota Tua Jakarta (Old Town)",
                    "-6.1350794", "106.8133287", "Indonesia", "Historic district with colonial buildings"));
            locationRepository.save(createLocation("Taman Mini Indonesia Indah",
                    "-6.3024905", "106.8951965", "Indonesia", "Cultural theme park representing Indonesian diversity"));
            locationRepository.save(createLocation("Jakarta Cathedral",
                    "-6.1667897", "106.8303707", "Indonesia", "Neo-Gothic Catholic cathedral"));
            locationRepository.save(createLocation("Ancol Dreamland",
                    "-6.1228696", "106.8334268", "Indonesia", "Recreational complex with beach and theme parks"));

            // West Java locations
            locationRepository.save(createLocation("Gedung Sate",
                    "-6.9002112", "107.6188044", "Indonesia", "Iconic government building in Bandung"));
            locationRepository.save(createLocation("Tangkuban Perahu Volcano",
                    "-6.7597449", "107.6096154", "Indonesia", "Active stratovolcano near Bandung"));
            locationRepository.save(createLocation("Kawah Putih (White Crater)",
                    "-7.1661016", "107.4024677", "Indonesia", "Stunning white volcanic crater lake"));
            locationRepository.save(createLocation("Pangandaran Beach",
                    "-7.6857452", "108.6474924", "Indonesia", "Beautiful beach and nature reserve"));
            locationRepository.save(createLocation("Bogor Botanical Gardens",
                    "-6.5971469", "106.7991667", "Indonesia", "Historic 87-hectare botanical garden"));
            locationRepository.save(createLocation("Braga Street Bandung",
                    "-6.9171468", "107.6092668", "Indonesia", "Historic shopping street with colonial architecture"));
            locationRepository.save(createLocation("Situ Patenggang",
                    "-7.1598", "107.3773", "Indonesia", "Picturesque lake in South Bandung"));

            log.info("Initialized {} locations", locationRepository.count());
        }
    }

    private Location createLocation(String name, String lat, String lon, String country, String description) {
        Location location = new Location();
        location.setName(name);
        location.setLatitude(lat);
        location.setLongitude(lon);
        location.setCountry(country);
        location.setDescription(description);
        location.setPlace_id(String.valueOf(System.currentTimeMillis()));
        return location;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }
}
