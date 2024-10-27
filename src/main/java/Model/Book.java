package Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Book {

    @NotNull
    @NotEmpty
    @Positive
    private Integer id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30, message
            = "Title must be between 3 and 30 characters")
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 30, message
            = "Author must be between 3 and 30 characters")
    private String author;

    @NotNull
    @NotEmpty
    private Instant createDate;

    private Instant updateTime;



}


