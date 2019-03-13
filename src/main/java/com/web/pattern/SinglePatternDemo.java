package com.web.pattern;

/**
 * 单例模式
 */
public class SinglePatternDemo {

    /**
     * 饿汉式：构造方法实例化，外部无法产生新的实例，只能通过static方法获取实例对象
     */
    static class SingleA{

        /**
         * 内部私有实现实例化对象
         */
        private static SingleA singleA=new SingleA();

        /**
         * 构造方法私有化，不允许外部类通过构造方法实例化对象
         */
        private SingleA() {

        }

        /**
         * 获取实例对象
         * @return
         */
        public static SingleA getInstance(){
            return singleA;
        }


    }

    /**
     * 懒汉式：当第一次使用这个对象的时候，去实例化这个对象
     */
    static class SingleB{
        private static SingleB singleB=null;
        /**
         * 构造方法私有化，不允许外部类通过构造方法实例化对象
         */
        private SingleB() {
        }

        /**
         *
         * @return
         */
        public synchronized static SingleB getInstance(){
            if(singleB==null){
                singleB=new SingleB();
            }
            return singleB;
        }
    }

    public static void main(String[] args) {
        System.out.println("SingleA : "+SingleA.getInstance());
        System.out.println("SingleB : "+SingleB.getInstance());
    }

}
