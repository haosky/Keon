import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.haooho"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8


plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.github.johnrengelman.shadow") version "4.0.1" apply false
	kotlin("jvm") version "1.5.10"
	kotlin("plugin.spring") version "1.5.10"
	kotlin("plugin.jpa") version "1.5.10"
}

repositories {
	mavenCentral()
}
extra["springCloudVersion"] = "2020.0.3"
dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("io.micrometer:micrometer-registry-influx")
	runtimeOnly("org.hsqldb:hsqldb")
	annotationProcessor("org.projectlombok:lombok")

}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}


allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

project(":Peon-WEB") {
	apply(plugin = "java")
	apply(plugin = "kotlin")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "kotlin-spring")
	apply(plugin = "kotlin-jpa")

	repositories {
		mavenCentral()
	}
	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		implementation("org.springframework.boot:spring-boot-starter-mustache")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("io.projectreactor:reactor-test")
		testImplementation("org.springframework.amqp:spring-rabbit-test")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("org.springframework.boot:spring-boot-starter-amqp")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		implementation("org.springframework.cloud:spring-cloud-starter-zookeeper-discovery")
		compileOnly("org.projectlombok:lombok")
		runtimeOnly("io.micrometer:micrometer-registry-influx")
		runtimeOnly("org.hsqldb:hsqldb")
	}
}