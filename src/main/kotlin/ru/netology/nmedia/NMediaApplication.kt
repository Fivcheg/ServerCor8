package ru.netology.nmedia

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Author
import ru.netology.nmedia.dto.Comment
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.enumeration.AttachmentType
import ru.netology.nmedia.service.AuthorService
import ru.netology.nmedia.service.CommentService
import ru.netology.nmedia.service.PostService

@SpringBootApplication
class NMediaApplication {
    @Bean
    fun runner(postService: PostService, commentService: CommentService, authorService: AuthorService) =
        CommandLineRunner {
            val firstPost = postService.save(
                Post(
                    id = 0,
                    authorId = 1,
                    content = "Привет, это новая Нетология!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            val secondPost = postService.save(
                Post(
                    id = 0,
                    authorId = 2,
                    content = "Привет, это новый Сбер!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            val thirdPost = postService.save(
                Post(
                    id = 0,
                    authorId = 3,
                    content = "Нам и так норм!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            val fourthPost = postService.save(
                Post(
                    id = 0,
                    authorId = 4,
                    content = "Подкасты любят за возможность проводить время с пользой и слушать познавательные лекции или беседы во время прогулок или домашних дел. Интересно, что запустить свой подкаст и обсуждать интересные темы может любой.",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                    attachment = Attachment(
                        url = "podcast.jpg",
                        description = "Как запустить свой подкаст: подборка статей",
                        type = AttachmentType.IMAGE,
                    ),
                )
            )
            val fifthPost = postService.save(
                Post(
                    id = 0,
                    authorId = 5,
                    content = "Появился новый способ мошенничества \uD83D\uDE21 Злоумышленники звонят от имени банка и говорят, что для клиента выпущена новая, особо защищённая карта, которую можно добавить в приложение Кошелёк на смартфоне. Под диктовку мошенника человек привязывает к Кошельку его карту, причём указывает своё имя. Если карту пополнить, деньги уйдут мошеннику.\n\nДело в том, что в Кошелёк можно добавить любую, даже чужую карту, а имя поставить какое угодно. Но чужая банковская карта не будет отображаться, например, в СберБанк Онлайн.",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                    attachment = Attachment(
                        url = "sbercard.jpg",
                        description = "Предлагают новую карту? Проверьте, не мошенничество ли это!",
                        type = AttachmentType.IMAGE,
                    ),
                )
            )
            with(commentService) {
                save(
                    Comment(
                        id = 0,
                        postId = firstPost.id,
                        authorId = 2,
                        content = "Отлично!",
                        published = 0,
                        likedByMe = false,
                        likes = 0,
                    )
                )
                save(
                    Comment(
                        id = 0,
                        postId = firstPost.id,
                        authorId = 3,
                        content = "Мы тоже обновились!",
                        published = 0,
                        likedByMe = false,
                        likes = 0,
                    )
                )
                save(
                    Comment(
                        id = 0,
                        postId = secondPost.id,
                        authorId = 1,
                        content = "Новый логотип прекрасен!",
                        published = 0,
                        likedByMe = false,
                        likes = 0,
                    )
                )
            }

            val fifthAuthor = authorService.save(
                Author(
                    id = 5,
                    name = "netology",
                    avatar = "tcs.jpg"
                )
            )
            val fourAuthor = authorService.save(
                Author(
                    id = 4,
                    name = "tinkoff",
                    avatar = "tcs.jpg"
                )
            )
            val threeAuthor = authorService.save(
                Author(
                    id = 3,
                    name = "asd",
                    avatar = "tcs.jpg"
                )
            )
            val twoAuthor = authorService.save(
                Author(
                    id = 2,
                    name = "nsdd",
                    avatar = "tcs.jpg"
                )
            )
            val oneAuthor = authorService.save(
                Author(
                    id = 1,
                    name = "netaaaaology",
                    avatar = "tcs.jpg"
                )
            )
        }
}


fun main(args: Array<String>) {
    runApplication<NMediaApplication>(*args)
}
