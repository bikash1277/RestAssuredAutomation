package org.example.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerializationDeSerializationTest {

    String courseArr[] = {"C++", "Rest"};

    @Test
    public void convertPOJO2Json() throws JsonProcessingException {

        //Create JSON Object class using POJO class
        Student student = new Student();
        student.setName("Tiger");
        student.setLocation("France");
        student.setPhone("789789789");
        student.setCourse(courseArr);
        //convert java object --->json object (Serialization)
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(data);

    }

    @Test
    public void convertJson2POJO() throws JsonProcessingException {

        //Create JSON Object class using POJO class
        String data = "{\n" +
                "  \"name\" : \"Tiger\",\n" +
                "  \"phone\" : \"789789789\",\n" +
                "  \"location\" : \"France\",\n" +
                "  \"course\" : [ \"C++\", \"Rest\" ]\n" +
                "}";
        //convert json data --->pojo object (Deserialization)
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(data, Student.class);
        System.out.println(student.getName());
        System.out.println(student.getLocation());

    }


}
