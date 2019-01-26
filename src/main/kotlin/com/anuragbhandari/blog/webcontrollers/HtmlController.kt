package com.anuragbhandari.blog.webcontrollers

import com.anuragbhandari.blog.properties.BlogProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(private val properties: BlogProperties) {

    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = properties.title
        model["banner"] = properties.banner
        return "blog"
    }

}