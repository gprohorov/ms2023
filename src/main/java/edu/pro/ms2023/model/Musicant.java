package edu.pro.ms2023.model;
/*
  @author   george
  @project   ms2023
  @class  Orchestra
  @version  1.0.0 
  @since 11.09.23 - 11.48
*/

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Schema(name = "Musician", description = "Something ")
public class Musicant {
    @Id
    @Schema(name = "ай-ді",
            description = " mongoDb ідентифікатор",
            example = "45ca551fb8ad658e5ca5d01",
            accessMode = Schema.AccessMode.READ_ONLY)
    String id;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Musicant(String name,
                    String description,
                    LocalDateTime createdAt,
                    LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Musicant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Musicant(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicant orchestra = (Musicant) o;
        return Objects.equals(getId(), orchestra.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
