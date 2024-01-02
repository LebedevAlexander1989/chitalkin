# VM options
SERVER_PORT := -DSERVER.PORT=8081
SPRING_PROFILES_ACTIVE := -Dspring.profiles.active=swagger
REMOTE_PORT := 8001
REMOTE_VM := -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:${REMOTE_PORT}
JAR_FILE := target/library-1.0-SNAPSHOT.jar

install-app:
	@mvn install

clean-app:
	@mvn clean

springBoot-run :
	@mvn spring-boot:start\
		-Dspring-boot.run.jvmArguments="${SERVER_PORT} ${SPRING_PROFILES_ACTIVE}"

springBoot-stop :
	@mvn spring-boot:stop

java-run :
	@java ${SERVER_PORT} ${SPRING_PROFILES_ACTIVE} ${REMOTE_VM} -jar $(JAR_FILE)

java-stop :
	@taskkill /f /im java.exe

start-java :: clean-app install-app java-run

start-spring-boot :: clean-app install-app springBoot-run

help :
	@echo "List commands"
	@echo "install-app        : Install app package"
	@echo "clean-app          : Clean app package"
	@echo "springBoot-run     : Start app on spring-boot"
	@echo "springBoot-stop    : Stop app on spring-boot"
	@echo "java-run           : Start jar app"
	@echo "java-stop          : Stop jar app"
	@echo "start-java         : Start java app with include clean and install app"
	@echo "start-spring-boot  : Start spring boot app with include clean and install app"
	@echo "help               : Information about commands"
