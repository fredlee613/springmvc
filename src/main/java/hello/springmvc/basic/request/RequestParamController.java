package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    /**
     * 반환 타입이 없고 반환값을 직접 입력 시 => view 조회 X
     */
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);
        response.getWriter().write("OK");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {
        log.info("username = {}, age = {}", memberName, memberAge);
        return "OK";
    }

    /**
     * 변수명이 같을 경우 이름 생략 가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    /**
     * 단순 타입의 경우 @ReauestParam 생략 가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    /**
     * 파라미터 필수 여부 - required 설정
     */
    @ResponseBody
    @RequestMapping("request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) {
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    /**
     * 파라미터 필수 여부 - required defaultValue 설정
     */
    @ResponseBody
    @RequestMapping("request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                      @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("username = {}, age = {}", username, age);
        return "OK";
    }

    /**
     * 파라미터를 Map으로 조회하기
     */
    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "OK";
    }

    /**
     * HTTP 요청 파라미터 - @ModelAttribute: 객체 파라미터 바인딩
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getUsername());
        return "OK";
    }

    /**
     * @ModelAttrubite 생략 가능
     * String, int와 같은 단순 타입 => 생략 가능
     * 프로퍼티가 복잡한 경우 argument resolver 사용
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "OK";
    }
}
