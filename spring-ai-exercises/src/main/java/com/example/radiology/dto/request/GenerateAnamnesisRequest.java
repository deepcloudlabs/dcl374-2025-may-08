package com.example.radiology.dto.request;

import com.example.radiology.domain.AbnormalityType;
import com.example.radiology.domain.MedicalImagingType;

public record GenerateAnamnesisRequest(MedicalImagingType medicalImagingType,AbnormalityType abnormalityType) {

}
