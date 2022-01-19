package pro.paullezin.bootjava.vouting;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.paullezin.bootjava.vouting.model.Role;
import pro.paullezin.bootjava.vouting.model.User;
import pro.paullezin.bootjava.vouting.repository.UserRepository;

import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class VoutingApplication implements ApplicationRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(VoutingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(userRepository.findAll());
    }
}