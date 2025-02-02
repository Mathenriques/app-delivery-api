# Etapa de construção
FROM openjdk:21-jdk AS build

# Instalar Maven
RUN apt-get update && apt-get install -y maven && apt-get clean

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e baixe as dependências
COPY pom.xml .
COPY src ./src

# Execute o Maven para construir o projeto
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jdk

# Defina o diretório de trabalho
WORKDIR /app

# Copie o JAR gerado da etapa de build
COPY --from=build /app/target/meu-projeto-0.0.1-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]