package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController {
    @GetMapping("/hello") // https:/localhost:8080/api/hello
    fun hello(): String{
        return "hello kotlin";
    }

    // 구버전
    @RequestMapping(method = [RequestMethod.GET],path=["/request-mapping"])
    fun requestMapping(): String{
        return "request-mapping";
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") // http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String{
        println("${name}, ${age}");
        return name+ " " +age;
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") // http://localhost:8080/api/get-mapping/path-variable/{name}
    fun pathVariable2(@PathVariable(value="name") _name: String, @PathVariable(name="age") age: Int): String{
        val name = "kotlin";
        println("${_name}, ${age}");
        return _name+ " " +age;
    }

    // http://localhost:8080/api/page?key=value&key=value&key=value
    @GetMapping("/get-mapping/query-param")
    fun queryParam(@RequestParam name: String, @RequestParam(value="age") age: Int): String{
        println("${name}, ${age}")
        return name+" " +age;
    }

    // name, age, address, email
    // ~
    // phoneNumber -> phonenumber, phone-number
    @GetMapping("/get-mapping/query-param.object")
    fun queryParamObject(userRequest: UserRequest): UserRequest{
        println(userRequest);
        return userRequest;
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String,Any>): Map<String,Any> {
        println(map);
        val phoneNumber = map.get("phone-number");
        return map;
    }


}