FROM khipu/openjdk17-alpine
COPY target/*.jar library.jar
ENTRYPOINT ["sh", "-c", "java ${SERVER_PORT} ${SPRING_PROFILES_ACTIVE} -jar /library.jar"]


#Multistage
#FROM shinseiki/maven-openjdk-17 as builder
#COPY ./ ./
#RUN mvn clean package
#FROM lubanzhang/openjdk-17-alpine
#COPY --from=builder target/*.jar library-multistage.jar
#ENTRYPOINT ["java", "-jar", "library-multistage.jar"]
