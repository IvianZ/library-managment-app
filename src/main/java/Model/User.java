package Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class User {
    @NotNull
    @NotEmpty
    @Positive
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30, message
            = "First name must be between 3 and 30 characters")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30, message
            = "Last name must be between 3 and 30 characters")
    private String lastName;

    @NotNull
    @NotEmpty
    private Instant createDate;

    private Instant updateTime;


}

