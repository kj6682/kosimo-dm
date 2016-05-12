package org.kj6682.kosimo.media;

import org.kj6682.kosimo.commons.Feature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Feature(value = "home")
	@RequestMapping(value = "/", produces = "application/html")
	public String index() {
		return "index";
	}

}