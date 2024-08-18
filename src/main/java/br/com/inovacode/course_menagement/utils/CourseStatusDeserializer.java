package br.com.inovacode.course_menagement.utils;

import br.com.inovacode.course_menagement.CourseStatusEnum.CourseStatus;
import br.com.inovacode.course_menagement.exceptions.InvalidCourseStatusException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CourseStatusDeserializer extends JsonDeserializer<CourseStatus> {
    @Override
    public CourseStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        String value = jsonParser.getValueAsString().toUpperCase();

        if (value.isEmpty()) {
            throw new InvalidCourseStatusException("The field 'active' is mandatory and cannot be empty.", "active");
        }

        try {
            return CourseStatus.valueOf(value);
        } catch ( IllegalArgumentException e) {
            throw new InvalidCourseStatusException("The field only accepts: ACTIVE, active, INACTIVE, inactive", "active");
        }
    }
}
