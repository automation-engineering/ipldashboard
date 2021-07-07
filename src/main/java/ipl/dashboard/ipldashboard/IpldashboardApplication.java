package ipl.dashboard.ipldashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class IpldashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpldashboardApplication.class, args);
	}

}
