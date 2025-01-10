package com.workify.workify_ag.Specification;

import org.springframework.data.jpa.domain.Specification;
import com.workify.workify_ag.Entities.Offre;

public class OffreSpecification {

    public static Specification<Offre> hasTitre(String titre) {
        return (root, query, criteriaBuilder) ->
                titre == null ? null : criteriaBuilder.equal(root.get("titre"), titre);
    }

    public static Specification<Offre> hasVille(String ville) {
        return (root, query, criteriaBuilder) ->
                ville == null ? null : criteriaBuilder.equal(root.get("ville"), ville);
    }

    public static Specification<Offre> hasDomaine(String domaine) {
        return (root, query, criteriaBuilder) ->
                domaine == null ? null : criteriaBuilder.equal(root.get("domaine"), domaine);
    }

    public static Specification<Offre> hasNiveauEtude(String niveauEtude) {
        return (root, query, criteriaBuilder) ->
                niveauEtude == null ? null : criteriaBuilder.equal(root.get("niveauEtude"), niveauEtude);
    }
}
