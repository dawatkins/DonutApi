package co.grandcircus.DonutApi;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.DonutApi.model.RefResponse;
import co.grandcircus.DonutApi.model.Response;
import co.grandcircus.DonutApi.model.Results;

@Component
public class ApiService {
	
	private RestTemplate restTemplate = new RestTemplate();
	{
		// This configures the restTemplateWithUserAgent to include a User-Agent header
		// with every HTTP
		// request. Some of the APIs in this demo have a bug where User-Agent is
		// required.
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
			request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
			return execution.execute(request, body);
		};
		restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public List<Results> showAll(){
		String url = "https://grandcircusco.github.io/demo-apis/donuts.json";
		
		Response response = restTemplate.getForObject(url, Response.class);
		List<Results> results = response.getResults();
		
		return results;
	}
	
	public RefResponse getRefResponse(String id) {
		String url = "https://grandcircusco.github.io/demo-apis/donuts/" + id + ".json";
		
		RefResponse response = restTemplate.getForObject(url, RefResponse.class);
		return response;
	}
}
