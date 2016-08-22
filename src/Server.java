import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
public static void main(String []  args) throws IOException{
	//1创建服务端
	DatagramSocket server = new DatagramSocket(10006);
	//2准备接受容器 字节数组 封装DatagramPacket
	byte [] flush = new byte[1024];
	DatagramPacket dpc = new DatagramPacket(flush,flush.length);
	//包 接受数据
	server.receive(dpc);
	//4).分析
	float f1;
	byte [] data = dpc.getData();
	f1 =ByteToType(data);
	System.out.println(f1);
	//5).释放资源
	server.close();
}
public static Float ByteToType(byte [] Be) throws IOException{
	//源Be
	//选择流
	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(Be));
	//临时单精度字符
	float f1;
	f1 = dis.readFloat();
	dis.close();
	return f1;
}
}
/*   				分析与总结
 * 服务端程序步骤
 *     1创建服务端
 *     2准备接受容器 字节数组 封装DatagramPacket
 *     3包 接受数据
 *     4分析
 *     5释放资源
 *     
 * 
 * 从程序里面存的是带有类型的字节数组，要转化为相关的类型
 * 1.我们需要的是把字节数组转化到程序中所以要,dis =DataInputStream
 * 2.先把字节数组转化为一个源所以要使用节点流,bas =ByteArrayInputStream(byte [])
 * 3.dis.readFloat()读取转化
 * 
 * 
 */
