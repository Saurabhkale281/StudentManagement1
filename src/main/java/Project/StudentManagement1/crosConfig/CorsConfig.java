package Project.StudentManagement1.crosConfig;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowedOrigins("https://student-management-mu.vercel.app") // Allow frontend domain
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
	                .allowedHeaders("*") // Allow all headers
	                .allowCredentials(true); // Allow credentials if needed
	    }
}