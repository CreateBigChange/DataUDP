import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class client {
/* 
 * 	1).创建客户端 DatagramSocket 类+发送端口
	2).准备数据 字节数组
	3).打包 DatagramPacket+服务器地址及端口
	4).发送
	5).释放资源
 */
	public static void  main(String [] arg) throws IOException{
		//创建客户端 DatagramSocket 类+发送端口
		DatagramSocket client = new DatagramSocket(7778);
		//准备数据 字节数组
		float f1=(float)89.9;
		byte [] data =TypeToByte(f1);
		//打包 DatagramPacket+服务器地址及端口
		DatagramPacket dpc = new DatagramPacket(data,data.length,new InetSocketAddress("127.0.0.1",10006));
		//发送
		client.send(dpc);
		//释放资源
		client.close();
	}
	public static byte[] TypeToByte(float f1) throws IOException{
		//源
		//流
		ByteArrayOutputStream bio = new ByteArrayOutputStream();
		DataOutputStream dis = new DataOutputStream(bio);
		//临时字节数组
		byte [] by = new byte[1024];
		dis.writeFloat(f1);
		dis.flush();
		by= bio.toByteArray();
		return by;
	}
	
}
/*  				分析与总结
 * 	客户端发送的基本方法:
 * 1.创建客户端类-------》注意发送端口
 * 2.准备数据----》字节数组
 * 3.打包发送-----》数据 数据长度 服务器地址 服务器端口+发送
 * 4.关闭
 * 
 * 
 * 数据转化分析
 * 	1.从类型转化为保留类型的字节数组 
 *    1)转化为一端链接的是源，另一端链接的是程序。所以我们需要把类型先转化为节点源
 *    2)类型在内存中，把他要输入到节点流的通道中所以使用ByteArrayOutputStream()
 *    3)	bao =ByteArrayOutputStream(Float f1)
 *    4)再用	dos =DataOutputStream(bao)一端连接源另一段链接程序	
 *    5)	dos.writeFloat();写通道
 *    6)	dos.toByteArray()从通道里面读取
 * 
 * 
 */
