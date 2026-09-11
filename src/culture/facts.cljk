(ns culture.facts
  "Country-level regional-culture catalog for the United Kingdom (GBR) --
  national dishes, protected products, beverages, crafts, festivals and
  heritage sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"GBR"
   [{:culture/id "gbr.dish.fish-and-chips"
     :culture/name "Fish and chips"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Hot dish of battered and fried fish served with chips, often considered the national dish of the United Kingdom; it originated in England in the 19th century."
     :culture/url "https://en.wikipedia.org/wiki/Fish_and_chips"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.dish.full-breakfast"
     :culture/name "Full breakfast"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Substantial cooked breakfast meal often made in Great Britain and Ireland, with regional variants including the Full English, Full Scottish and Full Welsh."
     :culture/url "https://en.wikipedia.org/wiki/Full_breakfast"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.dish.sunday-roast"
     :culture/name "Sunday roast"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "British dish traditionally eaten on Sunday, consisting of roast meat, roast or mashed potatoes and accompaniments such as Yorkshire pudding and gravy."
     :culture/url "https://en.wikipedia.org/wiki/Sunday_roast"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.dish.haggis"
     :culture/name "Haggis"
     :culture/country "GBR"
     :culture/kind :dish
     :culture/summary "Savoury pudding containing sheep's pluck minced with onion, oatmeal, suet and seasonings, strongly associated with Scotland and considered its national dish."
     :culture/url "https://en.wikipedia.org/wiki/Haggis"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.beverage.scotch-whisky"
     :culture/name "Scotch whisky"
     :culture/country "GBR"
     :culture/kind :beverage
     :culture/summary "Regulated spirit produced in Scotland that must meet strict legal standards, including minimum ageing requirements and production methods."
     :culture/url "https://en.wikipedia.org/wiki/Scotch_whisky"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.product.stilton"
     :culture/name "Stilton cheese"
     :culture/country "GBR"
     :culture/kind :product
     :culture/summary "English blue or white cheese with protected designation of origin (PDO) status, made in Derbyshire, Leicestershire and Nottinghamshire."
     :culture/url "https://en.wikipedia.org/wiki/Stilton_cheese"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.product.cornish-pasty"
     :culture/name "Cornish pasty"
     :culture/country "GBR"
     :culture/kind :product
     :culture/summary "British baked turnover filled with meat and vegetables, particularly associated with Cornwall; the traditional Cornish pasty has held Protected Geographical Indication (PGI) status since 2011."
     :culture/url "https://en.wikipedia.org/wiki/Pasty"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.craft.harris-tweed"
     :culture/name "Harris tweed"
     :culture/country "GBR"
     :culture/kind :craft
     :culture/summary "Tweed cloth handwoven by islanders at their homes in the Outer Hebrides of Scotland, with its definition and standards enshrined in the Harris Tweed Act 1993."
     :culture/url "https://en.wikipedia.org/wiki/Harris_tweed"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.festival.notting-hill-carnival"
     :culture/name "Notting Hill Carnival"
     :culture/country "GBR"
     :culture/kind :festival
     :culture/summary "Annual Caribbean street festival held in London during the August Bank Holiday weekend since 1966, one of the world's largest street festivals."
     :culture/url "https://en.wikipedia.org/wiki/Notting_Hill_Carnival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gbr.heritage.stonehenge"
     :culture/name "Stonehenge"
     :culture/country "GBR"
     :culture/kind :heritage
     :culture/summary "Prehistoric megalithic monument on Salisbury Plain in Wiltshire, England, designated a UNESCO World Heritage Site in 1986."
     :culture/url "https://en.wikipedia.org/wiki/Stonehenge"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-iso3166-gbr culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "GBR"))
                 " GBR entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
