package ind.liuer.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mingの
 * @date 2022/6/22 16:46
 * @since 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test() {
        return "Welcome to SpringSecurity";
    }
}
