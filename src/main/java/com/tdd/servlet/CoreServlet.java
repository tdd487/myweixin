package com.tdd.servlet;

import com.tdd.util.SignUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/12.
 * 核心处理类
 */
public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID = 4440739483644821986L;

    /**
     * 确认处理来自微信服务器
     * */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //微信加密签名
        String signture = request.getParameter("signture");
        //时间戳
        String timeStamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        //通过检验signature对请求进行校验，若检验成功则原样返回echostr，表示接入成功，否则接入失败
        if(SignUtil.checkSignture(signture,timeStamp,nonce)){
            out.print(echostr);
        }
        out.close();
        out = null;

    }

    /**
     * 处理微信服务器发来的消息
     * */
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
