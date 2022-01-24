package pro.paullezin.bootjava.vouting;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class VoutingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoutingApplication.class, args);
    }

}