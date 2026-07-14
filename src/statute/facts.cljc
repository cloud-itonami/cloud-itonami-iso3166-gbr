(ns statute.facts
  "General-law compliance catalog for the United Kingdom (GBR) -- extends
  this repo's existing `marketentry.facts` (public-procurement market-entry
  only, narrow scope) with a second, orthogonal catalog of statutes a
  company generally must track for compliance. Mirrors
  cloud-itonami-iso3166-jpn/-usa's `statute.facts` (ADR-2607141700,
  cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL legislation.gov.uk URL -- never
  fabricated. A law not in this table has NO spec-basis, full stop;
  extend `catalog`, do not invent an id/url. Title and chapter number for
  every entry below were independently WebFetch-verified against the
  live legislation.gov.uk page on 2026-07-14 (unlike Japan's e-Gov and
  the US's uscode.house.gov, legislation.gov.uk rendered directly).")

(def catalog
  "iso3 -> vector of statute entries."
  {"GBR"
   [{:statute/id "gbr.companies-act-2006"
     :statute/title "Companies Act 2006"
     :statute/jurisdiction "GBR"
     :statute/kind :law
     :statute/law-number "2006 c. 46"
     :statute/url "https://www.legislation.gov.uk/ukpga/2006/46/contents"
     :statute/url-provenance :official-legislation-gov-uk
     :statute/enacted-date "2006-11-08"
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "gbr.data-protection-act-2018"
     :statute/title "Data Protection Act 2018"
     :statute/jurisdiction "GBR"
     :statute/kind :law
     :statute/law-number "2018 c. 12"
     :statute/url "https://www.legislation.gov.uk/ukpga/2018/12/contents"
     :statute/url-provenance :official-legislation-gov-uk
     :statute/enacted-date "2018-05-23"
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:data-protection :privacy}}
    {:statute/id "gbr.employment-rights-act-1996"
     :statute/title "Employment Rights Act 1996"
     :statute/jurisdiction "GBR"
     :statute/kind :law
     :statute/law-number "1996 c. 18"
     :statute/url "https://www.legislation.gov.uk/ukpga/1996/18/contents"
     :statute/url-provenance :official-legislation-gov-uk
     :statute/enacted-date "1996-05-22"
     :statute/retrieved-at "2026-07-14"
     :statute/topic #{:labor :employment}}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gbr statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "GBR")) " GBR statutes seeded with an "
                 "official legislation.gov.uk citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
