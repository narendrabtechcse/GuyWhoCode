package Java.java7less.externalisable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee implements Externalizable {

    private String name;
    private Integer age;
    private double weight;

    public Employee()
    {

    }

    public Employee(String name, Integer age, double weight)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeUTF(name);
        out.writeObject(age);
        out.writeDouble(weight);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = in.readUTF();
        age = (Integer) in.readObject();
        weight = in.readDouble();
    }

    public String toString()
    {
        return "name = "+name + ", age = "+age + ", weight "+weight;
    }
}
