package com.haooho.Peon

import com.haooho.Peon.web.Properties.BlogProperties
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class PeonApplication

fun main(args: Array<String>) {
	runApplication<PeonApplication>(*args){
		//setBannerMode(Banner.Mode.OFF)
	}
}
