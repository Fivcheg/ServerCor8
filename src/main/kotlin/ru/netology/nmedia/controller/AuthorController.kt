package ru.netology.nmedia.controller

import org.springframework.web.bind.annotation.*
import ru.netology.nmedia.service.AuthorService

@RestController
@RequestMapping("/api/authors")
class AuthorController(private val service: AuthorService) {
    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable id: Long) = service.getAuthorById(id)

}