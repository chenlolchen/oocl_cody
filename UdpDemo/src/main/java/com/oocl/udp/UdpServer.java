package com.oocl.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * Created by CHENCO7 on 7/12/2017.
 */
public class UdpServer {
    public static void main(String[] args) throws Exception{
//      echo "abc">/dev/udp/127.0.0.1/8002 for test
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
        DatagramSocket socket = new DatagramSocket(8002);
        socket.receive(packet);
//        int len = packet.getLength();
//        byte[] data = packet.getData();
//        for(int i = 0; i < len; i++){
//            System.out.println(data[i]);
//        }
        String s = new String(packet.getData(),0,packet.getLength());
        System.out.println(s);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        DatagramPacket p = new DatagramPacket("ack".getBytes(),0,3,address,port);
        socket.send(p);

        socket.close();
    }
}
