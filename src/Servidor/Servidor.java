package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {
    /*
        Método que conecta o Servidor aos Clientes e inicializa os sockets para a comunicação

        @param   args          Argumentos passados aquando da inicialização
        @throws  IOException   Exceção lançada caso algo inesperado aconteça
     */
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(12345);
        //Map<String,Utilizador> utilizadores = new HashMap<>();

        while(true){
            Socket cs = ss.accept();
            System.out.println("Conexão estabelecida");
            Thread worker = new Thread(new GereMensagem(cs));
            worker.start();
        }
    }
}
