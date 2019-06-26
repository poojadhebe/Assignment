package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import enums.GitSource;
import model.GitRepositoryResponse;

/**
 * This class is responsible for fetching the projects information from GitHub.
 * @author pdhebe
 */
@PropertySource("classpath:url.properties")
public class GitHubController extends GitController {
	@Value("{github.url}")
	private String gitHubURL = "https://api.github.com/users/";
	@Value("{github.repo.path}")
	private String gitHubRepoPath = "/repos";
	@Value("{github.owner.path}")
	private String gitHubOwnerPath = "?affiliation=owner";

	/**
	 * This method is responsible for fetching the projects from GitHub based on
	 * username and ownership property.
	 * 
	 * @param name
	 * @param onlyOwnedProjects
	 * @return
	 */
	public List<GitRepositoryResponse> fetchGitHubProjects(String name, boolean onlyOwnedProjects) {
		String url = gitHubURL + name + gitHubRepoPath;
		if (onlyOwnedProjects) {
			url = url + gitHubOwnerPath;
		}
		return getGitProjects(url, GitSource.GIT_HUB);
	}

}
