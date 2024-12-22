package hello;

import org.springframework.stereotype.Component;

@Component
public class cricket implements Coach{
    @Override
    public String getdaily() {
        return "cricket walking";
    }
}
