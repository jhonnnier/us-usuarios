#FROM
#RUN
#CMD
#WORKDIR
#COPY
#EXPOSE

FROM eclipse-temurin:17.0.15_6-jdk-ubi9-minimal 
COPY target/usuarios-0.0.1-SNAPSHOT.jar ./backend_usuarios.jar
ENV HOST='192.168.1.23'
ENV USER='root'
ENV PASS='root'
EXPOSE 8080
ENTRYPOINT["java","-jar","backend_usuarios.jar"]


