#!/usr/bin/env bash
mvn clean package
docker build -t oklimenko/payment-system .
docker tag oklimenko/payment-system oklimenko/payment-system:1.0.4
#docker push oklimenko/payment-system:1.0.0KafkaPaymentConsumer.java