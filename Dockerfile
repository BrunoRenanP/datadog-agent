FROM openjdk:17-jdk-alpine as builder

RUN apk add curl

RUN mkdir -p target
RUN curl -Lo target/dd-java-agent.jar https://dtdg.co/latest-java-tracer && ls -lh target/dd-java-agent.jar

COPY ./target/teste-1.0.jar .

EXPOSE 8080

ENV DD_AGENT_HOST=datadog-agent
ENV DD_TRACE_ENABLED=true
ENV DD_ENV=dev

CMD ["java", "-javaagent:/target/dd-java-agent.jar","-Ddd.service=test", "-Ddd.env=dev","-Ddd.trace.sample.rate=1", "-jar", "/teste-1.0.jar"]
