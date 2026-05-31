package sockets;

import processos.Cofre;
import processos.ProcessoServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private final static int PORTA = 2004;

    public static void main(String[] args) {
        try(ServerSocket servidor = new ServerSocket(PORTA);
        ){
            Cofre fundo = new Cofre();

            while(true) {
                Socket cliente = servidor.accept();

                ProcessoServidor threadCliente = new ProcessoServidor(cliente, fundo);
                threadCliente.start();
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
