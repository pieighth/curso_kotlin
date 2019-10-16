package com.example.jsonparser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.hamcrest.core.IsInstanceOf
import org.json.JSONArray
import org.json.JSONObject
import org.junit.Assert.*
import org.junit.Test

class ParserJsonTest {

    @Test
    fun test_jsonObject() {

        val jsonString = """
           {
                "name": "Pedro",
                "age" : 34,
                "gender" : "Male",
                "is_active" : false
                
           }
        """.trimIndent()

        val jsonObject = JSONObject(jsonString)
        val person = Person(jsonObject)

        print("Name is ${person.name}")

    }

    @Test
    fun test_arrayObject(){
        val jsonString = """
           [
               {
                    "name": "Pedro",
                    "age" : 34,
                    "gender" : "Male",
                    "is_active" : false
                    
               },
               {
                    "name": "Beltrano",
                    "age" : 22,
                    "gender" : "Male",
                    "is_active" : true
                
                },
                {
                    "name": "Joaquina",
                    "age" : 18,
                    "gender" : "Female",
                    "is_active" : true
                
                },
           
           ]
        """.trimIndent()

        var jsonArray = JSONArray(jsonString)
        for (index in 0 until jsonArray.length()){
            println(jsonArray.getJSONObject(index))
        }

    }
    @Test
    fun whenSerializePerson_thenSucess(){
        val mapper = jacksonObjectMapper()
        val person = Person("Joao", 24, "M")
        val valueAsString = mapper.writeValueAsString(person)
        print("Person is ${valueAsString}")
    }

    @Test
    fun whenDeserializePerson_thenSucess(){
        var jsonString = """
            {
                "name": "Beltrano",
                "age" : 22,
                "gender" : "Male",
                "is_active" : true
            }
        """.trimIndent()

        val mapper = jacksonObjectMapper()

        var person = mapper.readValue<Person>(jsonString)
        print(person)
    }

    @Test
    fun test_jsonObject_assert_name(){
        val jsonString = """
           {
                "name": "Pedro",
                "age" : 34,
                "gender" : "Male",
                "is_active" : false
                
           }
        """.trimIndent()

        val jsonObject = JSONObject(jsonString)



        assertEquals(jsonObject.getString("name"), "Pedro")
    }

    @Test
    fun test_isJsonArray(){
        val jsonString = """
           [
               {
                    "name": "Pedro",
                    "age" : 34,
                    "gender" : "Male",
                    "is_active" : false
                    
               },
               {
                    "name": "Beltrano",
                    "age" : 22,
                    "gender" : "Male",
                    "is_active" : true
                
                },
                {
                    "name": "Joaquina",
                    "age" : 18,
                    "gender" : "Female",
                    "is_active" : true
                
                },
           
           ]
        """.trimIndent()

        var jsonArray = JSONArray(jsonString)
        assertThat(jsonArray, IsInstanceOf( JSONArray::class.java))
    }

}