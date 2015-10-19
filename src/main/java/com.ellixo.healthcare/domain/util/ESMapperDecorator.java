package com.ellixo.healthcare.domain.util;

import com.ellixo.healthcare.domain.*;
import com.ellixo.healthcare.domain.csv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ESMapperDecorator implements ESMapper {

    public static final String PREFIX_AUTORISATION = "Autorisation ";

    @Autowired
    @Qualifier("delegate")
    private ESMapper delegate;

    public Medicament toMedicamentES(MedicamentCSV csv) {
        Medicament medicament = delegate.toMedicamentES(csv);
        // statut
        String statut = csv.getStatutAdministratifAMM();
        if (statut.startsWith(PREFIX_AUTORISATION)) {
            statut = statut.substring(PREFIX_AUTORISATION.length());
        }
        medicament.setStatutAdministratifAMM(statut);
        // etat
        String etat = csv.getEtatCommercialisation();
        medicament.setEtatCommercialisation(etat != null && etat.equals("Commercialisée"));
        return medicament;
    }

    @Override
    public List<Medicament> toMedicamentES(List<MedicamentCSV> csv) {
        if (csv == null) {
            return null;
        }

        List<Medicament> list = new ArrayList<>();
        for (MedicamentCSV medicamentCSV : csv) {
            list.add(toMedicamentES(medicamentCSV));
        }
        return list;
    }

    @Override
    public Presentation toPresentationES(PresentationCSV csv) {
        return delegate.toPresentationES(csv);
    }

    @Override
    public SubstanceActive toSubstanceActiveES(CompositionCSV csv) {
        return delegate.toSubstanceActiveES(csv);
    }

    @Override
    public FractionTherapeutique toFractionTherapeutiqueES(CompositionCSV csv) {
        return delegate.toFractionTherapeutiqueES(csv);
    }

    @Override
    public AvisSMR toAvisSMRES(AvisSMRCSV csv) {
        return delegate.toAvisSMRES(csv);
    }

    @Override
    public AvisASMR toAvisASMRES(AvisASMRCSV csv) {
        return delegate.toAvisASMRES(csv);
    }
}
