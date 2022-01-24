package pro.paullezin.bootjava.vouting.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pro.paullezin.bootjava.vouting.model.Role;
import pro.paullezin.bootjava.vouting.model.User;
import pro.paullezin.bootjava.vouting.repository.UserRepository;
import pro.paullezin.bootjava.vouting.security.AuthUser;
import pro.paullezin.bootjava.vouting.util.ValidationUtil;

import javax.validation.Valid;
import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final UserRepository userRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Object get(@AuthenticationPrincipal AuthUser authUser) {
        log.info("get {}", authUser);
        return authUser;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser) {
        log.info("delete {}", authUser);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        log.info("register {}", user);
        ValidationUtil.checkNew(user);
        user.setRoles(Set.of(Role.USER));
        user = userRepository.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/account")
                .build().toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody User user, @AuthenticationPrincipal AuthUser authUser) {
        log.info("update {}", user);
        User oldUser = authUser.getUser();
        ValidationUtil.assertConsistent(user, oldUser.getId());
        user.setRoles(oldUser.getRoles());
        if (user.getPassword() == null) {
            user.setPassword(oldUser.getPassword());
        }
        userRepository.save(user);
    }

}