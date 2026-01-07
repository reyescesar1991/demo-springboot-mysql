package com.example.demo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
//Individual
//@PropertySource("classpath:custom.properties") 
@PropertySources({
    @PropertySource("classpath:custom.properties"),
    @PropertySource("classpath:custom-file-2.properties")
})
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${custom.properties}")
    private String customProperties; 

    @Value("${my.prop.2}")
    private String customProperties2; 

    @Value("${custom.properties-int}")
    private Integer customPropertyInt;

    @Value("${my.custom.env.property}")
    private String customEnvProperty;

    public MyFirstService(
       @Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    // @Autowired
    // public void setMyFirstClass(
    //     @Qualifier("bean1") MyFirstClass myFirstClass
    // ){

    //     this.myFirstClass = myFirstClass;

    // }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }

    // public String getJavaVersion(){
    //     return env.getProperty("java.version");
    // }

    // public String getOsName(){
    //     return env.getProperty("os.name");
    // }

    // public String getOsVersion(){
    //     return env.getProperty("osversion");
    // }

    // public String readProps(){
    //     return env.getProperty("my.custom.property");
    // }

    // @Autowired
    // public void setEnv(Environment env){
    //     this.env = env;
    // }

    // public String readCustomProps(){
    //     return this.customProperties;
    // }

    // public String readCustomProps2(){
    //     return this.customProperties2;
    // }

    // public Integer readCustomPropsInt(){
    //     return this.customPropertyInt;
    // }

    public String readCustomEnvProps(){
        return customEnvProperty;
    }
}
