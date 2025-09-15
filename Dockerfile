#FROM
#RUN
#CMD
#WORKDIR
#COPY
#EXPOSE

#FROM eclipse-temurin:17.0.15_6-jdk-ubi9-minimal 
#COPY target/usuarios-0.0.1-SNAPSHOT.jar ./backend_usuarios.jar
#ENV HOST='192.168.1.23'
#ENV USER='root'
#ENV PASS='root'
#EXPOSE 8083
#ENTRYPOINT ["java","-jar","backend_usuarios.jar"]


# Imagen oficial Jenkins LTS
FROM jenkins/jenkins:lts

USER root

# Instalar Docker dentro del contenedor (opcional para jobs que usen Docker)
RUN apt-get update && apt-get install -y docker.io sudo && rm -rf /var/lib/apt/lists/*

USER jenkins

