package bongo.employee;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum Role {
    EMPLOYEE,
    MANAGER,
    HR,
    ADMIN,
    BOSSMAN
}
