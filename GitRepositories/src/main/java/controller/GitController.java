package controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import enums.GitSource;
import model.GitRepositoryResponse;
/**
This class is responsible for  consuming the GIT URL based on parameters like name and gitType {@link GitSource}
*/
public class GitController {
	private RestTemplate restTemplate = new RestTemplate();
	private final Log log = LogFactory.getLog(GitController.class);

	/**
	 * This method will consume the GIT REST API for fetching the projects based on given name. 
	 * @param name
	 * @return
	 */
	public List<model.GitRepositoryResponse> getGitProjects(String URL, GitSource gitType) {
		try {
			ResponseEntity<List<GitRepositoryResponse>> gitRepositoryResponseList = (ResponseEntity<List<GitRepositoryResponse>>) restTemplate
					.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<GitRepositoryResponse>>() {
					});
			gitRepositoryResponseList.getBody().stream().forEach(response -> response.setGitType(gitType));
			return gitRepositoryResponseList.getBody();
		} catch (HttpClientErrorException ex) {
			log.info("Projects not found in " + gitType);
		}
		return null;
	}
}
