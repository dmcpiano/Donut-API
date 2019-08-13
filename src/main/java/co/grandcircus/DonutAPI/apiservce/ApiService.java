package co.grandcircus.DonutAPI.apiservce;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.DonutAPI.entity.Details;
import co.grandcircus.DonutAPI.entity.Results;
import co.grandcircus.DonutAPI.entity.ResultsResponse;

@Component
	public class ApiService {
		

private RestTemplate restTemplate = new RestTemplate();
	
	{
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
	        request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
	        return execution.execute(request, body);
	    };
	    restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public List<Results> getResults(){
		
		String url = "https://grandcircusco.github.io/demo-apis/donuts.json";
		
		ResultsResponse response = restTemplate.getForObject(url, ResultsResponse.class);
		
		return response.getResults();
	}
	
	public Details getInfo(Long id) {
		
		String url ="https://grandcircusco.github.io/demo-apis/donuts/" + id + ".json";
		
		Details response = restTemplate.getForObject(url, Details.class);

		return response;

	}
}

