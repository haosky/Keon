package de.swirtz.springwebflux.routing

import de.swirtz.springwebflux.handler.ReactiveHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router

//@Configuration
//class RoutingConfiguration {
//
//    @Bean
//    fun routerFunction(handler: ReactiveHandler): RouterFunction<ServerResponse> = router {
//        ("/reactive").nest {
//            val searchPathName = "search"
//            val savePathName = "save"
//            GET("/{$searchPathName}") { req ->
//                val pathVar = req.pathVariable(searchPathName)
//                ok().body(handler.getName(pathVar))
//            }
//            GET("/") {
//                ok().body(handler.getAllNames())
//            }
//            PUT("/{$savePathName}") { req ->
//                val pathVar = req.pathVariable(savePathName)
//                ok().body(handler.addName(pathVar))
//            }
//        }
//    }
//}

////Delivers index.html
//@RequestMapping("/")
//@RestController
//class IndexController
