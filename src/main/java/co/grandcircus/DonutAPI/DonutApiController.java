package co.grandcircus.DonutAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.DonutAPI.apiservce.ApiService;
import co.grandcircus.DonutAPI.entity.Details;
import co.grandcircus.DonutAPI.entity.Results;

@Controller
public class DonutApiController {
	
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		List<Results> donut = apiService.getResults();
		mv.addObject("list", donut);
		return mv;
	}

	@RequestMapping("/details")
	public ModelAndView details(@RequestParam(value="id", required=false) Long id) {
		ModelAndView mv = new ModelAndView("details");
		
		Details detail = apiService.getInfo(id);
		mv.addObject("detail", detail);
		return mv;
		
	}
}
