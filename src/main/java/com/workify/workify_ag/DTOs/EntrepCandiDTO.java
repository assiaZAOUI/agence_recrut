package com.workify.workify_ag.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EntrepCandiDTO {
    private String type;
    private String fullname;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Format de date
    private Date datedebut;
}
