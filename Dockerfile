FROM eclipse-temurin:20-jdk-alpine

# BUILD
WORKDIR /build
COPY . .
RUN chmod +x mvnw && \
    ./mvnw clean compile package -Dmaven.test.skip=true

FROM eclipse-temurin:20-jdk-alpine

# SETUP
ENV SERVER_PORT=8080
EXPOSE 8080

# COPY APP JAR FROM THE BUILD CONTAINER
WORKDIR /app
COPY --from=0 /build/fastjk-backend/target/fastjk-*.jar ./fastjk.jar

# START
ENTRYPOINT ["java", "-jar", "fastjk.jar"]

