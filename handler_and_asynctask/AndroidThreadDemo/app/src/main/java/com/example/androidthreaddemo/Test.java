package com.example.androidthreaddemo;

public class Test {
    // 匿名子类
    MyClass myClass = new MyClass(){
        @Override
        public void hello() {
            super.hello();
        }
    };
}

class MyClass {
    public void hello(){}
}
