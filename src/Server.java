import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
public static void main(String []  args) throws IOException{
	//1���������
	DatagramSocket server = new DatagramSocket(10006);
	//2׼���������� �ֽ����� ��װDatagramPacket
	byte [] flush = new byte[1024];
	DatagramPacket dpc = new DatagramPacket(flush,flush.length);
	//�� ��������
	server.receive(dpc);
	//4).����
	float f1;
	byte [] data = dpc.getData();
	f1 =ByteToType(data);
	System.out.println(f1);
	//5).�ͷ���Դ
	server.close();
}
public static Float ByteToType(byte [] Be) throws IOException{
	//ԴBe
	//ѡ����
	DataInputStream dis = new DataInputStream(new ByteArrayInputStream(Be));
	//��ʱ�������ַ�
	float f1;
	f1 = dis.readFloat();
	dis.close();
	return f1;
}
}
/*   				�������ܽ�
 * ����˳�����
 *     1���������
 *     2׼���������� �ֽ����� ��װDatagramPacket
 *     3�� ��������
 *     4����
 *     5�ͷ���Դ
 *     
 * 
 * �ӳ����������Ǵ������͵��ֽ����飬Ҫת��Ϊ��ص�����
 * 1.������Ҫ���ǰ��ֽ�����ת��������������Ҫ,dis =DataInputStream
 * 2.�Ȱ��ֽ�����ת��Ϊһ��Դ����Ҫʹ�ýڵ���,bas =ByteArrayInputStream(byte [])
 * 3.dis.readFloat()��ȡת��
 * 
 * 
 */
