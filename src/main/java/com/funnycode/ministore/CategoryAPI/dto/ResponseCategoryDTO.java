package com.funnycode.ministore.CategoryAPI.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseCategoryDTO {
    int id;
    String categoryName;
}
