package com.bastronaut.traderboard.traderboard.models.inout

import com.fasterxml.jackson.annotation.JsonRootName
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Seems that we can make classes and pass them as arguments in the controller.
 * Request will be automatically mapped to the object.
 * Annotations will be passed to caller when using the @Valid annotation in the controller
 */
@JsonRootName("user")
class RegisterUser {
    @NotNull(message="Field \"username\" is required")
    @Size(min = 1, message="Field \"username\" may not be empty")
    var username: String? = ""
    @NotNull(message= "Field \"password\" is required")
    @Size(min = 1, message="Field \"password\" may not be empty")
    var password: String? = ""
    @NotNull(message="Field \"email\" is required")
    @Size(min = 1, message="Field \"email\" may not be empty")
    var email: String? = ""
}