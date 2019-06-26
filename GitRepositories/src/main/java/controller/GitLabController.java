package controller;

import java.util.List;

import enums.GitSource;
import model.GitRepositoryResponse;
/**
 * This class is responsible for fetching the projects from GitLab.
 * @author pdhebe
 */
public class GitLabController extends GitController {
	private String gitLabURL = "https://gitlab.com/api/v4/users/";
	private String gitLabRepoPath = "/projects";
	private String gitLabOwnerPath = "?owned=1";

	/**
	 * This method is responsible for fetching the projects from GitLab based on
	 * username and ownership property.
	 * 
	 * @param name
	 * @param onlyOwnedProjects
	 * @return
	 */
	public List<GitRepositoryResponse> fetchGitLabProjects(String name, boolean onlyOwnedProjects) {
		String url = gitLabURL + name + gitLabRepoPath;
		if (onlyOwnedProjects) {
			url = url + gitLabOwnerPath;
		}
		return getGitProjects(url, GitSource.GIT_LAB);
	}
}
