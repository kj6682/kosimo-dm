package chinook;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luigi on 02/08/16.
 */
@Controller
public class HomeController {

    @RequestMapping("/chinook")
    public String chinook(@RequestParam(value="name", required=false, defaultValue="Hop World") String name, Model model) {
        model.addAttribute("name", name);
        return "chinook";
    }


}