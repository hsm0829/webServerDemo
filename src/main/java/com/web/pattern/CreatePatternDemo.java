package com.web.pattern;

/**
 * 构建者模式
 */
public class CreatePatternDemo {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private CreatePatternDemo(Builder builder) {

        this.id = builder.id;
        this.name = builder.name;
    }

    private static class Builder{

        private String id;
        private String name;

        public Builder setId(String id){
            this.id=id;
            return this;
        }
        public Builder setName(String name){
            this.name=name;
            return this;
        }
        public CreatePatternDemo build(){
            return new CreatePatternDemo(this);
        }
    }

    public static void main(String[] args) {

        CreatePatternDemo createPatternDemo = new Builder().setId("1").setName("XXX").build();
        System.out.println(createPatternDemo.id);

    }
}
