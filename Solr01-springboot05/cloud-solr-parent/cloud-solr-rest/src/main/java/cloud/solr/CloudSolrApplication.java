package cloud.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CloudSolrApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSolrApplication.class, args);
	}
}
