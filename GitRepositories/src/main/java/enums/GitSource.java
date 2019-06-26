package enums;
/**
 * This enum denotes the Git type.
 * @author pdhebe
 *
 */
public enum GitSource {	
    GIT_HUB("GitHub"),GIT_LAB("GitLab");
	String gitSource;
	private GitSource(String source)
	{
		gitSource=source;
	}
	@Override
	public String toString() {
		return gitSource;
	}
	
}
