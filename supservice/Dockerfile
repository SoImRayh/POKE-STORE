FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copia apenas arquivos de build primeiro (cache de dependências)
COPY pom.xml .

RUN mvn dependency:go-offline

# Porta padrão Spring
EXPOSE 8080

# Comando em modo desenvolvimento
CMD ["mvn", "spring-boot:run"]