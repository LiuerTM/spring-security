package ind.liuer.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mingの
 * @date 2022/6/23 10:28
 * @since 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Welcome to SpringSecurity QuickStart";
    }
}
