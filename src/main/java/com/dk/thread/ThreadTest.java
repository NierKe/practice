package com.dk.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ThreadTest extends Thread{
    private String url;
    private String name;
    public ThreadTest(String url,String name ){
        this.name = name;
        this.url = url;
    }
    @Override
    public void run(){
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downLoder(url,name);
        System.out.println("下载了文件名为："+name);
    }


    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest("https://i0.hdslb.com/bfs/sycp/creative_img/202301/4bbc084a60697aaa2cba5a5f7727cd9b.jpg@672w_378h_1c_!web-home-common-cover","1.jpg");
        ThreadTest threadTest2 = new ThreadTest("https://i0.hdslb.com/bfs/sycp/creative_img/202308/0487d646941ff6fa9c127c14af074766.jpg@976w_550h_1c_!web-home-carousel-cover","2.jpg");
        ThreadTest threadTest3= new ThreadTest("https://i0.hdslb.com/bfs/banner/65072b9775ee8b048e2a434ef694b282fbdafb63.jpg@976w_550h_1c_!web-home-carousel-cover","3.jpg");
        threadTest.start();
        threadTest2.start();
        threadTest3.start();
    }
}
class WebDownLoader{
    public void downLoder(String url,String name)  {
        try{
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("IO异常，downloder方法出现问题！");
        }
        }

}