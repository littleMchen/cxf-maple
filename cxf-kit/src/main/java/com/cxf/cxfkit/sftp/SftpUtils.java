package com.cxf.cxfkit.sftp;

import com.jcraft.jsch.*;

import java.io.File;

/**
 * @description: SftpUtils
 * @date: 2022/7/25 23:06
 * @author: cxf
 * @version: 1.0
 */
public class SftpUtils {

    private static String remoteHost = "106.13.224.166";
    private static String username = "root";
    private static String password = "cxf!QAZ2wsx";

    private static Session openSession() throws JSchException {
        JSch jsch = new JSch();
        Session jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);
        jschSession.setConfig("StrictHostKeyChecking","no");
        jschSession.connect();
        return jschSession;
    }

    public static void upload(String localPath,String remotePath) throws JSchException, SftpException {
        Session jschSession = openSession();
        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
        channelSftp.connect();

        mkdirs(channelSftp,remotePath);
        channelSftp.put(localPath, remotePath);

        channelSftp.exit();
        jschSession.disconnect();
    }

    public static void download(String localPath,String remotePath) throws JSchException, SftpException {
        Session jschSession = openSession();
        ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
        channelSftp.connect();

        if(!new File(localPath).exists()){
            new File(localPath).mkdirs();
        }
        channelSftp.get(remotePath, localPath);

        channelSftp.exit();
        jschSession.disconnect();
    }

    public static void mkdirs(ChannelSftp channelSftp,String remotePath){
        String[] strings = remotePath.split("/");
        String current = "";
        for (int i = 0; i < strings.length; i++) {
            if( i == 0){
                current = "/";
            }else {
                current = current +strings[i] + "/";
            }
            try {
                channelSftp.cd(current);
            }catch (SftpException s){
                try {
                    channelSftp.mkdir(current);
                } catch (SftpException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws JSchException, SftpException {

        SftpUtils.upload("D:\\temp\\pdf\\demo.pdf","/root/20220727");

        SftpUtils.download("D:\\temp\\20220727","/root/20220727/demo.pdf");

    }


}
