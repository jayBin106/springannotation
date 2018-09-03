package json;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import serializable.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2018/9/3.
 */
public class JsonDemo {
    public static void main(String[] args) throws IOException {
        excuteWithJack();
        excuteFastJson();
        excuteProtoBuf();
        excuteHession();
    }

    public static Person init() {
        return new Person("小明", 12);
    }

    @Test
    public static void excuteWithJack() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person init = init();
        byte[] bytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            bytes = objectMapper.writeValueAsBytes(init);
        }
        long end = System.currentTimeMillis();
        Person person = objectMapper.readValue(bytes, Person.class);
        System.out.println("时间差：" + (end - start) + "----Person:" + person);
    }

    /*alibaba  FastJson*/
    @Test
    public static void excuteFastJson() throws IOException {
        Person init = init();
        String bytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            bytes = JSON.toJSONString(init);
        }
        long end = System.currentTimeMillis();
        Person person = JSON.parseObject(bytes, Person.class);
        System.out.println("时间差：" + (end - start) + "----Person:" + person+ "---------字节数：" + bytes.length());
    }

    @Test
    public static void excuteProtoBuf() throws IOException {
        Person init = init();
        Codec<Person> personCodec = ProtobufProxy.create(Person.class, false);
        byte[] bytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            bytes = personCodec.encode(init);
        }
        long end = System.currentTimeMillis();
        Person person = personCodec.decode(bytes);
        System.out.println("时间差：" + (end - start) + "----Person:" + person + "---------字节数：" + bytes.length);
    }


    @Test
    public static void excuteHession() throws IOException {
        Person init = init();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(os);
        byte[] bytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hessianOutput.writeObject(init);
            if (i == 0) {
                System.out.println(os.toByteArray().length);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总大小------" + os.toByteArray().length);
        HessianInput hessianInput = new HessianInput(new ByteArrayInputStream(os.toByteArray()));
        Person person = (Person) hessianInput.readObject();
        System.out.println("时间差：" + (end - start) + "----Person:" + person);
    }
}
