package br.com.reserves.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
@Schema(name = "Create Reserve", description = "DTO to create a new Reserve")
public class CreateReserveDTO {

    @NotNull(message = "clientId is required")
    @Size(min = 24, max = 24, message = "Invalid clientId")
    @Schema(example = "6509022be1637c6bd76ee57d")
    private String clientId;

    @NotNull(message = "carId is required")
    @Size(min = 24, max = 24, message = "Invalid carId")
    @Schema(example = "650aeb78956ef274d56058be")
    private String carId;

    @NotNull(message = "startDate is required")
    @Schema(example = "2023-09-20T08:00:00")
    private String startDate;
    @NotNull(message = "endDate is required")
    @Schema(example = "2023-09-22T17:30:00")
    private String endDate;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Schema(example = "Confirmed")
    private String status;

}
