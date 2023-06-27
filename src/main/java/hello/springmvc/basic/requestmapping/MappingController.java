package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    // spring boot 3.xx 부터는 "/hello-basic"와 "/hello-basic/"는 다른 URL이다.
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hello-basic");
        return "OK";
    }

    // http 매서드 매핑
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "OK";
    }

    // http 매서드 매핑 축약
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "OK";
    }

    // pathVariable(경로변수) 사용
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "OK";
    }

    // pathVariable의 이름과 파라미터의 이름이 같으면 이름 생략 가능
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId = {], orderId = {}", userId, orderId);
        return "OK";
    }

    // 특정 파라미터 조건 매핑: 특정 파라미터의 유무 조건에 대한 추가 가능
    @GetMapping(value = "/mapping-param", params = "mode=debug") // 띄어쓰기 하지 않을 것
    public String mappingParam() {
        log.info("mappingParam");
        return "OK";
    }

    // 특정 헤더 조건 매핑: HTTP 헤더에 대한 조건 추가 기능
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "OK";
    }

    // 미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume: HTTP 요청의 Content-Type 헤더를 기반으로 미디어 타입으로 매핑한다
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsume");
        return "OK";
    }

    // 미디어 타입 조건 매핑 - HTTP 요청 Accept, produce: HTTP 요청의 Accept 헤더를 기반으로 미디어 타입으로 매핑한다
    @GetMapping(value = "mapping-produce", produces = "text/html")
    public String mappingProduce() {
        log.info("mappingProduce");
        return "OK";
    }

}
