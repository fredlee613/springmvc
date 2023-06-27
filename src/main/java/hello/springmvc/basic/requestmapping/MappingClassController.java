package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mapping/users")
public class MappingClassController {
    @GetMapping
    public String getUsers() {
        return "get-users";
    }

    @PostMapping()
    public String addUser() {
        return "add-user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable Long userId) {
        return "get-user" + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable Long userId) {
        return "update userId = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return "delete userId = " + userId;
    }
}
