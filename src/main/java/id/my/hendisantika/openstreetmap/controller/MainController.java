package id.my.hendisantika.openstreetmap.controller;

import id.my.hendisantika.openstreetmap.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-open-street-map
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 07/10/25
 * Time: 15.20
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class MainController {
    @GetMapping("/")
    public String locationSubmit(Model model) {
        model.addAttribute("Location", new Location());
        return "locationInterface";
    }
}
