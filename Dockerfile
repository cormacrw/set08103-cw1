FROM openjdk:latest
COPY ./target/classes/com /tmp/com
COPY ./homeListItems.txt /tmp/homeListItems.txt
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.App"]
EXPOSE 3000