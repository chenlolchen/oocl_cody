package com.oocl.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket("abc".getBytes(),0,3, address, 8002);
        socket.send(packet);

        DatagramPacket p1 = new DatagramPacket(new byte[3],3);
        socket.receive(p1);
        String s = new String(p1.getData(),0,p1.getLength());
        System.out.println(s);

        socket.close();
    }
}
