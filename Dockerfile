FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./build/libs/YandexTaxiPriceMonitoring-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","YandexTaxiPriceMonitoring-0.0.1-SNAPSHOT.jar"]