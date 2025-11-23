# ---- STAGE 1: BUILD ----
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Copia apenas os arquivos de build primeiro (cache)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Executa um build vazio para cache das dependências
RUN ./gradlew dependencies --no-daemon || true

# Agora copia o restante do projeto
COPY . .

# Gera o JAR
RUN ./gradlew clean build -x test --no-daemon


# ---- STAGE 2: RUNTIME ----
FROM eclipse-temurin:25-jdk

WORKDIR /app

# Copia o JAR gerado para a imagem final
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
