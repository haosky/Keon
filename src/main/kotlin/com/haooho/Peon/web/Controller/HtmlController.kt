package com.haooho.Peon.web.Controller

import com.haooho.Peon.web.Entities.Article
import com.haooho.Peon.web.Entities.User

import com.haooho.Peon.web.Repositories.ArticleRepository
import org.springframework.http.HttpStatus.*
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException
import com.haooho.Peon.web.Extensions.format
import com.haooho.Peon.web.Properties.BlogProperties

@Controller
class HtmlController(private val repository: ArticleRepository,
                     private val properties: BlogProperties) {

    @GetMapping("/")
    fun Home(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        model["articles"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "blog"
    }

    @GetMapping("/services")
    fun Services(model: Model): String {
        model["title"] = "services"
        model["banner"] = properties.banner
        return "services"
    }

    @GetMapping("/article/{slug}")
    fun article(@PathVariable slug: String, model: Model): String {
        val article = repository
                .findBySlug(slug)
                ?.render()
                ?: throw ResponseStatusException(NOT_FOUND, "This article does not exist")
        model["title"] = article.title
        model["article"] = article
        return "article"
    }

    fun Article.render() = RenderedArticle(
            slug,
            title,
            headline,
            content,
            author,
            addedAt.format()
    )

    data class RenderedArticle(
            val slug: String,
            val title: String,
            val headline: String,
            val content: String,
            val author: User,
            val addedAt: String)

}
