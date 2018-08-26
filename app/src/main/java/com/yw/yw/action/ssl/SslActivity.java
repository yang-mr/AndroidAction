package com.yw.yw.action.ssl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yw.yw.action.R;

/**
 Desc
 1)客户对服务器的身份认证:
 SSL服务器允许客户的浏览器使用标准的公钥加密技术和一些可靠的认证中心（CA）的证书，来确认服务器的合法性。

 2)服务器对客户的身份认证:
 也可通过公钥技术和证书进行认证，也可通过用户名，password来认证。

 3)建立服务器与客户之间安全的数据通道:
 SSL要求客户与服务器之间的所有发送的数据都被发送端加密、接收端解密，同时还检查数据的完整性。
 >SSL协议位于TCP/IP协议与各种应用层协议之间，为数据通讯提供安全支持。SSL协议可分为两层：
    SSL记录协议（SSL Record Protocol）：
        它建立在可靠的传输协议（如TCP）之上，为高层协议提供数据封装、压缩、加密等基本功能的支持
    SSL握手协议（SSL Handshake Protocol）：
        它建立在SSL记录协议之上，用于在实际的数据传输开始前，通讯双方进行身份认证、协商加密算法、交换加密密钥等

 客户端需要用到的file:
    client.p12(客户端证书，用于请求的时候给服务器来验证身份之用)
    client.truststore(客户端证书库，用于验证服务器端身份，防止钓鱼)

 证书中心
    ref:http://www.ruanyifeng.com/blog/2011/08/what_is_a_digital_signature.html
    用自己的私钥，对鲍勃的公钥和一些相关信息一起加密，生成"数字证书"（Digital Certificate）。

 18-2-9:下午3:37
 Author jack
*/
public class SslActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssl);
    }
}
