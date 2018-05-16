import java.net.*;
import java.io.*;
public class UDPServer{
    
    public static void main(String args[]){
        DatagramSocket aSocket = null;
        DatagramPacket request;
        String receive;

        try{

            aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[ 10000 ] ;

            while( true ){

                
                request = new DatagramPacket( buffer, buffer.length );
                aSocket.receive( request );

                DatagramPacket reply = new DatagramPacket(

                    request.getData(),
                    request.getLength(), 
                    request.getAddress(), 
                    request.getPort()

                );

                aSocket.send( reply );


                receive = new String( reply.getData() ).trim();

                if( receive.length() + 2  < request.getLength() ) {
                    System.out.println( "Perca de pacotes" );
                    System.out.println( "Foram perdidos: " + ( ( receive.length() + 2 / request.getLength() ) * 100 ) + "%" );
                }

            }

        }catch ( SocketException e ){ System.out.println( "Socket: " + e.getMessage() );
        }catch ( IOException e ) { System.out.println( "IO: " + e.getMessage() ); }
        finally { if( aSocket != null ) aSocket.close(); }
    
    }

}