package controller;

/**
 * This class is responsible for exposing the REST APIs.
 * @author pdhebe
 */
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enums.GitSource;
import model.GitRepositoryResponse;
import service.GitService;

@RestController
public class GitRepositoryController {
	/**
	 * This method represents the REST API.
	 * 
	 * @param name
	 * @param owned
	 * @return
	 */
	@RequestMapping("/projects")
	public List<GitRepositoryResponse> fetchGitProjects(@RequestParam(value = "name") String name,
			@RequestParam(value = "owned", defaultValue = "false") boolean owned) {
		GitService gitService = new GitService();
		gitService.getGitProjects(GitSource.GIT_HUB, name, owned);
		gitService.getGitProjects(GitSource.GIT_LAB, name, owned);
		return gitService.getGitResponsesList();
	}

	@RequestMapping("/")
	public String displayHelloMessage() {
		return "Hello";
	}
}
