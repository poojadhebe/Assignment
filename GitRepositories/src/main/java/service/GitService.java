package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import controller.GitHubController;
import controller.GitLabController;
import enums.GitSource;
import model.GitRepositoryResponse;

@Service
public class GitService {

	List<GitRepositoryResponse> gitResponsesList = new ArrayList<GitRepositoryResponse>();

	/**
	 * @return the gitResponsesList
	 */
	public List<GitRepositoryResponse> getGitResponsesList() {
		return gitResponsesList;
	}

	/**
	 * @param gitResponsesList
	 *            the gitResponsesList to set
	 */
	public void setGitResponsesList(List<GitRepositoryResponse> gitResponsesList) {
		this.gitResponsesList = gitResponsesList;
	}
/**
 * 
 * @param gitSource
 * @param name
 * @param owned
 */
	public void getGitProjects(GitSource gitSource, String name, boolean owned) {		
		if (GitSource.GIT_HUB.equals(gitSource)) {
			GitHubController gitHubController = new GitHubController();
			List<GitRepositoryResponse> gitHubResponseList = gitHubController.fetchGitHubProjects(name, owned);
			if (gitHubResponseList != null) {
				gitResponsesList.addAll(gitHubResponseList);
			}
		} else {
			GitLabController gitLabController = new GitLabController();
			List<GitRepositoryResponse> gitLabResponseList = gitLabController.fetchGitLabProjects(name, owned);
			if (gitLabResponseList != null) {
				gitResponsesList.addAll(gitLabResponseList);
			}
		}
	}
}
