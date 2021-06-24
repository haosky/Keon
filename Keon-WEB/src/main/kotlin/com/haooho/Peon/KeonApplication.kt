package com.haooho.Keon

import com.haooho.Keon.web.Properties.BlogProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class KeonApplication

fun main(args: Array<String>) {
	runApplication<KeonApplication>(*args){
		//setBannerMode(Banner.Mode.OFF)
	}
}
