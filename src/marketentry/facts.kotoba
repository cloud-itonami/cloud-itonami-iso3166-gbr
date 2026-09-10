(ns marketentry.facts
  "United Kingdom market-entry regulatory catalog (G2-style).")

(def catalog
  {"GBR" {:name "United Kingdom"
          :owner-authority "Crown Commercial Service / Find a Tender"
          :legal-basis "Public Contracts Regulations 2015 (as retained/amended post-Brexit)"
          :national-spec "Find a Tender Service + Contracts Finder supplier registration"
          :provenance "https://www.find-tender.service.gov.uk/"
          :required-evidence ["Companies House record"
                              "Find a Tender registration record"
                              "VAT registration record"
                              "Authorized-representative record"]
          :rep-owner-authority "Companies House / contracting authorities"
          :rep-legal-basis "UK-registered entity or authorized UK representative for many public contracts"
          :rep-provenance "https://www.gov.uk/government/organisations/companies-house"
          :corporate-number-owner-authority "HMRC"
          :corporate-number-legal-basis "VAT registration number"
          :corporate-number-provenance "https://www.gov.uk/vat-registration"}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gbr R0: " (count catalog) " jurisdictions seeded.")})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
