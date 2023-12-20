# VM options
SERVER_PORT := -DSERVER.PORT=8081
SPRING_PROFILES_ACTIVE := -Dspring.profiles.active=swagger
JAR_FILE := target/library-1.0-SNAPSHOT.jar

springBoot-run :
	@mvn spring-boot:start\
		-Dspring-boot.run.jvmArguments="${SERVER_PORT} ${SPRING_PROFILES_ACTIVE}"

springBoot-stop :
	@mvn spring-boot:stop

java-run :
	@mvn clean
	@mvn install
	@java $(SERVER_PORT) $(SPRING_PROFILES_ACTIVE) -jar $(JAR_FILE)

java-stop :
	@taskkill /f /im java.exe

help :
	@echo "List commands"
	@echo "springBoot-run   : Start app on spring-boot"
	@echo "springBoot-stop  : Stop app on spring-boot"
	@echo "java-run         : Start jar app"
	@echo "java-stop        : Stop jar app"
	@echo "help             : Information about commands"
