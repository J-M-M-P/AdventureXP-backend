package dat3.AXP.service;

import dat3.AXP.dto.EquipmentDto;
import dat3.AXP.entity.Equipment;
import dat3.AXP.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    //Get all equipment
    public List<EquipmentDto> getAllEquipment() {
        List<Equipment> equipmentList = equipmentRepository.findAll();
        List<EquipmentDto> equipmentDtoList = new ArrayList<>();

        for (Equipment equipment : equipmentList) {
            equipmentDtoList.add(new EquipmentDto(equipment));
        }

        return equipmentDtoList;
    }

    //Get equipment by id
    public EquipmentDto getEquipmentById(int id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "equipment not found"));
        return new EquipmentDto(equipment);
    }


    //Create equipment
    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    //Delete equipment
    public void deleteEquipment(int equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }

    //Update equipment
    public Equipment updateEquipment(int equipmentId, Equipment updatedEquipment) {
        // Kontroller, om udstyret med den angivne id eksisterer i databasen
        Optional<Equipment> existingEquipmentOptional = equipmentRepository.findById(equipmentId);

        if (existingEquipmentOptional.isPresent()) {
            // Hvis udstyret findes, opdateres de relevante felter med oplysninger fra det opdaterede udstyrsobjekt
            Equipment existingEquipment = existingEquipmentOptional.get();
            existingEquipment.setName(updatedEquipment.getName());
            existingEquipment.setStatus(updatedEquipment.isStatus());
            existingEquipment.setTotalUnits(updatedEquipment.getTotalUnits());
            existingEquipment.setDefectiveUnits(updatedEquipment.getDefectiveUnits());
            existingEquipment.setActivity(updatedEquipment.getActivity());

            // Gem opdateret udstyr i databasen
            return equipmentRepository.save(existingEquipment);
        } else {
            // Hvis udstyret ikke findes, kan du vælge at kaste en fejl eller håndtere det på anden passende måde
            throw new RuntimeException("Equipment with ID: " + equipmentId + " not found");
        }
    }


}
