import java.io.*;
import java.util.Random;

public class Generator {
    public static void main(String[] args) throws IOException {
        
        Random radom = new Random();
        StringBuilder line = new StringBuilder();
        int seq = args.length;

        try ( Writer writer = new BufferedWriter( 
            new OutputStreamWriter( new FileOutputStream( "input.txt" ) ) ) ) {
         
            for( int j=0; j != seq; j++ ) {

                for ( int size = Integer.parseInt( args[j] ), i = 1; i != size; i++ ) {

                    line.append( radom.nextInt( i ) );

                }

                line.append( System.lineSeparator() );
                
        
            }
            writer.write( line.toString() );
            writer.close();

        }
    }
}

