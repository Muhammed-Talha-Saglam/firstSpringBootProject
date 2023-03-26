package dev.bytecode.springboot.firstProject.firstProject.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FunRest {

    @GetMapping("/")
    fun home(): String {
        return "Spring is coming..."
    }
}