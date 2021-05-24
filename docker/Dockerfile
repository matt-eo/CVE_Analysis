FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
RUN mkdir /opt/app/
COPY relate-data-test-0.0.1-SNAPSHOT.jar CVE.json /opt/app/
ENTRYPOINT ["java", "-jar", "/opt/app/relate-data-test-0.0.1-SNAPSHOT.jar", "--file.name=/opt/app/CVE.json"]
