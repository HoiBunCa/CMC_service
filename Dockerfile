FROM docker-registry.tima-ai.dev/oracle/serverjre:1.8.0_241-b07 as runtime
WORKDIR /app
COPY build/libs/call_CMC-1.0.0.jar /app/cmcservice.jar
RUN mkdir /app/data
ENV TZ=Asia/Ho_Chi_Minh

HEALTHCHECK --interval=1m --timeout=3s CMD curl --fail http://localhost:18080/cmc-check/health-check || exit 1

ENTRYPOINT ["java", "-jar", "cmcservice.jar"]

