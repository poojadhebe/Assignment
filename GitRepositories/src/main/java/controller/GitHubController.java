package controller;

import java.util.List;

import enums.GitSource;
import model.GitRepositoryResponse;

/**
 * This class is responsible for fetching the projects information from GitHub.
 * @author pdhebe
 */
public class GitHubController extends GitController {
	private String gitHubURL = "https://api.github.com/users/";
	private String gitHubRepoPath = "/repos";
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
