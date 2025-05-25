package com.example.radiology.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum AbnormalityType {
	Pneumonia, Tuberculosis, Bronchitis, Bronchiectasis, Lung_Abscess, COVID19_Induced_Pneumonia, Fungal_Infection,
	Sarcoidosis, Hypersensitivity_Pneumonitis, Emphysema, Asthma, Pulmonary_Fibrosis, Interstitial_Lung_Disease,
	Pneumoconiosis, Primary_Lung_Cancer, Metastatic_Lung_Cancer, Harmatoma, Mediastinal_Masses,
	Solitary_Pulmonary_Nodule, Cardiomegaly, Pericardial_Effusion, Congestive_Heart_Failure;
	public static List<AbnormalityType> asStream = Arrays.stream(AbnormalityType.values()).sorted(Comparator.comparing(AbnormalityType::name)).toList();

}
