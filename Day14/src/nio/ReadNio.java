package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadNio
{
    public static void main(String args[]) throws IOException
    {
        @SuppressWarnings("resource")
		RandomAccessFile file = new RandomAccessFile("D:\\name.txt","r");
        FileChannel channel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int r ;
        while((r = channel.read(buf))!= -1)
        {
            buf.flip();
            while(buf.hasRemaining())
            {
                System.out.print((char)buf.get());
            }
            buf.clear();


        }
    }
}
