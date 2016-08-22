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
 * 	1).�����ͻ��� DatagramSocket ��+���Ͷ˿�
	2).׼������ �ֽ�����
	3).��� DatagramPacket+��������ַ���˿�
	4).����
	5).�ͷ���Դ
 */
	public static void  main(String [] arg) throws IOException{
		//�����ͻ��� DatagramSocket ��+���Ͷ˿�
		DatagramSocket client = new DatagramSocket(7778);
		//׼������ �ֽ�����
		float f1=(float)89.9;
		byte [] data =TypeToByte(f1);
		//��� DatagramPacket+��������ַ���˿�
		DatagramPacket dpc = new DatagramPacket(data,data.length,new InetSocketAddress("127.0.0.1",10006));
		//����
		client.send(dpc);
		//�ͷ���Դ
		client.close();
	}
	public static byte[] TypeToByte(float f1) throws IOException{
		//Դ
		//��
		ByteArrayOutputStream bio = new ByteArrayOutputStream();
		DataOutputStream dis = new DataOutputStream(bio);
		//��ʱ�ֽ�����
		byte [] by = new byte[1024];
		dis.writeFloat(f1);
		dis.flush();
		by= bio.toByteArray();
		return by;
	}
	
}
/*  				�������ܽ�
 * 	�ͻ��˷��͵Ļ�������:
 * 1.�����ͻ�����-------��ע�ⷢ�Ͷ˿�
 * 2.׼������----���ֽ�����
 * 3.�������-----������ ���ݳ��� ��������ַ �������˿�+����
 * 4.�ر�
 * 
 * 
 * ����ת������
 * 	1.������ת��Ϊ�������͵��ֽ����� 
 *    1)ת��Ϊһ�����ӵ���Դ����һ�����ӵ��ǳ�������������Ҫ��������ת��Ϊ�ڵ�Դ
 *    2)�������ڴ��У�����Ҫ���뵽�ڵ�����ͨ��������ʹ��ByteArrayOutputStream()
 *    3)	bao =ByteArrayOutputStream(Float f1)
 *    4)����	dos =DataOutputStream(bao)һ������Դ��һ�����ӳ���	
 *    5)	dos.writeFloat();дͨ��
 *    6)	dos.toByteArray()��ͨ�������ȡ
 * 
 * 
 */
