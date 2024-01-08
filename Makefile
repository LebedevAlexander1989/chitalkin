# VM options
SERVER_PORT := -DSERVER.PORT=8081
SPRING_PROFILES_ACTIVE := -Dspring.profiles.active=swagger
REMOTE_PORT := 8001
REMOTE_VM := -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:${REMOTE_PORT}
JAR_FILE := target/library-1.0-SNAPSHOT.jar
DOCKER_IMAGE_NAME :=library

# Не находит путь к мавену, почему так?
MAVEN := $(shell command -v mvn 2> /dev/null)
MAVEN_ALIAS = "C:\Users\79855\apache-maven-3.9.6\bin"
.PHONY: init
init:
ifneq ($(MAVEN),)
$(eval MAVEN_ALIAS = $(MAVEN))
	@echo "MAVEN is installed at $(MAVEN_ALIAS)"
else
	@echo "MAVEN is not installed or not in PATH, default $(MAVEN_ALIAS)"
endif

.PHONY: install-app
package-app:
	@mvn package

.PHONY: clean-app
clean-app:
	@mvn clean

.PHONY: springBoot-run
springBoot-run :
	@mvn spring-boot:start\
		-Dspring-boot.run.jvmArguments="${SERVER_PORT} ${SPRING_PROFILES_ACTIVE}"

.PHONY: springBoot-stop
springBoot-stop :
	@mvn spring-boot:stop

.PHONY: java-run
java-run :
	@java ${SERVER_PORT} ${SPRING_PROFILES_ACTIVE} ${REMOTE_VM} -jar $(JAR_FILE)

.PHONY: java-stop
java-stop :
	@taskkill /f /im java.exe

.PHONY: java-run-all
java-run-all :: clean-app install-app java-run

.PHONY: springBoot-run-all
springBoot-run-all :: clean-app install-app springBoot-run

.PHONY: docker-build
docker-build:: clean-app package-app
	@docker build -t ${DOCKER_IMAGE_NAME} .

.PHONY: docker-run
docker-run:
	@docker run -p ${REMOTE_PORT}:${REMOTE_PORT} -e SERVER_PORT=${SERVER_PORT} -e SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE} ${DOCKER_IMAGE_NAME}


.PHONY: help
help :
	@echo "List commands"
	@echo "install-app          : Install app package"
	@echo "clean-app            : Clean app package"
	@echo "springBoot-run       : Start app on spring-boot"
	@echo "springBoot-stop      : Stop app on spring-boot"
	@echo "java-run             : Start jar app"
	@echo "java-stop            : Stop jar app"
	@echo "java-run-all         : Start java app with include clean and install app"
	@echo "springBoot-run-all   : Start spring boot app with include clean and install app"
	@echo "docker-build         : Build image for app"
	@echo "docker-run           : Run container for app"
	@echo "help                 : Information about commands"
