#işletim sistem,
FROM amazoncorretto:21.0.2-alpine3.19

#uygulamanın kopyalanması
COPY build/libs/UserMicroservice-v.0.1.jar app.jar

#komutları çalıştırması için. (java -jar app.jar komutu)
ENTRYPOINT ["java","-jar","app.jar"]


