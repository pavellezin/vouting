package pro.paullezin.bootjava.vouting.security;

import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;
import pro.paullezin.bootjava.vouting.model.User;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthUser (@NonNull User user){
        super(user.getEmail(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public Integer getId(){
        return user.getId();
    }
}
