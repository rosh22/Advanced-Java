/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatapp;



import java.net.*;

 

class Server {
  public static int serverPort = 998;
  public static int clientPort = 999;
  public static int buffer_size = 1024;
  public static DatagramSocket ds;
  public static byte buffer[] = new byte[buffer_size];

 

  public static void TheServer() throws Exception {
    int pos=0;
    while (true) {
      int c = System.in.read();
      switch (c) {
              case '\r':
                break;
              case '\n':
                ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(),clientPort));
                pos=0;
                break;
              default:
                buffer[pos++] = (byte) c;
            }
          }
  }
  public static void TheClient() throws Exception {
          while(true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            //System.out.println("TEST");
            ds.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
          }
        }

 

        public static void main(String args[]) throws Exception {
          if(args.length == 1) {
            ds = new DatagramSocket(serverPort);
            TheServer();
          } else {
            ds = new DatagramSocket(clientPort);
            TheClient();
          }
        }
}

 