/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bhinneka.cahayu.shared;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 *
 * @author wurianto
 */
public class ObjectIdSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jsonGen, SerializerProvider provider) throws IOException {
        jsonGen.writeString(value.toString());
    }
}
