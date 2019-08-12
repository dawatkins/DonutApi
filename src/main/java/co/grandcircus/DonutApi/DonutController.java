package co.grandcircus.DonutApi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.DonutApi.model.RefResponse;
import co.grandcircus.DonutApi.model.Results;

@Controller
public class DonutController {
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/")
	public ModelAndView showIndex() {
		List<Results> results = apiService.showAll();
		
		return new ModelAndView("index", "results", results);
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView showDetails(
			@PathVariable("id") String id) {
		RefResponse result = apiService.getRefResponse(id);
		return new ModelAndView("details", "result", result);
	}
}
