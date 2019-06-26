package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import enums.GitSource;
import model.GitRepositoryResponse;
/**
 * This class is responsible for fetching the projects from GitLab.
 * @author pdhebe
 */
public class GitLabController extends GitController {
	@Value("{gitlab.url}")
	private String gitLabURL = "https://gitlab.com/api/v4/users/";
	@Value("{gitlab.repo.path}")
	private String gitLabRepoPath = "/projects";
	@Value("{gitlab.owner.path}")
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
