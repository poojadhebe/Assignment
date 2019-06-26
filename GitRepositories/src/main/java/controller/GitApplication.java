
package controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring boot application for fetching project information fromGitHub and GitLab.
 * @author pdhebe
 *
 */
@SpringBootApplication
public class GitApplication {

    public static void main(String[] args) {
    	System.setProperty("server.connection-timeout","-1");
        SpringApplication.run(GitApplication.class, args);
    }
}
