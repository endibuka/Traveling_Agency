package controller;

import com.example.TravellingAgency.demo.entity.Continent;
import com.example.TravellingAgency.demo.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/continent")
public class ContinentController {
    @Autowired
    ContinentService continentService;

    @PostMapping("/addContinent")
    public Continent createContinent(@RequestBody Continent continent) {
        return continentService.createContinent(continent);
    }
}
