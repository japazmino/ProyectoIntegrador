package Comunicacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Comunicacion extends Thread {

    private static final Comunicacion miClase = new Comunicacion();

    private int puerto;
    private InetAddress ip;
    private DatagramSocket socket;
    private Boolean ingresar;

    private Comunicacion() {
        ingresar = false;

        puerto = 5100;

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }


        try {
            //ip = InetAddress.getByName("10.0.2.2");
            ip = InetAddress.getByName("172.30.160.30");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static Comunicacion getInstance() {
        return miClase;
    }

    public void run(){
        while (true){
            try {
                recibir();
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void recibir(){
        byte[] buzon = new byte[1024];
        DatagramPacket pack = new DatagramPacket(buzon, buzon.length);
        try {
            socket.receive(pack);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void enviar(Object msj){
        byte[] datos = objectByte(msj);
        DatagramPacket enviar = new DatagramPacket(datos, datos.length, ip, puerto);
        try {
            socket.send(enviar);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Mensaje byteObjeto(byte[] bytes) {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes);
        Mensaje aux = null;
        try {
            ObjectInputStream is = new ObjectInputStream(byteArray);
            aux = (Mensaje) is.readObject();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return aux;
    }

    public byte[] objectByte(Object param){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            ObjectOutputStream os = new ObjectOutputStream(bytes);
            os.writeObject(param);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes.toByteArray();
    }

    public Boolean getIngresar() {
        return ingresar;
    }
}
