plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.unizone"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

//dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-security")
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("org.springframework.boot:spring-boot-starter-websocket:3.3.2")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//	runtimeOnly("mysql:mysql-connector-java:8.0.33")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.security:spring-security-test")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	compileOnly("org.projectlombok:lombok")
//	annotationProcessor("org.projectlombok:lombok")
//	implementation("org.springframework.boot:spring-boot-starter-amqp")
//}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc") //순수 JDBC 접근 지원
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	//runtimeOnly("mysql:mysql-connector-java:8.0.33")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")

	// 외부 브로커를 사용하기 위해
	implementation("org.springframework.boot:spring-boot-starter-reactor-netty:2.4.6")

	// jackson2json에서 LocalDateTime을 handling 하기 위해
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.4")

	// WebSocket 클라이언트 지원
	implementation("org.webjars:sockjs-client:1.1.2")
	implementation("org.webjars:stomp-websocket:2.3.3-1")
}
tasks.withType<Test> {
	useJUnitPlatform()
}
