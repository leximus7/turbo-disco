package ru.lebedev.javalearn.vladykin.net.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class DatagramClient {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = encodePacket("Hello world!", new InetSocketAddress(InetAddress.getLocalHost(), 11111));
//            packet.setSocketAddress(new InetSocketAddress(41111));
            socket.send(packet);
        }
    }

    private static DatagramPacket encodePacket(String text, InetSocketAddress remoteAddress) {
        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        return new DatagramPacket(bytes, bytes.length, remoteAddress);
    }
}
