package com.unisabana.usuarios.rabbitMQ.ejemploClase;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws InterruptedException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672); // Puerto por defecto

            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                // Declaramos una cola si no existe
                String queueName = "DYAS_COLA";
                boolean durable = false;
                boolean exclusive = false;
                boolean autoDelete = false;
                channel.queueDeclare(queueName, durable, exclusive, autoDelete, null);

                // Publicar un mensaje en la cola

                // Crear un callback para procesar los mensajes recibidos

                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String message = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                };
                // Consumir mensajes de la cola    
                boolean autoAck = true;
                channel.basicConsume(queueName, autoAck, deliverCallback, consumerTag -> {
                });

                System.out.println(" [*] Waiting for messages." + queueName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
