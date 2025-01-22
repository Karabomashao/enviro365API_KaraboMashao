package com.enviro.assessment.grad001.KaraboMashao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "waste_types")
public class WasteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wasteId;

    private String typeOfWaste;
    private String wasteExample;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "wasteType", cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelineList;

    public WasteType(String typeOfWaste, String wasteExample){
        this.typeOfWaste = typeOfWaste;
        this.wasteExample = wasteExample;
    }

    public WasteType(){}

    public int getWasteId() {
        return wasteId;
    }

    public String getTypeOfWaste() {
        return typeOfWaste;
    }

    public String getWasteExample() {
        return wasteExample;
    }

    public Category getCategory() {
        return category;
    }

    public void setTypeOfWaste(String typeOfWaste) {
        this.typeOfWaste = typeOfWaste;
    }

    public void setWasteExample(String wasteExample) {
        this.wasteExample = wasteExample;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
