package gittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import controller.GitController;
import controller.GitHubController;
import controller.GitLabController;
import model.GitRepositoryResponse;

@PropertySource("classpath: url.properties")
public class TestGitApplication {

	@Test
	public void testGitHubURL() {
		
		GitHubController gitHubController = new GitHubController();
		List<GitRepositoryResponse> gitRepoResponse=gitHubController.fetchGitHubProjects("poojadhebe", false);
		assertEquals(true, gitRepoResponse.size()>0);
	}
	
	@Test
	public void testGitLabURL() {
		GitLabController gitLabController = new GitLabController();
		List<GitRepositoryResponse> gitRepoResponse=gitLabController.fetchGitLabProjects("poojadhebe", false);
		assertEquals(true, gitRepoResponse.size()>0);
	}
	
	@Test
	public void testGitLabURLOwned() {
		GitLabController gitLabController = new GitLabController();
		List<GitRepositoryResponse> gitRepoResponse=gitLabController.fetchGitLabProjects("poojadhebe", false);
		assertEquals(true, gitRepoResponse.size()>0);
	}
	
	
}
