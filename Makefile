# VM options
SERVER_PORT := -DSERVER.PORT=8081
SPRING_PROFILES_ACTIVE := -Dspring.profiles.active=swagger
REMOTE_PORT := 8001
REMOTE_VM := -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:${REMOTE_PORT}
JAR_FILE := target/library-1.0-SNAPSHOT.jar

.PHONY: install-app
install-app:
	@mvn install

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
	@echo "help                 : Information about commands"
