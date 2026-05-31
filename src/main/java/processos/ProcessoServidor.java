package processos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ProcessoServidor extends Thread{

    private Socket socket;
    private Cofre cofre;
    private Integer numeroAleatorio;

    public ProcessoServidor(Socket socket, Cofre cofre){
        this.socket = socket;
        this.cofre = cofre;
        this.numeroAleatorio = new Random().nextInt(2);
    }

    @Override
    public void run() {
        cofre.adicionaFundo();

        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        ){
            String nomeUsuario = leitor.readLine();

            escritor.println("Bem-vindo, " + nomeUsuario);

            while (true){
                String mensagem = leitor.readLine();

                if(mensagem.equalsIgnoreCase("sair")){
                    break;
                } else if (mensagem.equalsIgnoreCase(numeroAleatorio.toString())) {
                    cofre.paga();
                    escritor.println("Cofre aberto, " + nomeUsuario + "! Você ganhou R$" + cofre.retornaFundo());
                    cofre.zeraFundo();
                } else {
                    escritor.println("Código errado, " + nomeUsuario + ". O cofre tem R$" + cofre.retornaFundo() + " acumulados");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro de conexão com o cliente: " + e.getMessage());
        }
    }

}