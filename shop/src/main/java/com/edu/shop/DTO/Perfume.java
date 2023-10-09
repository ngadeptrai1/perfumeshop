package com.edu.shop.DTO;

import lombok.Data;

import java.util.List;

@Data
public class Perfume {

    private Long id;

    private List<CartDetail> cartDetails;

    private List<ImagePerfume> imagePerfumes;

    private PerfumePrice perfumePrice;

    private Long brandID;

    private String genderID;

    private Long originID;
}
