
import java.net.*;
import java.io.*;
public class UDPClient{
    public static void main(String[] args) {
        // args give message contents and server hostname
        StringBuilder sb = new StringBuilder();
        DatagramSocket aSocket = null;
        String line;
        byte [] m;

        try{

            aSocket = new DatagramSocket();
            InetAddress aHost = InetAddress.getByName( args[1] );
            int serverPort = 6789;

            sb = new StringBuilder();

            if( args[0].equals( "1" ) ) {
                BufferedReader br = new BufferedReader( new FileReader( "input.txt" ) );
                

                while ( ( line = br.readLine() ) != null ) {
                    sb.append( line );
                    sb.append( System.lineSeparator() );
                }
               
            }
            else {
                for ( int i=2; i != args.length; i++ ) {
                    sb.append( args[i] );
                    sb.append( System.lineSeparator() );
                }
            }


            m = sb.toString().getBytes();
            send( aSocket, new DatagramPacket( m, m.length, aHost, serverPort ) );



            byte[] buffer = new byte[ m.length ];
            DatagramPacket reply = new DatagramPacket( buffer, buffer.length );
            aSocket.receive( reply );
            System.out.println( "Reply: " + new String( reply.getData() ) );

        }   catch ( SocketException e ){ System.out.println( "Socket: " + e.getMessage() );
        }   catch ( IOException e ){ System.out.println( "IO: " + e.getMessage() ); }
        finally { if( aSocket != null ) aSocket.close(); }
    }

    static void send( DatagramSocket aSocket, DatagramPacket request ) throws IOException {
        aSocket.send( request );
    }
}
