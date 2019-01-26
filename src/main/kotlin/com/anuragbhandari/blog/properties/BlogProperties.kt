package com.anuragbhandari.blog.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("blog")
class BlogProperties {

    // lateinit allows properties to be initialized later.
    // Otherwise, Kotlin mandates properties to be initialized while during declaration.
    lateinit var title: String
    val banner = Banner()

    class Banner {
        var title: String? = null
        lateinit var content: String
    }

}