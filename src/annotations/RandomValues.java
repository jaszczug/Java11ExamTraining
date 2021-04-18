package annotations;

import java.time.LocalDate;

enum Val {V1,V2,V3,V4,V5,V6};

@interface RandomValues {
    LocalDate lastUpdated = LocalDate.of(2020, 11, 13);
    public abstract Val[] choices() default {Val.V1, Val.V2};
}