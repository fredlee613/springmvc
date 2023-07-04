package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/repsonse-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("OK");
    }

    /**
     * ResponseEntity (Http Status 추가)
     */
    @GetMapping("response-body-string-v2")
    public ResponseEntity responseBodyV2() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "OK";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData data = new HelloData();
        data.setUsername("userA");
        data.setAge(20);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {

        HelloData data = new HelloData();
        data.setUsername("userA");
        data.setAge(20);

        return data;
    }
}