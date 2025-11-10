FROM bfg/api-java8-maven-exp-srv-builder
EXPOSE 8080

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ONBUILD ADD . /usr/src/app
ONBUILD RUN mvn install
ONBUILD ADD C:\Users\joaop\.vscode\Insper\projsoftware\pf-projsoftware/projsoftware-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","/app.jar"]