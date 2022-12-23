package cn.wzw.multydatabases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Application.
 *
 * @author wangziwei
 */
@SpringBootApplication(scanBasePackages = {"cn.wzw.multydatabases"})
public class Application {
    /**
     * The entry point of application.
     * @author wangziwei
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
