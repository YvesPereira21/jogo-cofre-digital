package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        try(Socket cliente = new Socket("localhost", 2004);
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            ){
            escritor.println(nome);
            System.out.println(leitor.readLine());

            while(true) {
                System.out.println("Chute um número: ");
                int numero = sc.nextInt();

                if(numero == -1) {
                    escritor.println("sair");
                    break;
                }

                escritor.println(numero);
                System.out.println(leitor.readLine());
            }
        }

        catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}
