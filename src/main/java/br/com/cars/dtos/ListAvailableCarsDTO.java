package br.com.cars.dtos;

import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "List Available Cars", description = "Route to get all available cars between 2 Dates")
public class ListAvailableCarsDTO {

    @NotNull(message = "initialDate is required")
    @Schema(example = "2023-09-20T10:00:00")
    private String initialDate;
    @NotNull(message = "finalDate is required")
    @Schema(example = "2023-09-22T10:00:00")
    private String finalDate;

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }
}
