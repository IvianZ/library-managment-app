package Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class UserBook {

    @NotNull
    @NotEmpty
    @Positive
    private Integer bookId;

    @NotNull
    @NotEmpty
    @Positive
    private Integer userId;

    @NotNull
    @NotEmpty
    private Instant borrowDate;



}
