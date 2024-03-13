package dat3.AXP.service;

import dat3.AXP.entity.Equipment;
import dat3.AXP.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(int equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }


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