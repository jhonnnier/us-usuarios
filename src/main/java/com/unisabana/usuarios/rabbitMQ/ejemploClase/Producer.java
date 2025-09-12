package com.unisabana.usuarios.rabbitMQ.ejemploClase;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setPort(5672); // Puerto por defecto
            /*factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setVirtualHost("/");*/

            // Crear un canal de comunicación
            Connection connection = factory.newConnection();
            // Crear canal
            Channel channel = connection.createChannel();

            //Mejor usar try con recursos

            // Declaramos una cola si no existe
            String queueName = "DYAS_COLA";
            boolean durable = false;
            boolean exclusive = false;
            boolean autoDelete = false;
            channel.queueDeclare(queueName, durable, exclusive, autoDelete, null);

            // Publicar un mensaje en la cola
            String message = "Hola, Este es un mensaje de RabbitMQ!";

//            Direct exchange
//            Fanout exchange
//            Topic exchange
//            Headers exchange

            /**
             * primer parametro: que tipo de exchanges
             * 2do parametro: nombre de la cola
             * 3er parametro: Propiedades del mensaje (Seguridad, persistencia, etc
             * 4to parametro: mensaje en bytes "UTF-8")
             */
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            // Cierrra canal y conexión
            channel.close();
            connection.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
