package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Pontalti X
 *
 */

@SpringBootApplication
@ComponentScan("com")
public class MainApp extends SpringBootServletInitializer {
    
	public MainApp() {
		super();
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainApp.class);
    }

	public static void main(String[] args) {
		new MainApp().configure(new SpringApplicationBuilder(MainApp.class)).run(args);
	}

}
