package org.moshun.onlinebookstore.dto.bookdto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateBookRequestDto {
    @NotNull(message = "Title cannot be null.")
    private String title;

    @NotNull(message = "Author cannot be null.")
    private String author;

    @NotNull(message = "isbn cannot be null.")
    @Size (min = 1, max = 13, message = "ISBN must be between 1 and 13 characters.")
    private String isbn;

    @Positive(message = "Price must be more than 0")
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;

    @Max(100)
    private String description;
    private String coverImage;
}
