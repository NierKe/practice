package com.dk.demo1.util;

public class Test {



    public static int test2(){
        int i = 999;
        try {
            System.out.println("try block");

            i = 1 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("catch block");

            i = 100;
            return i;
        } finally {
            System.out.println("finally block");

            i = 200;

        }
    }

    static int num = 100;
        static int tt(){
            try {
                int num = 1 / 0;
                return num;
            }
            catch (Exception e){
                return num ;
            }
            finally {
                return num + 100;
            }
        }
    private static String test(){
        String s ;
        try{
          s ="返回来try";
            return s;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("执行了finally");
            s = "返回finaolly";
        }
        return "未执行";
    }


    public static void main(String[] args) {
//        String s1 = "123";
//        //String s2 = new String("123");
//        System.out.println("改变之前："+s1);
//        changeStr(s1);
//        System.out.println("改变之后："+s1);


        System.out.println(test2());

    }



    public static void changeStr(String str){
        str = str + "123";
        System.out.println("改变中："+str);
    }
}
