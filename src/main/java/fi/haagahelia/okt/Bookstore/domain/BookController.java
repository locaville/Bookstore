package fi.haagahelia.okt.Bookstore.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BookController {
	
	@RequestMapping(value="/index")
	public String bookStore() {
		return "Bookstore";
	}

}
