package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import enums.GitSource;

/**
 * This class represents the response which will contain the project information
 * fetched from GitHub and GitLab based on name and ownership property.
 * 
 * @author pdhebe
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryResponse {
	String name;
	GitSource gitSource;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gitSource
	 */
	public GitSource getGitSource() {
		return gitSource;
	}

	/**
	 * @param gitSource
	 *            the gitSource to set
	 */
	public void setGitSource(GitSource gitSource) {
		this.gitSource = gitSource;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GitRepositoryResponse [name=");
		builder.append(name);
		builder.append(", gitSource=");
		builder.append(gitSource);

		builder.append("]");
		return builder.toString();
	}
}
